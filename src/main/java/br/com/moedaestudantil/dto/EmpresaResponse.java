package br.com.moedaestudantil.dto;

public record EmpresaResponse(
    Long id, String nomeFantasia, String email, String login, String cnpj
) {}
