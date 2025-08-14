# Sistema de Controle de Idade Gestacional Corrigida

Este sistema foi criado para ajudar no acompanhamento de crianças que nasceram antes do tempo (prematuras).  
Ele calcula automaticamente a **idade gestacional corrigida** — um ajuste da idade real da criança levando em conta o quanto antes ela nasceu — e mantém um registro organizado para facilitar o acompanhamento até a alta.

## 💡 Por que esse sistema foi criado?

Quando um bebê nasce prematuro, sua idade "de calendário" não reflete exatamente o seu desenvolvimento.  
Por exemplo, um bebê que nasceu dois meses antes do previsto pode ter um desenvolvimento diferente de outro que nasceu no tempo certo.  
A **idade corrigida** ajuda médicos e profissionais de saúde a avaliar o crescimento e desenvolvimento de forma mais justa.

Este sistema foi desenvolvido especialmente para uso no ambiente de trabalho da minha noiva, tornando o cálculo mais rápido e o registro mais organizado.

## 📌 O que o sistema faz?

- **Cadastrar crianças** com informações como nome, data de nascimento e semanas de gestação no nascimento.
- **Editar informações** caso seja necessário corrigir ou atualizar dados.
- **Excluir registros** quando a criança recebe alta.
- **Calcular automaticamente** a idade gestacional corrigida sempre que um registro é visualizado.
- **Manter os dados salvos** em um banco de dados seguro.
- **Interface simples** para uso direto no navegador.

## 🖥 Como funciona na prática?

1. O profissional abre o sistema no navegador.
2. Clica em **"Cadastrar Criança"** e insere os dados solicitados.
3. Sempre que precisar, pode editar ou remover o cadastro.
4. O sistema mostra a **idade corrigida** de forma automática, sem necessidade de cálculos manuais.

## ⚙️ Como ele foi feito?

Mesmo sendo fácil de usar para quem acessa, por trás existe bastante tecnologia:

- **Backend (lógica e cálculos):** Java + Spring Boot (API REST)
- **Frontend (parte visual):** Angular
- **Banco de dados:** PostgreSQL
- **Hospedagem:** Railway

## 🌐 Onde ele funciona?

O sistema é **web**, ou seja, pode ser acessado de qualquer computador ou celular com internet e navegador moderno.
