```mermaid
flowchart TB
    subgraph Cliente["Cliente (Navegador)"]
        UI["Views estáticas<br/>index.html, alunos.html,<br/>empresas.html, style.css"]
    end

    subgraph Servidor["Aplicação Spring Boot (MVC)"]
        subgraph Controllers["Controller (REST)"]
            CAluno["AlunoController<br/>/api/alunos"]
            CEmpresa["EmpresaController<br/>/api/empresas"]
            CInst["InstituicaoController<br/>/api/instituicoes"]
            EH["GlobalExceptionHandler"]
        end

        DTO["DTOs<br/>AlunoRequest/Response<br/>EmpresaRequest/Response"]

        subgraph Services["Service (regras de negócio)"]
            SAluno["AlunoService"]
            SEmpresa["EmpresaService"]
            ENC["BCryptPasswordEncoder"]
        end

        subgraph Models["Model"]
            subgraph Repos["Repository (DAO / Spring Data JPA)"]
                RAluno["AlunoRepository"]
                REmpresa["EmpresaRepository"]
                RInst["InstituicaoRepository"]
                RCurso["CursoRepository"]
            end
            MEnt["Entidades JPA<br/>Usuario, Aluno, EmpresaParceira,<br/>InstituicaoEnsino, Curso"]
        end

        subgraph Sprint3["Previstos para Sprint 3"]
            S3A["AuthController / AuthService"]
            S3B["ProfessorController / MoedaService"]
            S3C["VantagemController / ResgateService"]
            S3D["EmailService / SemestreScheduler"]
        end
    end

    ORM["Hibernate (ORM)"]
    DB[("H2 em arquivo (dev)<br/>PostgreSQL (prod)")]
    SMTP["Servidor SMTP"]

    UI -->|HTTP / JSON| CAluno
    UI -->|HTTP / JSON| CEmpresa
    UI -->|HTTP / JSON| CInst

    CAluno --> DTO
    CEmpresa --> DTO
    CAluno --> SAluno
    CEmpresa --> SEmpresa
    CInst --> RInst
    CInst --> RCurso

    SAluno --> ENC
    SEmpresa --> ENC
    SAluno --> RAluno
    SAluno --> RInst
    SAluno --> RCurso
    SEmpresa --> REmpresa

    RAluno --> MEnt
    REmpresa --> MEnt
    RInst --> MEnt
    RCurso --> MEnt

    MEnt --> ORM
    ORM -->|JDBC| DB

    EH -.->|trata exceções| CAluno
    EH -.->|trata exceções| CEmpresa

    S3D -.->|SMTP| SMTP
