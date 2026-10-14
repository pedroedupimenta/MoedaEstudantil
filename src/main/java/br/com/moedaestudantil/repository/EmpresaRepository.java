package br.com.moedaestudantil.repository;

import br.com.moedaestudantil.model.EmpresaParceira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<EmpresaParceira, Long> {
    boolean existsByCnpj(String cnpj);
    boolean existsByEmail(String email);
    boolean existsByLogin(String login);
}
