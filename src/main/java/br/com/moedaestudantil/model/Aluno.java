package br.com.moedaestudantil.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "id")
@Getter @Setter
public class Aluno extends Usuario {

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false)
    private String rg;

    @Column(nullable = false)
    private String endereco;

    @Column(name = "saldo_moedas", nullable = false)
    private int saldoMoedas = 0;

    @ManyToOne(optional = false)
    @JoinColumn(name = "instituicao_id")
    private InstituicaoEnsino instituicao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "curso_id")
    private Curso curso;
}
