package com.example.universidadeESN3.dto;

import com.example.universidadeESN3.entity.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AlunoCreateDTO {

    @NotNull(message = "A matrícula é obrigatória.")
    private Long matricula;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres.")
    private String nome;

    @NotNull(message = "O gênero é obrigatório.")
    private Genero genero;

}
