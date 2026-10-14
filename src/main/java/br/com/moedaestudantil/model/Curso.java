package br.com.moedaestudantil.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "curso")
@Getter @Setter
public class Curso {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "instituicao_id")
    private InstituicaoEnsino instituicao;
}
