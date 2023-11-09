package com.api.advApp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@SQLDelete(sql = "UPDATE TB_PROCESSO set status = 'inativo'WHERE id =?")
@Where(clause = "status = 'Ativo'")
@Table(name = "TB_PROCESSO")
public class ProcessoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private Long id;
    @Column(nullable = false)
    private Integer numero;
    @Column(nullable = false)
    private Integer digito;
    @Column(nullable = false)
    private String ano;
    @Column(nullable = false)
    private Integer justica;
    @Column(nullable = false)
    private Integer tribunal;
    @Column(nullable = false)
    private Integer vara;

    @Column(length = 200, nullable = false)
    private String clienteNome;
    @Pattern(regexp = "Ativo|Inativos")
    @Column(length = 10, nullable = false)
    private String status = "Ativo";

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = true)
//    private UserModel user;

}
