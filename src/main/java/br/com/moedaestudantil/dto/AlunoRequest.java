package br.com.moedaestudantil.dto;

import jakarta.validation.constraints.*;

public record AlunoRequest(
    @NotBlank String nome,
    @NotBlank @Email String email,
    @NotBlank @Size(min = 4) String login,
    String senha,                       // obrigatória na criação; opcional na edição
    @NotBlank @Pattern(regexp = "\\d{11}", message = "CPF deve ter 11 dígitos") String cpf,
    @NotBlank String rg,
    @NotBlank String endereco,
    @NotNull Long instituicaoId,
    @NotNull Long cursoId
) {}
