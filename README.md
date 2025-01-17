# API de Catálogo (Camisetas, Cores e Marcas)

#### 👉 - [Projeto principal (shirT - e-commerce)](https://github.com/davipedro/shirT-e-commerce)
#### Esse projeto faz parte de um projeto maior de e-commerce que está em desenvolvimento.
___(A API funciona de forma independente ao projeto principal, mas foi desenvolvido voltado ao projeto maior)___

---
## Descrição do Projeto

Esse projeto abrange uma API para acesso a informações do catálogo de produto de uma loja de camisetas, tais como catalogo de cores e marcas para gereciamento de produtos.

A API fornece acesso às informações sobre as marcas (brand), cores (colors), e camisetas (shirts) referentes a loja, sendo divido em:
+ **End-points públicos:** de acesso geral, que fornece informações sobre os produtos disponíveis para venda
+ **End-points internos:** de acesso restrito, fornece funcionalidades para criação, alteração e deleção de camisetas, cores e marcas do sistema.

## Objetivo
A API foi desenvolvida para estudo das tecnologias, arquitetura e entendimento de regras de negócio de um sistema de e-commerce, sendo abordado pontos como:
+ Arquitetura REST
+ ORM
+ Transações
+ Modelagem do banco de dados;
+ Autenticação e autorização;
+ Paginação e filtros;
+ Tratamento de exceções;
+ Questões de segurança;
+ Estudo de possíveis soluções para casos de escalabilidade;
+ Testes unitários e de integração;
+ Documentação da API.

## Tecnologias utilizadas
- [React](https://pt-br.reactjs.org/) (Adicionar versão)
- [SpringBoot](https://spring.io/projects/spring-boot) (Adicionar versão)
- [Docker](https://www.docker.com/) (Adicionar versão)
- [Docker Compose](https://docs.docker.com/compose/) (Adicionar versão)

<!-- fazer um sumário para os domínios -->
# Domínios
- [Shirt](#shirt)
- [Color](#color)
- [Brand](#brand)

## Shirt
Fornece informações sobre as camisetas disponíveis para venda na loja.
### ✨ Suas funcionalidade são:
- Criar
- Atualizar
- Deletar
- Listar (listagem com paginação e filtros)
#### 🔗 Endpoints
```
GET /api/shirts?page={page}&size={size}&sort={sort} | (retorna uma lista de camisetas)
GET /api/shirts/{id}                                | (Retorna uma camiseta específica)
POST /api/shirts                                    | (Cria uma nova camiseta)
PUT /api/shirts                                     | (Atualiza uma camiseta)
DELETE /api/shirts                                  | (Deleta uma camiseta)
```
Parâmetros opcionais: (cada parâmetro é opcional e pode ser utilizado em conjunto)
- **?page**: número da página, `exemplo: ?page=0`
- **?size**: quantidade de itens por página, `exemplo: ?size=10`
- **?sort**: ordenação dos itens, exemplo: `?sort=price,desc`

> *Paginação feita com Spring Data REST.*
>
> Documentação para mais informações: [Paging and Sorting](https://docs.spring.io/spring-data/rest/docs/current/reference/html/#paging-and-sorting)

## Color
Fornece informações sobre o catálogo de cores dos produtos, permitindo uma melhor separação e padronização dos produtos.
### ✨Suas funcionalidade são:
- Criar
- Atualizar
- Deletar
- Listar
#### 🔗 Endpoints
```
GET /api/colors      | (Retorna a lista de cores)
GET /api/colors/{id} | (Retorna uma cor específica)
POST /api/colors     | (Cria uma nova cor)
PUT /api/colors      | (Atualiza uma cor)
DELETE /api/colors   | (Deleta uma cor)
```

## Brand
Fornece informações sobre as marcas dos produtos, permitindo um melhor gerenciamento.
### ✨ Suas funcionalidade são:
- Criar
- Atualizar
- Deletar
- Listar
#### 🔗 Endpoints
```
GET /api/brand      | (Retorna a lista de marcas)
GET /api/brand/{id} | (Retorna uma marca específica)
POST /api/brand     | (Cria uma nova marca)
PUT /api/brand      | (Atualiza uma marca)
DELETE /api/brand   | (Deleta uma marca)
```

## Imagens
As images dos produtos serão armazenadas na AWS S3 através de bucket.
(Inicialmente essas informações serão armazenadas no banco de dados, mas futuramente será alterado para o S3)

## Instalação
O projeto possui conteinerização através do Docker com dockerFile e docker-compose (ainda em desenvolvimento).

### Como instalar
(tutorial de instalação...)