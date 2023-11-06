package com.api.advApp.dtos;


import com.api.advApp.models.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

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

    @Length(min = 3, max = 200)
    @NotBlank
    private String clienteNome;
    @Length(min = 3, max = 10)
    @NotBlank
    private String status = "Ativo";

    private UserModel user;

}