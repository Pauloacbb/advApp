package com.api.advApp.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import jakarta.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    @NotBlank
    String oab;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String password;
}
