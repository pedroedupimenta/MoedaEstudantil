package br.com.moedaestudantil.controller;

import br.com.moedaestudantil.model.*;
import br.com.moedaestudantil.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/instituicoes")
public class InstituicaoController {

    private final InstituicaoRepository instituicoes;
    private final CursoRepository cursos;

    public InstituicaoController(InstituicaoRepository instituicoes, CursoRepository cursos) {
        this.instituicoes = instituicoes;
        this.cursos = cursos;
    }

    @GetMapping
    public List<Map<String, Object>> listar() {
        return instituicoes.findAll().stream()
            .map(i -> Map.<String, Object>of("id", i.getId(), "nome", i.getNome()))
            .toList();
    }

    @GetMapping("/{id}/cursos")
    public List<Map<String, Object>> cursos(@PathVariable Long id) {
        return cursos.findByInstituicaoId(id).stream()
            .map(c -> Map.<String, Object>of("id", c.getId(), "nome", c.getNome()))
            .toList();
    }
}
