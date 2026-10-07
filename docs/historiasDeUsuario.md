# Histórias de Usuário 

## HU01 — Cadastro do aluno

**Como aluno**, quero realizar meu cadastro no sistema informando meus dados
pessoais, instituição de ensino e curso, **para** poder participar do programa
de mérito estudantil.

### Critérios de aceitação

- O sistema deve solicitar nome.
- Deve solicitar e-mail.
- Deve solicitar CPF e RG.
- Deve solicitar endereço.
- Deve permitir selecionar uma instituição cadastrada.
- Deve informar o curso.
- O aluno deve possuir login e senha.

---

## HU02 — Login

**Como aluno, professor ou empresa parceira**, quero realizar login utilizando
minhas credenciais, **para** acessar as funcionalidades do sistema.

### Critérios de aceitação

- O usuário deve informar suas credenciais.
- O sistema deve validar as credenciais.
- Usuários não autenticados não podem acessar funcionalidades protegidas.

---

## HU03 — Consultar saldo

**Como aluno ou professor**, quero consultar meu saldo de moedas, **para** saber
quantas moedas tenho disponíveis.

### Critérios de aceitação

- O saldo atual deve ser apresentado.
- O saldo deve ser atualizado após cada movimentação.

---

## HU04 — Consultar extrato do aluno

**Como aluno**, quero consultar meu extrato, **para** visualizar as moedas
recebidas e utilizadas.

### Critérios de aceitação

- Devem aparecer moedas recebidas.
- Devem aparecer moedas utilizadas em resgates.
- Cada movimentação deve apresentar data e quantidade.

---

## HU05 — Consultar extrato do professor

**Como professor**, quero consultar meu extrato, **para** visualizar as moedas
que distribuí aos alunos.

### Critérios de aceitação

- O sistema deve mostrar os envios realizados.
- Deve informar o aluno que recebeu as moedas.
- Deve informar a quantidade.
- Deve apresentar o motivo do reconhecimento.

---

## HU06 — Distribuir moedas

**Como professor**, quero enviar moedas para um aluno, **para** reconhecer seu
mérito, participação ou bom comportamento.

### Critérios de aceitação

- O professor deve possuir saldo suficiente.
- Deve selecionar o aluno.
- Deve informar a quantidade de moedas.
- Deve informar obrigatoriamente o motivo.
- O saldo do professor deve ser reduzido.
- O saldo do aluno deve ser aumentado.

---

## HU07 — Notificar aluno

**Como aluno**, quero receber um e-mail quando receber moedas, **para** ser
informado sobre o reconhecimento recebido.

### Critérios de aceitação

- Um e-mail deve ser enviado após o recebimento.
- O e-mail deve informar a quantidade recebida.
- O e-mail deve informar o motivo do reconhecimento.

---

## HU08 — Recebimento semestral de moedas

**Como professor**, quero receber 1.000 moedas a cada semestre, **para** poder
distribuí-las aos alunos.

### Critérios de aceitação

- A cada semestre devem ser adicionadas 1.000 moedas.
- Moedas não utilizadas devem permanecer no saldo.
- As novas 1.000 moedas devem ser acumuladas ao saldo existente.

---

## HU09 — Consultar vantagens

**Como aluno**, quero visualizar as vantagens disponíveis, **para** escolher
em qual desejo utilizar minhas moedas.

### Critérios de aceitação

- O sistema deve listar as vantagens disponíveis.
- Cada vantagem deve apresentar descrição.
- Deve apresentar o custo em moedas.
- Deve apresentar a foto do produto ou benefício.

---

## HU10 — Resgatar vantagem

**Como aluno**, quero trocar minhas moedas por uma vantagem, **para** usufruir
de produtos ou descontos oferecidos pelas empresas parceiras.

### Critérios de aceitação

- O aluno deve possuir moedas suficientes.
- O sistema deve descontar o valor da vantagem.
- Deve registrar a transação.
- Deve gerar um código para o resgate.
- Deve enviar o cupom ao aluno.
- Deve notificar a empresa parceira.

---

## HU11 — Cadastro de empresa parceira

**Como empresa**, quero realizar meu cadastro no sistema, **para** poder oferecer
vantagens aos alunos.

### Critérios de aceitação

- A empresa deve possuir dados cadastrais.
- Deve possuir login e senha.
- Deve poder cadastrar vantagens.

---

## HU12 — Cadastro de vantagem

**Como empresa parceira**, quero cadastrar vantagens, informando descrição,
foto e custo, **para** disponibilizá-las aos alunos.

### Critérios de aceitação

- Deve ser possível cadastrar uma descrição.
- Deve ser possível adicionar uma foto.
- Deve ser definido o custo em moedas.
- A vantagem deve ficar disponível para consulta dos alunos.

---

## HU13 — Notificação da empresa

**Como empresa parceira**, quero receber um e-mail quando um aluno resgatar
uma vantagem, **para** poder confirmar a utilização do benefício.

### Critérios de aceitação

- O e-mail deve ser enviado após o resgate.
- O e-mail deve possuir o código do resgate.
- O código deve permitir identificar a troca.
