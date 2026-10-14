package br.com.moedaestudantil.repository;

import br.com.moedaestudantil.model.InstituicaoEnsino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstituicaoRepository extends JpaRepository<InstituicaoEnsino, Long> {}
