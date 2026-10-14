package br.com.moedaestudantil.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "empresa_parceira")
@PrimaryKeyJoinColumn(name = "id")
@Getter @Setter
public class EmpresaParceira extends Usuario {

    @Column(nullable = false, unique = true, length = 14)
    private String cnpj;

    @Column(name = "nome_fantasia", nullable = false)
    private String nomeFantasia;
}
