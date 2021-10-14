# Project-Test-KIRIHUB
Projeto teste solicitado pela KiriHub

API desenvolvida com JAVA 11, é interessante que o projeto seja configurado e 
executado no JAVA 11, necessário o Maven instalado na máquina,
fiz uso do lombok, então caso às dependências não sejam baixadas pelo 
maven automaticamente, é interessante instalar baixando no
**link: https://projectlombok.org/download**

Swagger configurado no projeto!
Todos endpoints podem ser chamados diretamente pelo swaager, bastar executar o 
projeto e acessar o link da rota: **http://localhost:8080/swagger-ui.html**

Banco de Dados H2 configurado sob a rota: **http://localhost:8080/h2-console**
Obs: não precisa de senha, apenas acessar rota após executar o projeto.

Feito insert de 12 itens contendo ID's de 1 à 12, nome do produto e o 
seu respectivo valor.

Foi implementado 4 endpoints:
**http://localhost:8080/produtos/{id}** 
(busca pelo ID)

**http://localhost:8080/produtos/find-all **
(busca todos os produtos cadastrados)

**http://localhost:8080/produtos/nome**
(Busca o produto um produto cadastrado por nome)

**http://localhost:8080/produtos/product/parcelamento **
(recebe um corpo que ser copiado o retorno de algum dos endpoints anteriores, 
acrescidos do "valor de entrada" qualquer ou "0" e a quantidade de parcelas, se
for colocado algum valor de entrada, será abatido em relação ao valor do produto
e feito parcelamento somente com a diferença, se o valor da entrada for "0",
o fluxo de parcelamento do valor total ocorrerá normalmente.

Abaixo segue lista de produtos cadastrados na ordem id, nome do produto e valor:
1 - Geladeira, 3999.90);
2 - TV, 750.00);
3 - Guarda-roupa, 250.00);
4 - Smarphone, 500.00);
5 - Monitor, 1299.00);
6 - Cama, 500.00);
7 - Mouse Gamer, 129.99);
8 - Mouse Pad, 38.90);
9 - Notebook Gamer, 4499.99);
10 - Teclado Mecânico, 230.00);
11 - Headset, 399.00);
12 - Smartwatch, 195.00);
**http://localhost:8080/dados/{dias}**
(busca ultimas atualizações diárias do SELIC, livre para fazer buscas por quantos
dias atrás desejar, ex: últimos 30 dias)
