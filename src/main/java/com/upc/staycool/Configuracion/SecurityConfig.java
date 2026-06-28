package com.upc.staycool.Configuracion;

import com.upc.staycool.Seguridad.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    // 1. El encriptador que Spring pide para el AuthServicio
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2. El motor que verifica el correo y la contraseÃ±a en el Login
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // 3. La BÃ³veda Fusionada (Tu Seguridad JWT + El Swagger de JosÃ©)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // 1. Deshabilitar CSRF (Obligatorio para APIs REST con JWT)
                .csrf(AbstractHttpConfigurer::disable)

                // 2. Deshabilitar CORS o configurarlo para permitir Postman (Opcional pero recomendado)
                .cors(cors -> cors.configurationSource(request -> {
                    var corsConfiguration = new org.springframework.web.cors.CorsConfiguration();
                    corsConfiguration.setAllowedOrigins(java.util.List.of("*"));
                    corsConfiguration.setAllowedMethods(java.util.List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));
                    corsConfiguration.setAllowedHeaders(java.util.List.of("*"));
                    return corsConfiguration;
                }))

                // 3. Configurar sesiÃ³n Stateless
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // 4. Reglas de AutorizaciÃ³n
                .authorizeHttpRequests(auth -> auth
                        // Rutas de documentaciÃ³n (Siempre pÃºblicas)
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/api-docs/**").permitAll()

                        // Rutas de AutenticaciÃ³n (Registro y Login DEBEN ser pÃºblicas)
                        // Usamos el prefijo exacto que tienes en tu controlador
                        .requestMatchers("/api/v1/auth/register", "/api/v1/auth/login").permitAll()
                        .requestMatchers("/api/v1/auth/**").permitAll()

                        // Permitir todas las peticiones OPTIONS (CORS preflight)
                        .requestMatchers(org.springframework.http.HttpMethod.OPTIONS, "/**").permitAll()

                        // Liberamos estas temporalmente para que pruebes el flujo sin token hasta que el Login funcione
                        .requestMatchers("/api/v1/calendar/**").permitAll()
                        .requestMatchers("/api/v1/resources/**").permitAll()
                        .requestMatchers("/api/v1/psychologist/test-requests").permitAll().requestMatchers("/api/v1/psychologist/requests").permitAll()
                        .requestMatchers("/api/v1/chats/**").permitAll()
                        .requestMatchers("/ws/chat/**").permitAll()

                        // Cualquier otra ruta requiere el Token JWT
                        .anyRequest().authenticated()
                )

                // 5. Agregar tu guardia (JwtFilter)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)

                .build();
    }
}