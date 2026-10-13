# Baozi Store — API REST

Requisitos: Java 17+, Maven 3.9+, Postman.

## Executar
Abra a pasta no IntelliJ ou VS Code e execute `mvn spring-boot:run` (necessita internet para baixar dependências na primeira execução). Base URL: `http://localhost:8080`. Banco H2 persistido em `./data/baozi`.

## Testes no Postman
Selecione Body > raw > JSON e Content-Type application/json.

1. POST http://localhost:8080/clientes
   {"nome":"Paula5537051","clienteDesde":"2026-10-12"}
2. POST http://localhost:8080/produtos
   {"nome":"Baozi tradicional","preco":8.50,"estoque":true}
3. POST http://localhost:8080/pedidos
   {"clienteId":1,"produtoId":1,"quantidade":3}
4. GET http://localhost:8080/clientes, /produtos, /pedidos
5. GET http://localhost:8080/clientes/1, /produtos/1, /pedidos/1
6. DELETE http://localhost:8080/pedidos/1 (após capturar os prints das consultas). Repita DELETE para produtos e clientes se necessário.

Os IDs dependem dos registros realmente criados; use os IDs retornados nos POSTs. Capture prints reais de cada operação no Postman. Suba esta pasta para um repositório GitHub e insira o link no relatório.

Nota: a entidade Pedido guarda os IDs de cliente e produto como especificado no enunciado; a API verifica se ambos existem antes de registrar o pedido. Não há PUT porque é opcional.
