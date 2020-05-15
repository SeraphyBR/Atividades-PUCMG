# Lista 03 da disciplina de Sistemas Operacionais

1. Considere uma instrução com endereçamento de memória de 12 bits.
   Suponha um sistema de paginação com um nível apenas.
   Se 4 bits identificam as entradas na tabela de páginas então:

    1. Quantas páginas existem no total?
    2. Qual o tamanho de cada página?
    3. Quais seriam os respectivos endereços dos endereços virtuais 1030 e 519?

   Considere que todos os quadros estão disponíveis e que a alocação é consecutiva.<br/>
   ![imagem](img1.png)

2. Você deseja simular uma MMU via software. Faça uma rotina que converta
   endereços virtuais em endereços reais. A palavra é de 16 bits. O total
   páginas é de 256 com cada frame de 256 bytes. Considere um esquema com
   apenas um nível.

3. Um computador tem 4 frames. O tempo de carga, do último acesso e o bit R
   para cada página é mostrado abaixo:
    | Page | Carga | Última referência | R   |
    | ---- | ----- | ----------------- | --- |
    | 0    | 231   | 280               | 1   |
    | 1    | 126   | 260               | 0   |
    | 2    | 128   | 271               | 1   |
    | 3    | 160   | 268               | 1   |

    1. Qual página será substituida se utilizarmos a política MRU?

    2. Qual página será substituida se utilizarmos a política FIFO?

    3. Qual página será substituida se utilizarmos a política LRU?

    4. Qual página será substituida se utilizarmos a política da Segunda Change?

4. Um sistema operacional suporta uma memória virtual paginada. Cada instrução (palavra) é
   executada em 1 micro segundo. Temos um custo adicional de 1 micro segundo para acessar
   uma página diferente da corrente. Cada página suporta 1000 palavras, e o dispositivo
   de paginação transfere 1 milhão de palavras por segundo. Sabendo que:

   - 1% de todas as instruções executadas acessam páginas diferente da corrente.
   - Das instruções que acessam outras páginas, 80% acessam uma página que já está na memória.
   - Quando uma nova página é requisitada, a página substituída foi modificada  50% das vezes.


    Calcule o tempo efetivo  de execução de uma instrução, assumindo que apenas um processo
    está sendo executado, e que este processo fica suspenso durante a transferência de dados.
