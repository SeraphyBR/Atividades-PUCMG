# Lista 05 da disciplina de Sistemas Operacionais

1. Compare os métodos de alocação de arquivos em disco por alocação contígua,
   encadeada e indexada, discutindo os seguintes aspectos:

    1. facilidade de inserção e remoção de blocos
    2. rapidez no acesso a registros
    3. formas de acesso possíveis (seqüencial/randômica)
    4. necessidade de armazenamento de informações adicionais para manutenção do arquivo
    5. fragmentação interna e externa

    - **R:**
        - Alocação contígua:
            - Facilidade de inserção e remoção de blocos:
                - Díficil inserção, uma vez que os blocos devem ser escritos em sequencia,
                  se houver um espaço livre de 6 blocos e o programa tiver 6,5 blocos
                  ele não consegue usar esse espaço e deve achar outro conjunto de blocos livres em sequencia.
                  Arquivos não podem crescer com facilidade.
            - Rapidez no acesso a registros:
                - Pelo acesso randômico, ele acessa rapidamente os registros.
            - Forma de acesso: Randômica
            - Precisa de informações adicionais para manutenção do arquivo:
              - Não, sendo necessario só a posicao do bloco e
               o número de blocos.
            - Fragmentação: Externa

        - Alocação encadeada:
            - Facilidade de inserção e remoção de blocos:
                - Fácil inserção e remoção, como uma lista.
            - Rapidez no acesso a registros:
                - Lendo, pois deve carregar blocos anteriores ao desejado, até encontrar o registro.
            - Forma de acesso: Sequencial.
            - Precisa de informações adicionais para manutenção do arquivo:
              - Não, sendo necessario só o endereço inicial e final.
            - Fragmentação: Interna

        - Alocação indexada:
            - Facilidade de inserção e remoção de blocos:
                - Fácil inserção e remoção.
            - Rapidez no acesso a registros:
                - Pelo acesso randômico, ele acessa rapidamente os registros.
            - Forma de acesso: Randômica.
            - Precisa de informações adicionais para manutenção do arquivo:
              - Sim, ele guarda um inode do arquivo.
            - Fragmentação: Interna

2. Descreva o processo de transferência de dados de um disco para a memória, com acesso direto à memória (DMA).
   Deixe claros os papeis da CPU, driver, controladoras e barramentos neste processo.

3. O que é uma FAT (Tabela de alocação de arquivos)? Qual seu papel no método de alocação encadeado?

    - **R:** O FAT é um sistema de arquivos da Microsoft, seu papel no método de alocação encadeado

4. Um disco tem oito setores de 512 bytes por trilha, e uma taxa de rotação de 300rpm. Quanto tempo leva para a leitura de todos os setores da
   trilha em ordem assumindo que o braço já está corretamente posicionado, que meia (0.5) rotação é necessária para localizar o setor 0 (zero),
   e que a taxa de transferência do bloco demanda 15 msegundos? Seria possível adotar uma nova política para melhorar a performance?
   Faça o mesmo calculo para a nova situação (interleaving simples). E se a taxa de transferência demandar 40 msegundos o que aconteceria?
   Seria possível adotar uma nova política para melhorar a performance? (interleaving duplo).

5. Foi sugerido que a primeira parte de cada arquivo UNIX fosse mantido no mesmo bloco de disco
   com o seu i-node. Que benefícios está política gera?
   - **R:** O beneficio que essa politica gera, é de ter um carregamento do arquivo mais rápida,
            uma vez que o inicio do arquivo já se encontra no mesmo bloco.
