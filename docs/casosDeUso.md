
```mermaid
flowchart LR
    Aluno(["👤 Aluno"])
    Professor(["👤 Professor"])
    Empresa(["👤 Empresa Parceira"])
    Email(["✉️ Serviço de Email"])

    subgraph Sistema["Sistema de Moeda Estudantil"]
        UC1([Realizar autenticação])
        UC2([Cadastrar aluno])
        UC3([Cadastrar empresa parceira])
        UC4([Consultar extrato])
        UC5([Enviar moedas a aluno])
        UC6([Cadastrar vantagem])
        UC7([Listar vantagens])
        UC8([Resgatar vantagem])
        UC9([Notificar recebimento de moedas])
        UC10([Enviar cupom ao aluno])
        UC11([Enviar email de conferência à empresa])
        UC12([Creditar 1.000 moedas semestrais])
        UC13([Selecionar instituição de ensino])
        UC14([Gerenciar vantagens: editar/excluir])
    end

    Aluno --- UC2
    Aluno --- UC1
    Aluno --- UC4
    Aluno --- UC7
    Aluno --- UC8

    Professor --- UC1
    Professor --- UC4
    Professor --- UC5

    Empresa --- UC3
    Empresa --- UC1
    Empresa --- UC6
    Empresa --- UC14

    UC2 -. "«include»" .-> UC13
    UC5 -. "«include»" .-> UC1
    UC8 -. "«include»" .-> UC1
    UC5 -. "«include»" .-> UC9
    UC8 -. "«include»" .-> UC10
    UC8 -. "«include»" .-> UC11
    UC8 -. "«include»" .-> UC7

    UC9 --- Email
    UC10 --- Email
    UC11 --- Email
    UC12 --- Sistema
