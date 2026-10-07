# Diagrama de Casos de Uso — Sprint 01

## Atores

- **Aluno:** participa do programa de mérito, recebe moedas e troca por vantagens.
- **Professor:** recebe moedas semestrais e distribui aos alunos.
- **Empresa Parceira:** cadastra vantagens que poderão ser resgatadas pelos alunos.
- **Instituição de Ensino:** participa do sistema e fornece os professores cadastrados.
- **Serviço de E-mail:** responsável pelo envio das notificações.
- **Sistema:** realiza automaticamente algumas operações, como geração de códigos e
  crédito semestral de moedas.

## Diagrama

```mermaid
flowchart LR

    Aluno["Aluno"]
    Professor["Professor"]
    Empresa["Empresa Parceira"]
    Instituicao["Instituição de Ensino"]
    Email["Serviço de E-mail"]

    subgraph Sistema["Sistema de Moeda Estudantil"]

        UC1(("Realizar cadastro"))
        UC2(("Realizar login"))
        UC3(("Consultar saldo"))
        UC4(("Consultar extrato"))

        UC5(("Receber moedas"))
        UC6(("Enviar moedas"))
        UC7(("Informar motivo do reconhecimento"))

        UC8(("Consultar vantagens"))
        UC9(("Resgatar vantagem"))
        UC10(("Gerar código do cupom"))
        UC11(("Enviar cupom por e-mail"))
        UC12(("Notificar parceiro"))

        UC13(("Cadastrar empresa"))
        UC14(("Cadastrar vantagem"))
        UC15(("Definir custo da vantagem"))

        UC16(("Cadastrar instituição"))
        UC17(("Cadastrar professores"))
        UC18(("Creditar 1.000 moedas por semestre"))

    end

    Aluno --> UC1
    Aluno --> UC2
    Aluno --> UC3
    Aluno --> UC4
    Aluno --> UC8
    Aluno --> UC9

    Professor --> UC2
    Professor --> UC3
    Professor --> UC4
    Professor --> UC6

    Empresa --> UC1
    Empresa --> UC2
    Empresa --> UC13
    Empresa --> UC14

    Instituicao --> UC16
    Instituicao --> UC17

    UC6 -.->|inclui| UC7
    UC9 -.->|inclui| UC10
    UC9 -.->|inclui| UC11
    UC9 -.->|inclui| UC12

    Professor --> UC18
    UC18 -.->|adiciona| UC5

    Email --> UC11
    Email --> UC12
