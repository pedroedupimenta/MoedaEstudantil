package br.com.moedaestudantil.repository;

import br.com.moedaestudantil.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByInstituicaoId(Long instituicaoId);
}
