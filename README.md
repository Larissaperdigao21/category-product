# CADASTRO DE PRODUTOS E CATEGORIAS 

Este é um projeto para cadastro de produtos e categorias, ligando os produtos com suas respectivas categorias.

## Ferramentas e Frameworks utilizados

Spring Boot 

Spring Data JPA 

Postgree 

Hibernate 

Dbeaver


### Mais sobre o projeto

Este é um projeto para portfólio e para testar meus conhecimentos.
Com o Swagger eu adicionei as categorias Eletronics, Books, Roupas e Alimentos. Adicionei também dois produtos para cada categoria, se você quiser também adicionar estes produtos e estas categorias, você pode adicionar tanto no swagger quanto no postman da seguinte maneira: 

usando o endpoint: http://localhost:8080/api/categories/save

você irá inserir através deste endpoint a seguinte requisição:

{
        "id": 1,
        "name": "Eletronics",
        "products": null
    }

Para adicionar a categoria Books, você irá usar o mesmo endpoint:

{
        "id": 2,
        "name": "Books",
        "products": null
    }

E assim sucessivamente para as outras categorias e para quantas categorias você desejar.

Agora vamos adicionar os produtos com o seguinte endpoint: http://localhost:8080/api/products/save

através deste endpoint você irá inserir as seguintes requisições para adicionar pelo menos um produto para cada categoria a cima: 

 {
        "id": 1,
        "name": "TV",
        "price": 2200,
        "category": {
            "id": 1,
            "name": "Eletronics"
        }
    }

 {
        "id": 2,
        "name": "Domain Driven Design",
        "price": 120,
        "category": {
            "id": 2,
            "name": "Books"
        }
    }

Desta forma você irá adicionar duas categorias e um produto para cada categoria no seu banco de dados. Não se esqueça de configurar seu banco de dados no application.properties e criar um banco de dados com o mesmo nome que você colocou no application.properties.
