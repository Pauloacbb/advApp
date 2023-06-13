package com.api.advApp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
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
    @Column(nullable = false)
    private String clienteNome;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false)
    private UserModel user;

}
