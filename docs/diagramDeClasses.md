# Diagrama de Classes — Sprint 01

## Descrição

O diagrama apresenta as principais entidades do Sistema de Moeda Estudantil
e seus relacionamentos.

As principais entidades são:

- Usuário;
- Aluno;
- Professor;
- Empresa Parceira;
- Instituição de Ensino;
- Vantagem;
- Transação;
- Resgate;
- Notificação.

## Diagrama

```mermaid
classDiagram

    class Usuario {
        <<abstract>>
        -Long id
        -String nome
        -String email
        -String senha
        -String cpf
        +login()
        +logout()
    }

    class Aluno {
        -String rg
        -String endereco
        -String curso
        -BigDecimal saldo
        +consultarSaldo()
        +consultarExtrato()
        +resgatarVantagem()
    }

    class Professor {
        -String departamento
        -BigDecimal saldo
        +enviarMoedas()
        +consultarSaldo()
        +consultarExtrato()
    }

    class EmpresaParceira {
        -String cnpj
        -String endereco
        +cadastrarVantagem()
        +consultarResgates()
    }

    class InstituicaoEnsino {
        -Long id
        -String nome
        -String endereco
        +cadastrarProfessor()
    }

    class Vantagem {
        -Long id
        -String nome
        -String descricao
        -String foto
        -BigDecimal custoMoedas
        -Boolean ativa
        +ativar()
        +desativar()
    }

    class Transacao {
        -Long id
        -Date data
        -Integer quantidade
        -String tipo
        -String motivo
        +registrar()
    }

    class Resgate {
        -Long id
        -Date data
        -String codigo
        -Integer quantidadeMoedas
        -String status
        +gerarCodigo()
        +confirmar()
    }

    class Notificacao {
        -Long id
        -String destinatario
        -String assunto
        -String mensagem
        -Date dataEnvio
        +enviar()
    }

    Usuario <|-- Aluno
    Usuario <|-- Professor
    Usuario <|-- EmpresaParceira

    InstituicaoEnsino "1" --> "0..*" Aluno : possui
    InstituicaoEnsino "1" --> "0..*" Professor : possui

    EmpresaParceira "1" --> "0..*" Vantagem : oferece

    Professor "1" --> "0..*" Transacao : realiza
    Aluno "1" --> "0..*" Transacao : recebe

    Aluno "1" --> "0..*" Resgate : realiza
    Vantagem "1" --> "0..*" Resgate : possui

    Resgate "1" --> "1..*" Notificacao : gera
    Transacao "1" --> "0..*" Notificacao : gera
