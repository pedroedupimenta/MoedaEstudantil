```mermaid
classDiagram
    class Usuario {
        <<abstract>>
        -Long id
        -String nome
        -String email
        -String login
        -String senhaHash
        +autenticar(login, senha) boolean
    }

    class Aluno {
        -String cpf
        -String rg
        -String endereco
        -int saldoMoedas
        +consultarExtrato() List~Transacao~
        +resgatarVantagem(Vantagem v) Cupom
        +receberMoedas(int valor)
    }

    class Professor {
        -String cpf
        -int saldoMoedas
        +enviarMoedas(Aluno a, int valor, String motivo) TransacaoEnvio
        +consultarExtrato() List~Transacao~
        +creditarSemestre()
    }

    class EmpresaParceira {
        -String cnpj
        -String nomeFantasia
        +cadastrarVantagem(Vantagem v)
        +editarVantagem(Vantagem v)
        +removerVantagem(Long id)
    }

    class InstituicaoEnsino {
        -Long id
        -String nome
    }

    class Departamento {
        -Long id
        -String nome
    }

    class Curso {
        -Long id
        -String nome
    }

    class Vantagem {
        -Long id
        -String descricao
        -String foto
        -int custoMoedas
        -boolean ativa
    }

    class Transacao {
        <<abstract>>
        -Long id
        -LocalDateTime data
        -int valor
    }

    class TransacaoEnvio {
        -String motivo
    }

    class TransacaoResgate {
    }

    class Cupom {
        -String codigo
        -LocalDateTime dataEmissao
        -boolean utilizado
    }

    class EmailService {
        <<service>>
        +notificarRecebimentoMoedas(TransacaoEnvio t)
        +enviarCupomAluno(Cupom c)
        +enviarConferenciaEmpresa(Cupom c)
    }

    Usuario <|-- Aluno
    Usuario <|-- Professor
    Usuario <|-- EmpresaParceira

    InstituicaoEnsino "1" --> "*" Departamento : possui
    InstituicaoEnsino "1" --> "*" Curso : oferece
    Departamento "1" --> "*" Professor : vincula
    Professor "*" --> "1" InstituicaoEnsino : pertence a
    Aluno "*" --> "1" InstituicaoEnsino : estuda em
    Aluno "*" --> "1" Curso : cursa

    EmpresaParceira "1" --> "*" Vantagem : oferece

    Transacao <|-- TransacaoEnvio
    Transacao <|-- TransacaoResgate
    Professor "1" --> "*" TransacaoEnvio : realiza
    Aluno "1" --> "*" TransacaoEnvio : recebe
    Aluno "1" --> "*" TransacaoResgate : realiza
    TransacaoResgate "*" --> "1" Vantagem : refere-se a
    TransacaoResgate "1" --> "1" Cupom : gera
    Cupom "*" --> "1" EmpresaParceira : conferido por

    EmailService ..> TransacaoEnvio
    EmailService ..> Cupom
