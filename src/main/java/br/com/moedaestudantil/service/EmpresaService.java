package br.com.moedaestudantil.service;

import br.com.moedaestudantil.dto.*;
import br.com.moedaestudantil.exception.*;
import br.com.moedaestudantil.model.EmpresaParceira;
import br.com.moedaestudantil.repository.EmpresaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresas;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public EmpresaService(EmpresaRepository empresas) {
        this.empresas = empresas;
    }

    @Transactional
    public EmpresaResponse criar(EmpresaRequest req) {
        if (req.senha() == null || req.senha().length() < 6)
            throw new IllegalArgumentException("A senha deve ter ao menos 6 caracteres");
        if (empresas.existsByCnpj(req.cnpj())) throw new ConflictException("CNPJ já cadastrado");
        if (empresas.existsByEmail(req.email())) throw new ConflictException("Email já cadastrado");
        if (empresas.existsByLogin(req.login())) throw new ConflictException("Login já em uso");

        EmpresaParceira e = new EmpresaParceira();
        e.setSenhaHash(encoder.encode(req.senha()));
        preencher(e, req);
        return toResponse(empresas.save(e));
    }

    @Transactional(readOnly = true)
    public List<EmpresaResponse> listar() {
        return empresas.findAll().stream().map(this::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public EmpresaResponse buscar(Long id) {
        return toResponse(obter(id));
    }

    @Transactional
    public EmpresaResponse atualizar(Long id, EmpresaRequest req) {
        EmpresaParceira e = obter(id);
        if (!e.getCnpj().equals(req.cnpj()) && empresas.existsByCnpj(req.cnpj()))
            throw new ConflictException("CNPJ já cadastrado");
        if (!e.getEmail().equals(req.email()) && empresas.existsByEmail(req.email()))
            throw new ConflictException("Email já cadastrado");
        if (!e.getLogin().equals(req.login()) && empresas.existsByLogin(req.login()))
            throw new ConflictException("Login já em uso");

        if (req.senha() != null && !req.senha().isBlank()) {
            if (req.senha().length() < 6)
                throw new IllegalArgumentException("A senha deve ter ao menos 6 caracteres");
            e.setSenhaHash(encoder.encode(req.senha()));
        }
        preencher(e, req);
        return toResponse(empresas.save(e));
    }

    @Transactional
    public void remover(Long id) {
        empresas.delete(obter(id));
    }

    private EmpresaParceira obter(Long id) {
        return empresas.findById(id).orElseThrow(() -> new NotFoundException("Empresa não encontrada"));
    }

    private void preencher(EmpresaParceira e, EmpresaRequest req) {
        e.setNome(req.nomeFantasia());
        e.setNomeFantasia(req.nomeFantasia());
        e.setEmail(req.email());
        e.setLogin(req.login());
        e.setCnpj(req.cnpj());
    }

    private EmpresaResponse toResponse(EmpresaParceira e) {
        return new EmpresaResponse(e.getId(), e.getNomeFantasia(), e.getEmail(), e.getLogin(), e.getCnpj());
    }
}
