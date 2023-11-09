package com.api.advApp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_USER")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    String oab;
    @Column(nullable = false)
    String password;
}