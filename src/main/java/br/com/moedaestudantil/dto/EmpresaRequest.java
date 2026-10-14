package br.com.moedaestudantil.dto;

import jakarta.validation.constraints.*;

public record EmpresaRequest(
    @NotBlank String nomeFantasia,
    @NotBlank @Email String email,
    @NotBlank @Size(min = 4) String login,
    String senha,                       // obrigatória na criação; opcional na edição
    @NotBlank @Pattern(regexp = "\\d{14}", message = "CNPJ deve ter 14 dígitos") String cnpj
) {}
