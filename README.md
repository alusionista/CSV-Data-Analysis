# CSV Data Analysis

Este projeto em Java realiza a análise de um arquivo CSV contendo dados de transações. Ele calcula algumas estatísticas com base nos dados e exibe os resultados no console.

## Funcionalidades

- Leitura de um arquivo CSV contendo dados de transações.
- Contagem do número total de linhas.
- Contagem do número de linhas únicas.
- Contagem do número de contas que realizaram pelo menos 500 transações.
- Cálculo da média das transações por conta.
- Identificação da terceira conta com a maior média de transações.

## Requisitos

- JDK 8 ou superior instalado.
- Arquivo CSV no formato adequado.

## Como usar

1. Coloque o arquivo CSV no mesmo diretório do arquivo Java (`MainRefactored.java`).

2. Compile e execute o código:

   ```shell
   javac MainRefactored.java
   java MainRefactored
   ```

   Certifique-se de ter o JDK configurado corretamente no seu sistema.

3. Os resultados serão exibidos no console, incluindo o número total de linhas, o número de linhas únicas, o número de contas com pelo menos 500 transações e a terceira conta com a maior média de transações.

   Exemplo de saída:

   ```
   Total number of lines: 1000
   Number of unique lines: 990
   Number of accounts that executed at least 500 transactions: 7
   Account with 3rd highest average: Account123
   ```

   Os valores apresentados no exemplo podem variar de acordo com os dados do arquivo CSV fornecido.

Certifique-se de ajustar o código para corresponder ao formato e à estrutura correta do seu arquivo CSV de entrada.

Espero que isso ajude!
