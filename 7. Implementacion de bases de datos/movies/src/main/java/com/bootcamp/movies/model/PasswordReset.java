package com.bootcamp.movies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "password_resets", indexes = {
        @Index(name = "password_resets_email_index", columnList = "email"),
        @Index(name = "password_resets_token_index", columnList = "token")
})
public class PasswordReset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "created_at")
    private Instant createdAt;

}