package br.com.moedaestudantil.service;

import br.com.moedaestudantil.dto.*;
import br.com.moedaestudantil.exception.*;
import br.com.moedaestudantil.model.*;
import br.com.moedaestudantil.repository.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunos;
    private final InstituicaoRepository instituicoes;
    private final CursoRepository cursos;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AlunoService(AlunoRepository alunos, InstituicaoRepository instituicoes, CursoRepository cursos) {
        this.alunos = alunos;
        this.instituicoes = instituicoes;
        this.cursos = cursos;
    }

    @Transactional
    public AlunoResponse criar(AlunoRequest req) {
        if (req.senha() == null || req.senha().length() < 6)
            throw new IllegalArgumentException("A senha deve ter ao menos 6 caracteres");
        if (alunos.existsByCpf(req.cpf())) throw new ConflictException("CPF já cadastrado");
        if (alunos.existsByEmail(req.email())) throw new ConflictException("Email já cadastrado");
        if (alunos.existsByLogin(req.login())) throw new ConflictException("Login já em uso");

        Aluno a = new Aluno();
        a.setSenhaHash(encoder.encode(req.senha()));
        preencher(a, req);
        return toResponse(alunos.save(a));
    }

    @Transactional(readOnly = true)
    public List<AlunoResponse> listar() {
        return alunos.findAll().stream().map(this::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public AlunoResponse buscar(Long id) {
        return toResponse(obter(id));
    }

    @Transactional
    public AlunoResponse atualizar(Long id, AlunoRequest req) {
        Aluno a = obter(id);
        if (!a.getCpf().equals(req.cpf()) && alunos.existsByCpf(req.cpf()))
            throw new ConflictException("CPF já cadastrado");
        if (!a.getEmail().equals(req.email()) && alunos.existsByEmail(req.email()))
            throw new ConflictException("Email já cadastrado");
        if (!a.getLogin().equals(req.login()) && alunos.existsByLogin(req.login()))
            throw new ConflictException("Login já em uso");

        if (req.senha() != null && !req.senha().isBlank()) {
            if (req.senha().length() < 6)
                throw new IllegalArgumentException("A senha deve ter ao menos 6 caracteres");
            a.setSenhaHash(encoder.encode(req.senha()));
        }
        preencher(a, req);
        return toResponse(alunos.save(a));
    }

    @Transactional
    public void remover(Long id) {
        alunos.delete(obter(id));
    }

    // ---- auxiliares ----
    private Aluno obter(Long id) {
        return alunos.findById(id).orElseThrow(() -> new NotFoundException("Aluno não encontrado"));
    }

    private void preencher(Aluno a, AlunoRequest req) {
        InstituicaoEnsino inst = instituicoes.findById(req.instituicaoId())
            .orElseThrow(() -> new NotFoundException("Instituição não encontrada"));
        Curso curso = cursos.findById(req.cursoId())
            .orElseThrow(() -> new NotFoundException("Curso não encontrado"));
        if (!curso.getInstituicao().getId().equals(inst.getId()))
            throw new IllegalArgumentException("O curso não pertence à instituição selecionada");

        a.setNome(req.nome());
        a.setEmail(req.email());
        a.setLogin(req.login());
        a.setCpf(req.cpf());
        a.setRg(req.rg());
        a.setEndereco(req.endereco());
        a.setInstituicao(inst);
        a.setCurso(curso);
    }

    private AlunoResponse toResponse(Aluno a) {
        return new AlunoResponse(a.getId(), a.getNome(), a.getEmail(), a.getLogin(),
            a.getCpf(), a.getRg(), a.getEndereco(), a.getSaldoMoedas(),
            a.getInstituicao().getId(), a.getInstituicao().getNome(),
            a.getCurso().getId(), a.getCurso().getNome());
    }
}
