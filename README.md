# Sistema de Cadastro de Produtos

Este é um projeto em Java para gerenciamento de produtos e categorias. O sistema permite cadastrar, alterar e consultar produtos, além de gerenciar categorias. A interface é simples e baseada em **JOptionPane**, permitindo interação básica com o usuário.

---

## Funcionalidades

O sistema oferece as seguintes funcionalidades:

- **Cadastrar Categoria**: Permite criar novas categorias de produtos.
- **Cadastrar Produto**: Permite criar produtos associando-os a uma categoria existente.
- **Alterar Produto**: Atualiza informações de um produto já cadastrado.
- **Consultar Produto por ID**: (Em desenvolvimento)
- **Consultar Produto por Categoria**: Lista todos os produtos de uma categoria selecionada.
- **Encerrar Sistema**: Fecha a aplicação.

---

## Estrutura do Projeto

O projeto segue uma organização simples, separando modelos, repositórios e views:
br.com.fiap.produtos
│
├── model
│   ├── Produto.java
│   └── Categoria.java
│
├── repository
│   ├── ProdutoCollectionRepository.java
│   └── CategoriaCollectionRepository.java
│
├── view
│   ├── ProdutoView.java
│   ├── CategoriaView.java
│   ├── OpcaoView.java
│   └── Opcao.java
│
└── Main.java


- **model**: Contém as classes `Produto` e `Categoria`.
- **repository**: Implementa repositórios em memória para armazenar produtos e categorias.
- **view**: Contém classes responsáveis pela interação com o usuário.
- **Main.java**: Classe principal que inicia a aplicação e gerencia o menu.

---

## Tecnologias Utilizadas

- **Java 17+**
- **JOptionPane** para interface gráfica simples
- **Coleções Java (Vector, List)** para armazenamento em memória

---

## Como Executar
```bash
1. Clone o repositório:

git clone https://github.com/SEU_USUARIO/NOME_DO_REPOSITORIO.git
Abra o projeto em sua IDE preferida (Eclipse, IntelliJ, NetBeans, etc).
Execute a classe Main.java.
Interaja com o menu utilizando as opções exibidas pelo JOptionPane.

Observações:
O projeto atualmente armazena dados apenas em memória. Ao fechar o programa, todos os cadastros são perdidos.
Algumas funcionalidades, como Consultar Produto por ID, ainda estão em desenvolvimento.
Validações básicas são feitas para evitar nomes duplicados de produtos ou categorias.

Contribuição
Contribuições são bem-vindas! Você pode abrir issues para reportar bugs ou sugerir melhorias. Pull requests também são aceitos.

Licença
Este projeto é livre para uso e estudo.
