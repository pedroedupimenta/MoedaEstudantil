package br.com.moedaestudantil.dto;

public record AlunoResponse(
    Long id, String nome, String email, String login,
    String cpf, String rg, String endereco, int saldoMoedas,
    Long instituicaoId, String instituicao, Long cursoId, String curso
) {}
