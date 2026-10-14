```mermaid
flowchart TB
    subgraph Cliente["Cliente (Navegador)"]
        UI["Views / Front-end<br/>(HTML, CSS, JS)"]
    end

    subgraph Servidor["Aplicação (Back-end MVC)"]
        subgraph Controllers["Controller"]
            CAuth["AuthController"]
            CAluno["AlunoController"]
            CEmpresa["EmpresaController"]
            CProf["ProfessorController"]
            CVant["VantagemController"]
            CExtrato["ExtratoController"]
        end

        subgraph Services["Serviços / Regras de Negócio"]
            SAuth["AuthService"]
            SMoeda["MoedaService<br/>(envio, saldo, crédito semestral)"]
            SResg["ResgateService<br/>(troca, geração de código)"]
            SEmail["EmailService"]
            SSched["SemestreScheduler"]
        end

        subgraph Models["Model"]
            MEnt["Entidades<br/>(Aluno, Professor, Empresa,<br/>Vantagem, Transacao, Cupom...)"]
            DAO["Repositórios / DAO (ORM)"]
        end
    end

    DB[("Banco de Dados<br/>Relacional")]
    SMTP["Servidor SMTP<br/>(Email)"]

    UI -->|HTTP/REST| CAuth
    UI --> CAluno
    UI --> CEmpresa
    UI --> CProf
    UI --> CVant
    UI --> CExtrato

    CAuth --> SAuth
    CProf --> SMoeda
    CVant --> SResg
    CAluno --> SResg
    CExtrato --> SMoeda
    CEmpresa --> DAO
    CAluno --> DAO

    SMoeda --> DAO
    SResg --> DAO
    SAuth --> DAO
    SSched --> SMoeda
    SMoeda --> SEmail
    SResg --> SEmail

    DAO --> MEnt
    DAO -->|JDBC / ORM| DB
    SEmail -->|SMTP| SMTP
