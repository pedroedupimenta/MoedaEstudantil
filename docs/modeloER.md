```mermaid
erDiagram
    INSTITUICAO ||--o{ CURSO : oferece
    INSTITUICAO ||--o{ DEPARTAMENTO : possui
    INSTITUICAO ||--o{ PROFESSOR : "pertence a"
    INSTITUICAO ||--o{ ALUNO : "estuda em"
    DEPARTAMENTO ||--o{ PROFESSOR : vincula
    CURSO ||--o{ ALUNO : cursa

    USUARIO ||--o| ALUNO : "é um"
    USUARIO ||--o| PROFESSOR : "é um"
    USUARIO ||--o| EMPRESA_PARCEIRA : "é um"

    EMPRESA_PARCEIRA ||--o{ VANTAGEM : oferece
    PROFESSOR ||--o{ TRANSACAO : "envia (tipo ENVIO)"
    ALUNO ||--o{ TRANSACAO : "recebe/resgata"
    VANTAGEM ||--o{ TRANSACAO : "referenciada em (tipo RESGATE)"
    TRANSACAO ||--o| CUPOM : gera

    USUARIO {
        bigint id PK
        varchar nome
        varchar email UK
        varchar login UK
        varchar senha_hash
    }
    ALUNO {
        bigint id PK, FK
        varchar cpf UK
        varchar rg
        varchar endereco
        int saldo_moedas
        bigint instituicao_id FK
        bigint curso_id FK
    }
    PROFESSOR {
        bigint id PK, FK
        varchar cpf UK
        int saldo_moedas
        bigint instituicao_id FK
        bigint departamento_id FK
    }
    EMPRESA_PARCEIRA {
        bigint id PK, FK
        varchar cnpj UK
        varchar nome_fantasia
    }
    INSTITUICAO {
        bigint id PK
        varchar nome UK
    }
    DEPARTAMENTO {
        bigint id PK
        varchar nome
        bigint instituicao_id FK
    }
    CURSO {
        bigint id PK
        varchar nome
        bigint instituicao_id FK
    }
    VANTAGEM {
        bigint id PK
        varchar nome
        varchar descricao
        varchar foto
        int custo_moedas
        boolean ativa
        bigint empresa_id FK
    }
    TRANSACAO {
        bigint id PK
        varchar tipo "ENVIO ou RESGATE"
        timestamp data
        int valor
        varchar motivo "só ENVIO"
        bigint professor_id FK "só ENVIO"
        bigint aluno_id FK
        bigint vantagem_id FK "só RESGATE"
    }
    CUPOM {
        bigint id PK
        varchar codigo UK
        timestamp data_emissao
        boolean utilizado
        bigint transacao_id FK
    }participa
