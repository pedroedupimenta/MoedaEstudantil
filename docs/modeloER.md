erDiagram

    USUARIO {
        BIGINT id PK
        VARCHAR nome
        VARCHAR email UK
        VARCHAR senha
        VARCHAR cpf UK
    }

    ALUNO {
        BIGINT usuario_id PK, FK
        VARCHAR rg
        VARCHAR endereco
        VARCHAR curso
        DECIMAL saldo
        BIGINT instituicao_id FK
    }

    PROFESSOR {
        BIGINT usuario_id PK, FK
        VARCHAR departamento
        DECIMAL saldo
        BIGINT instituicao_id FK
    }

    EMPRESA_PARCEIRA {
        BIGINT usuario_id PK, FK
        VARCHAR cnpj UK
        VARCHAR endereco
    }

    INSTITUICAO_ENSINO {
        BIGINT id PK
        VARCHAR nome
        VARCHAR endereco
    }

    VANTAGEM {
        BIGINT id PK
        VARCHAR nome
        TEXT descricao
        VARCHAR foto
        DECIMAL custo_moedas
        BOOLEAN ativa
        BIGINT empresa_id FK
    }

    TRANSACAO {
        BIGINT id PK
        DATETIME data
        INT quantidade
        VARCHAR tipo
        TEXT motivo
        BIGINT professor_id FK
        BIGINT aluno_id FK
    }

    RESGATE {
        BIGINT id PK
        DATETIME data
        VARCHAR codigo UK
        INT quantidade_moedas
        VARCHAR status
        BIGINT aluno_id FK
        BIGINT vantagem_id FK
    }

    USUARIO ||--o| ALUNO : especializacao
    USUARIO ||--o| PROFESSOR : especializacao
    USUARIO ||--o| EMPRESA_PARCEIRA : especializacao

    INSTITUICAO_ENSINO ||--o{ ALUNO : matricula
    INSTITUICAO_ENSINO ||--o{ PROFESSOR : vincula

    EMPRESA_PARCEIRA ||--o{ VANTAGEM : oferece

    PROFESSOR ||--o{ TRANSACAO : realiza
    ALUNO ||--o{ TRANSACAO : recebe

    ALUNO ||--o{ RESGATE : realiza
    VANTAGEM ||--o{ RESGATE : participa
