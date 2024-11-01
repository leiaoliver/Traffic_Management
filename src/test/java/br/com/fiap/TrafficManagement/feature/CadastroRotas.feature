# language: pt
Funcionalidade: Cadastro de nova rota
  Como usuário da API
  Quero cadastrar uma nova rota
  Para que o registro seja salvo corretamente no sistema

  Cenário: Cadastro bem-sucedido de rota
    Dado que eu tenha os seguintes dados da rota:
      | campo          | valor       |
      | ORIGEM      | São Paulo   |
      | DESTINO       | Rio de Janeiro |
      | DISTANCIA_KM   | 430.5       |
      | DURACAO_MINUTOS | 360         |
    Quando eu enviar a requisição para o endpoint "/api/rotas" de cadastro de rotas
    Então o status code da resposta deve ser 201
    E o corpo de resposta deve conter o campo "origem" com o valor "São Paulo"
    E o corpo de resposta deve conter o campo "destino" com o valor "Rio de Janeiro"
