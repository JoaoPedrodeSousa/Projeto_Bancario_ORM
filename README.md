# Projeto Bancario com ORM

## Introdução

**Este projeto foi desenvolvido para colocar em prática os conceitos de Object-relational mapping (ORM). 
A ideia central é simular um ambiente bancário, no qual os usuários podem depositar, sacar, transferir, 
pedir emprestimos, realizar pagamentos e investimentos.**

**Para a implementação, optou-se por utilizar Java 17 em conjunto com o Framework Hibernate versão 5.6.
O Banco de Dados escolhido para armazenamento foi o PostgreSQL.**

**Este projeto possui uma versão alternativa, a qual utiliza-se [JDBC no lugar de ORM](https://github.com/JoaoPedrodeSousa/ProjetoBancario). Para saber mais, acesse:**

## Funcionalidades implementadas

- [ ] Cadastro de novas contas.
- [ ] Realizar transferências.
- [ ] Realizar depósitos.
- [ ] Realizar saques.
- [ ] Registrar investimentos.
- [ ] Solicitar empréstimos ao banco.

## Funcionalidades futuras
- [ ] Criação de diferentes tipos de contas.
- [ ] Autenticação de login para cada conta bancária.
- [ ] Implementação de limites de retirada diária para contas.
- [ ] Introdução de limites de transferência diferentes com base no tipo de conta.
- [ ] `Estrutura de dados: ` Implementação de uma fila para transações financeiras.
- [ ] Introdução de modalidades de empréstimos e cálculo de juros.
- [ ] Implementação de políticas de aprovação de empréstimos com base no tipo de conta e histórico de crédito.
- [ ] Implementação de regras de tributação sobre os rendimentos de investimentos.
- [ ] Conexão com API's de terceiros para controle de câmbio e preço de ações em tempo real.

## Dependências

**Maven**
```XML
        <dependencies>
            <dependency>
              <groupId>org.hibernate</groupId>
              <artifactId>hibernate-core</artifactId>
              <version>5.6.15.Final</version>
            </dependency>
        
            <dependency>
              <groupId>org.hibernate</groupId>
              <artifactId>hibernate-entitymanager</artifactId>
              <version>5.6.15.Final</version>
            </dependency>
        
            <dependency>
              <groupId>org.postgresql</groupId>
              <artifactId>postgresql</artifactId>
              <version>42.6.0</version>
            </dependency>
        </dependencies>
```

