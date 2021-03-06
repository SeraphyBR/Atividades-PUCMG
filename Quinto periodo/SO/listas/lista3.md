# Lista 03 da disciplina de Sistemas Operacionais

1. Considere que um computador tenha segmentos de memória disponíveis
   para a execução de 2 processos. Se estes processos ficam 50% do
   tempo executando I/O, que fração do tempo de CPU é desperdiçada?
   E se o número de segmentos subir para 4?

2. Se a execução de uma instrução gasta 1 micro segundo para ser
   executada e uma falta de página um tempo adicional de N micro
   segundos para ser resolvida, qual é o gasto efetivo na execução
   de uma instrução se uma falha de página ocorrer a cada k instruções.
   - **R:** T = 1 + N/k

3. Se um algoritmo FIFO de substituição de páginas é usado com 4 quadros
   e oito páginas, quantas faltas de páginas ocorreram com o string de
   referência 0172327103? E com a política LRU?

4. Um computador tem espaço de endereçamento livre de 65.536 bytes
   divididos em páginas de 4096 bytes. Um programa particular tem um
   código de 32.768 bytes, dado de 16.386 bytes e uma pilha de 15.870 bytes.
   Este programa caberá no espaço reservado? O que acontece se as páginas
   forem diminuídas para 512 bytes?
   - **R:** Número de paginas = 65.536 / 4096 = 16 \
      32.768 / 4096 = 8 páginas para código \
      16.386 / 4096 = 4,.. = 5 páginas para dados \
      15.870 / 4096 = 3,.. = 4 páginas para pilha \
      16 - 8 - 5 - 4 = 16 - 17 = -1 \
      Logo esse programa não caberá no espaço reservado.
   - Número de paginas = 65.536 / 512 = 128 \
      32.768 / 512 = 64 \
      16.386 / 512 = 32,.. = 33 \
      15.870 / 512 = 30,.. = 31 \
      64 - 33 - 31 = 0 \
      Logo esse programa caberá no espaço reservado.

5. Suponha que um endereço virtual é dividido em 4 campos: a, b, c, d.
   Os 3 primeiros são usados para uma tabela de paginas em 3 níveis.
   O número de páginas depende dos 4 campos (justifique)?
   O espaço de endereçamento virtual depende dos 4 campos (justifique)?
   O tamanho da página depende de quais campos (justifique)?

   - **R1:** O número de páginas depende apenas dos campos a, b, c. Pois \
      são eles que servem para endereçar a página na memoria.

   - **R2:** Não, o espaço de endereçamento virtual depende da máquina, \
      a soma do número de bits dos campos é limitado ao número de bits da máquina.

   - **R3** O tamanho da página depende apenas do campo d, pois após encontrar \
      a página usando os campos a, b e c, o d irá servir de deslocamento dentro da \
      página.
