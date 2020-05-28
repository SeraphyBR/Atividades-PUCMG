# Lista 05 da disciplina de Sistemas Operacionais

1. Compare os métodos de alocação de arquivos em disco por alocação contígua,
   encadeada e indexada, discutindo os seguintes aspectos:
    1. facilidade de inserção e remoção de blocos
    2. rapidez no acesso a registros
    3. formas de acesso possíveis (seqüencial/randômica)
    4. necessidade de armazenamento de informações adicionais para manutenção do arquivo
    5. fragmentação interna e externa

2. Descreva o processo de transferência de dados de um disco para a memória, com acesso direto à memória (DMA).
   Deixe claros os papeis da CPU, driver, controladoras e barramentos neste processo.

3. O que é uma FAT (Tabela de alocação de arquivos)? Qual seu papel no método de alocação encadeado?

4. Um disco tem oito setores de 512 bytes por trilha, e uma taxa de rotação de 300rpm. Quanto tempo leva para a leitura de todos os setores da
   trilha em ordem assumindo que o braço já está corretamente posicionado,  que meia (0.5) rotação é necessária para localizar o setor 0 (zero),
   e que a taxa de transferência do bloco demanda 15 msegundos? Seria possível adotar uma nova política para melhorar a performance?
   Faça o mesmo calculo para a nova situação (interleaving simples). E se a taxa de transferência demandar 40 msegundos o que aconteceria?
   Seria possível adotar uma nova política para melhorar a performance? (interleaving duplo).

5. Foi sugerido que a primeira parte de cada arquivo UNIX fosse mantido no mesmo bloco de disco
   com o seu i-node. Que benefícios está política gera?
