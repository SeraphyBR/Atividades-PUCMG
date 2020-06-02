# Lista 01 da disciplina de Sistemas Operacionais

1. Quais das seguintes instruções devem ser permitidas apenas em modo supervisor ?

    - A. Desabilitar todas as instruções
    - B. Ler o relógio da máquina
    - C. Alterar o relógio da máquina
    - D. Mudar o mapa de memória

    **R:** A, C, D

2. Um arquivo cujo dono tem uid = 12 e gid = 1 tem modos de permissão rwxr-x---.
   Outro usuário com uid = 6 e gid = 1 tenta acessar o arquivo. O que irá acontecer ?

    **R:** Como ambos usuarios fazem parte do mesmo grupo, o usuario com uid = 6 poderá
    Ler o arquivo, e poder executar caso for um programa.

    **Adicional:**
    Cada arquivo ou pasta, nos sistemas Linux ou derivados do UNIX, possuem 3 tipos de
    permissões:

    - Owner - Permissões do proprietário do arquivo
    - Group - Permissões para os usuarios que pertencem ao grupo do arquivo.
    - Others - Permissões para os demais, que não fazem parte do grupo.

    Como as permissões são divididas em 3, elas podem ser representadas como `(rwx)(rwx)(rwx)`, sendo cada letra:

    - (r) Leitura
    - (w) Escrita
    - (x) Execução

3. O que é **SIGALARM**? Como podemos enviá-lo a um processo?
   Tem sentido ignorar **SIGALARM** ?

    **R:** **SIGALARM** É um sinal gerado por um sistema UNIX e outros sistemas operacionais
    compativeis com o padrão POSIX, basicamente é uma mensagem enviada a um ou vários processos quando um determinado evento ocorre, no caso do **SIGALARM** este é enviado
    quando um temporizador do sistema criado com a função `alarm()` chega ao fim.

    Podemos enviar o **SIGALARM** a um processo por meio da função `alarm()`, este irá
    enviar o sinal ao processo chamador após decorrido um número especifico de segundos.

    Não faz sentido ignorar **SIGALARM**, porque a ação _default_ é terminar o processo.

4. Suponha que você projete um computador com chaveamento de processo feito por hardware
   ao invés de o efetuar por interrupções. Quais informações são necessárias?
   Como seria este processo por hardware ?

    **R:** As informações necessárias são o ponto em que o programa parou e uma fila dos
    programas prontos para execução e dos em espera. Os processos prontos iriam sendo removidos da fila e executados a medida que o processador ficasse livre.

5. Em um sistema com threads, existe uma pilha para cada thread ou uma pilha por processo?
   Justifique sua resposta.

    **R:** Existe uma pilha para cada thread, pois elas são executadas separadamente e assim
    possuem necessidade de armazenar as informações sobre o ponto em que elas pararam, para poder retornar posteriormente.

6. Mostre como um semáforo de contagem pode ser implementado usando apenas semáforos
   binários e instruções de máquinas.

    **R:**

7. O CDC 6600 podia trabalhar com até 10 processos usando uma forma especial de
   escalonamento round-robin denominada _compartilhamento de processador_.
   Um chaveamento ocorria após cada execução de uma instrução. A 1ª instrução do processo
   p1, a 1ª instrução do processo p2 e assim sucessivamente. Suponha overhead próximo de
   zero. Se um processo necessita de T segundos para completar sua operação (sem
   concorrência), quanto tempo gastará se o processador for compartilhado com n processos?

    **R:** Um processo gastará `N * T - (N - 1)` segundos.

8. Escalonamento round-robin mantém uma lista de processos executáveis, com cada processo
   aparecendo apenas uma única vez na lista. O que aconteceria se um processo aparecesse
   mais de uma vez? Por que motivo poderíamos permitir tal fato?

    **R:** Se um processo ocorre múltiplas vezes na lista, significa múltiplos quantum por
    ciclo para este processo. Poderiamos permitir tal fato para dar um maior
    compartilhamento de CPU para processos de maior importância. Entretanto, caso este
    processo seja bloqueado, é preciso remover todas as suas entradas na lista de processos
    executáveis.

9. Medida de um certo sistema mostraram que um processo roda, em média, por um período T
   antes de ser bloqueado em uma operação de I/O. Considere que a troca de contexto
   consuma um tempo S (overhead). Qual é a fórmula que descreve a eficiência da CPU,
   para um escalonamento round-robin com quantum Q, supondo:

    - A. Q = &infin;
    - B. Q > T
    - C. S < Q < T
    - D. Q = S
    - E. Q próximo de 0

    **R:**

    - A. <br>![T / (T + S)](https://latex.codecogs.com/png.latex?\frac{T}{T+S})
    - B. <br>![T / (T + S)](https://latex.codecogs.com/png.latex?\frac{T}{T+S})
    - C. <br>![T / (T + (S * teto(T/Q)))](https://latex.codecogs.com/png.latex?\frac{T}{T+S*\left&space;\lceil&space;(T/Q)&space;\right&space;\rceil})
    - D. <br>![1/2](https://latex.codecogs.com/png.latex?\frac{T}{T+T}&space;=&space;\frac{1}{2})
    - E.

10. Cinco tarefas são disparadas ao mesmo tempo. Seus tempos estimados de
    execução são de 10, 6, 2, 4 e 8 minutos. Considere que suas prioridades são 3, 5, 2, 1
    e 4, respectivamente (1 a maior prioridade). Para cada um dos algoritmos abaixo,
    determine o turnaround médio. Ignore o tempo gasto na troca de contexto.

    - A. Round-robin
    - B. Escalonamento com prioridade
    - C. FCFS (na ordem 10, 6, 2, 4, 8)
    - D. SJF

    No caso (A) considere que cada tarefa adquira uma fatia justa da CPU. Nos demais casos apenas uma tarefa é executada por vez.

    **R:**

11. Um sistema de tempo real tem 4 eventos com períodos de 50, 100, 200, 250 ms cada.
    Considere que cada evento demande 35, 20, 10 e X ms de CPU respectivamente.
    Qual o maior valor de X para que o sistema continue escalonável ?

    Obs: Em um sistema de tempo real, um evento e1 deve ser completado antes que o mesmo
    evento ocorra novamente. Se isso não acontecer o sistema não será escalonável.

    **R:**
