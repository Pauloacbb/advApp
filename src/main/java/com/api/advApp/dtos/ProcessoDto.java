package com.api.advApp.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record ProcessoDto(@JsonProperty("_id") Long id,
                          @NotNull  Integer numero,
                          @NotNull  Integer digito,
                          @NotNull @NotBlank String ano,
                          @NotNull  Integer justica,
                          @NotNull  Integer tribunal,
                          @NotNull  Integer vara,
                          @Length(max = 200) @NotNull @NotBlank String clienteNome
) {

}