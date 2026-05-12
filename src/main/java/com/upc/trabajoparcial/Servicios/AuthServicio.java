package com.upc.trabajoparcial.Servicios;

import com.upc.trabajoparcial.DTOs.AuthResDTO;
import com.upc.trabajoparcial.DTOs.LoginReqDTO;
import com.upc.trabajoparcial.DTOs.RegistroReqDTO;
import com.upc.trabajoparcial.Entidades.RolEntidad;
import com.upc.trabajoparcial.Entidades.UsuarioEntidad;
import com.upc.trabajoparcial.Repositorios.RolRepositorio;
import com.upc.trabajoparcial.Repositorios.UsuarioRepositorio;
import com.upc.trabajoparcial.Seguridad.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private RolRepositorio rolRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Transactional
    public AuthResDTO registrar(RegistroReqDTO dto) {
        // 1. Validar si el correo ya existe
        if (usuarioRepositorio.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Error: El correo electrónico ya está registrado.");
        }

        UsuarioEntidad nuevoUsuario = new UsuarioEntidad();
        nuevoUsuario.setName(dto.getName());
        nuevoUsuario.setEmail(dto.getEmail());
        nuevoUsuario.setTotalPoints(0);

        // 2. Encriptamos la contraseña de forma segura
        nuevoUsuario.setPasswordHash(passwordEncoder.encode(dto.getPassword()));

        // 3. Asignación de Rol Inteligente (Busca por nombre, no por ID)
        // Lógica: Si mandan rolId = 2 en el JSON, es Psicólogo. Si no mandan nada o mandan 1, es Paciente.
        String nombreABuscar = (dto.getRolId() != null && dto.getRolId() == 2L) ? "PSICOLOGO" : "PACIENTE";

        RolEntidad rolAsignado = rolRepositorio.findByName(nombreABuscar)
                .orElseThrow(() -> new RuntimeException("Error crítico: El rol " + nombreABuscar + " no existe. Revisa el DataInitializer."));

        nuevoUsuario.setRolEntidad(rolAsignado);

        // 4. Guardar usuario en la base de datos
        usuarioRepositorio.save(nuevoUsuario);

        // 5. Generar Token inmediatamente
        UserDetails userDetails = userDetailsService.loadUserByUsername(nuevoUsuario.getEmail());
        String token = jwtUtil.generarToken(userDetails);

        return new AuthResDTO(token);
    }

    public AuthResDTO login(LoginReqDTO dto) {
        // Verificación de credenciales con Spring Security
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getEmail());
        String token = jwtUtil.generarToken(userDetails);

        return new AuthResDTO(token);
    }
}