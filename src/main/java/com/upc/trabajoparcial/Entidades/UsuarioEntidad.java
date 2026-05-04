package com.upc.trabajoparcial.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RolEntidad rolEntidad;

    @Column
    private Integer pauseThresholdMinutes;

    @Column
    private Integer dailyGoalMinutes;

    @Column(columnDefinition = "integer default 0")
    private Integer totalPoints = 0;

    @CreationTimestamp
    private LocalDateTime createdAt;
}