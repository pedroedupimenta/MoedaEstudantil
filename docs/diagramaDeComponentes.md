# Diagrama de Componentes — Sprint 01

## Descrição

O sistema será desenvolvido utilizando a arquitetura MVC.

A arquitetura será dividida em:

- View;
- Controller;
- Model/Services;
- Persistência;
- Banco de Dados;
- Serviço de E-mail.

## Diagrama

```mermaid
flowchart TB

    subgraph Usuarios["Usuários"]
        A["Aluno"]
        P["Professor"]
        E["Empresa Parceira"]
    end

    subgraph Sistema["Sistema de Moeda Estudantil"]

        subgraph View["View"]
            V1["Tela de Login"]
            V2["Tela do Aluno"]
            V3["Tela do Professor"]
            V4["Tela da Empresa"]
            V5["Tela de Vantagens"]
        end

        subgraph Controller["Controller"]
            C1["LoginController"]
            C2["AlunoController"]
            C3["ProfessorController"]
            C4["EmpresaController"]
            C5["VantagemController"]
            C6["ResgateController"]
        end

        subgraph Model["Model / Services"]
            M1["AlunoService"]
            M2["ProfessorService"]
            M3["EmpresaService"]
            M4["MoedaService"]
            M5["VantagemService"]
            M6["ResgateService"]
            M7["NotificacaoService"]
        end

        subgraph Persistencia["Persistência"]
            DAO["DAO / Repository"]
            DB[("Banco de Dados")]
        end

    end

    Email["Serviço de E-mail"]

    A --> V1
    A --> V2
    A --> V5

    P --> V1
    P --> V3

    E --> V1
    E --> V4
    E --> V5

    V1 --> C1
    V2 --> C2
    V3 --> C3
    V4 --> C4
    V5 --> C5
    V5 --> C6

    C2 --> M1
    C3 --> M2
    C4 --> M3
    C5 --> M5
    C6 --> M6

    C2 --> M4
    C3 --> M4

    M1 --> DAO
    M2 --> DAO
    M3 --> DAO
    M4 --> DAO
    M5 --> DAO
    M6 --> DAO

    DAO --> DB

    M4 --> M7
    M6 --> M7

    M7 --> Email
