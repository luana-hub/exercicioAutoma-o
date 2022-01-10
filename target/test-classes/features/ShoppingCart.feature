Feature: Shopping Cart

  Scenario Outline:Validar valor total do carrinho de compras
    Given que acesso o site Automation practice
    When seleciono o produto <produto> na tela inicial e vou para o carrinho de compras
    Then o site exibe o valor do meu produto <valor> do meu carrinho de compras

    Examples:
      | produto  | valor    |
      | "camisa" | "$18.51" |
      | "blusa"  | "$29.00" |