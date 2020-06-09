## Lista 7 de Fundamentos Teóricos da Computação

Seja G = {V, T, P, S}, onde

-   V = {S', S, C}
-   T = {a, b, =}

P o conjunto das seguintes produções:

-   S' &rarr; S
-   S &rarr; CSS
-   S &rarr; CS
-   S &rarr; a = b
-   C &rarr; a

1. Construa a tabela do predictive parse para G. G é LL(1)? Justifique

    - |     | a                                             | =   | b   | \$  |
      | --: | --------------------------------------------- | --- | --- | --- |
      |  S' | S' &rarr; S                                   |     |     |     |
      |   S | S &rarr; CSS<br>S &rarr; CS<br>S &rarr; a = b |     |     |     |
      |   C | C &rarr; a                                    |     |     |     |

    - **R:** G não LL(1), pois o alfa e beta não derivam no mesmo momento sentenças
      que se iniciam com o mesmo terminal a, ou seja, FIRST(&alpha;) &cap; FIRST(&beta;) = &empty;;
      e no caso FIRST(S') = FIRST(S) = FIRST(C) = a

2. Calcule a coleção de conjuntos de itens LR(0) para a gramática G.
