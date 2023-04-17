package com.api.advApp.dtos;


import com.api.advApp.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProcessoDto {

    @NotNull
    private Integer numero;
    @NotNull
    private Integer digito;
    @NotBlank
    private String ano;
    @NotNull
    private Integer justica;
    @NotNull
    private Integer tribunal;
    @NotNull
    private Integer vara;
    @NotBlank
    private String clienteNome;

    private UserModel user;

}