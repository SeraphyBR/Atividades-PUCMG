## Lista 03 de Fundamentos Teóricos da Computação

1. Dê a gramática para as seguintes linguagens:

    - **a.** { a<sup>n</sup> b<sup>n</sup> | n ∈ N }

        - **G:** S &rarr; aSb | λ

    - **b.** { a<sup>n</sup> b<sup>k</sup> c<sup>m</sup> | k = n + m }

        - a<sup>n</sup> b<sup>k = n + m</sup> c<sup>m</sup> \
          a<sup>n</sup> b<sup>n</sup>&emsp;b<sup>m</sup> c<sup>m</sup>

        - **G:** S &rarr; AB \
           &emsp; A &rarr; aAb | λ \
           &emsp; B &rarr; bBc | λ

    - **c.** { a<sup>n</sup> b<sup>k</sup> c<sup>m</sup> | k = 2n + m }

        - a<sup>n</sup> b<sup>k = 2n + m</sup> c<sup>m</sup> \
          a<sup>n</sup> b<sup>2n</sup>&emsp;b<sup>m</sup> c<sup>m</sup>

        - **G:** S &rarr; AB \
           &emsp; A &rarr; aAbb | λ \
           &emsp; B &rarr; bBc | λ

    - **d.** { a<sup>m</sup> b<sup>n</sup> c<sup>i</sup> | m > n + i }

        - a<sup>m > n + i</sup> b<sup>n</sup> c<sup>i</sup> \
           a<sup>m = n + i + 1</sup> b<sup>n</sup> c<sup>i</sup> \
           a (a<sup>i</sup> (a<sup>n</sup> b<sup>n</sup>) c<sup>i</sup>) \
           a . (a<sup>i</sup> (a.b)<sup>n</sup> c<sup>i</sup>)

        - **G:** S &rarr; aA | aB \
           &emsp; A &rarr; aAc | B | λ \
           &emsp; B &rarr; aBb | λ

    - **e.** { w ∈ {a, b}<sup>\*</sup> | w não contenha o substring aba }

        - **G:** S &rarr;

    - **f.** { w | w contenha um número igual de a's b's }

        - **G:** S &rarr; aSb | bSa | λ

    - **g.** { ww<sup>R</sup> | w ∈ {a, b}<sup>\*</sup> }

        - **G:** S &rarr;

2. Para cada uma das gramáticas a seguir, descreva a linguagem gerada pela gramática:

    - **a.** S &rarr; aaSB | λ \
      &emsp; B &rarr; bB | λ

        - **L:** { (aa)<sup>n</sup> b<sup>k</sup> | n,k ∈ N }

    - **b.** S &rarr; aSbb | A \
      &emsp; A &rarr; cA | c

        - **L:** { a<sup>n</sup> b<sup>n + 1</sup> U c<sup>k</sup> | n > 0, k > 0 }

    - **c.** S &rarr; aS | bS | A \
      &emsp; A &rarr; cA | c | λ

        - **L:** { a<sup>n</sup> b<sup>m</sup> c<sup>k</sup> | n,m,k &ge; 0 }

    - **d.** S &rarr; abSdc | A \
      &emsp; A &rarr; cdAba | λ

        - **L:** { (ab)<sup>n</sup>(dc)<sup>n</sup> U (cd)<sup>m</sup>(ba)<sup>m</sup> | n,m &ge; 0 }

    - **e.** S &rarr; aA | λ \
      &emsp; A &rarr; bS
        - **L:** { (ab)<sup>n</sup> | n &ge; 0}

3. Para cada uma das gramáticas a seguir, obtenha uma gramática essencialmente não contratíl:

    - **a.** S &rarr; aS | bS | B \
      &emsp; B &rarr; bb | C | λ \
      &emsp; C &rarr; cC | λ

        - **1º** Tirando recursividade em S - aumentando a gramática

            - **S' &rarr; S** \
              S &rarr; aS | bS | B \
              B &rarr; bb | C | λ \
              C &rarr; cC | λ

        - **2º** Eliminação de produções lambda
            - Anulaveis = {**C**, B, S, S´} \
               B &rarr; bb | **C** | λ \
               **C** &rarr; c**C** | λ \
               C &rarr; cC | **c**
            - Anulaveis = {C, **B**, S, S´} \
               **B** &rarr; bb | C | ~~**λ**~~ \
               B &rarr; bb | C
            - Anulaveis = {C, B, **S**, S´} \
               **S** &rarr; a**S** | b**S** | B \
               S &rarr; aS | bS | B | **a | b**
            - Anulaveis = {C, B, S, **S´**} \
               **S'** &rarr; **S** \
               S' &rarr; S **| λ**
        - **G:** Resultado \
           S' &rarr; S | λ \
           S &rarr; aS | bS | B | a | b \
           B &rarr; bb | C \
           C &rarr; cC | c

    - **b.** S &rarr; ABC | λ \
      &emsp; A &rarr; aA | λ \
      &emsp; B &rarr; bB | λ \
      &emsp; C &rarr; cC | λ

        - **1º** Tirando recursividade em S - não tem!
        - **2º** Eliminação de produções lambda
            - Anulaveis = {**C**, B, A, S} \
               S &rarr; AB**C** | λ \
               **C** &rarr; c**C** | λ \
               S &rarr; ABC | **AB** | λ \
               C &rarr; cC | **c**
            - Anulaveis = {C, **B**, A, S} \
               S &rarr; A**B**C | A**B** | λ \
               **B** &rarr; b**B** | λ \
               S &rarr; ABC | AB | **AC | A** | λ \
               B &rarr; bB | **b**
            - Anulaveis = {C, B, **A**, S} \
               S &rarr; **A**BC | **A**B | **A**C | **A** | λ \
               **A** &rarr; a**A** | λ \
               S &rarr; ABC | AB | AC | A | **BC | B | C** | λ \
               A &rarr; aA | **a**
            - Anulaveis = {C, B, A, **S**} \
               **S** &rarr; ABC | AB | AC | A | BC | B | C | λ
        - **G:** Resultado \
           S &rarr; ABC | AB | AC | A | BC | B | C | λ \
           A &rarr; aA | a \
           B &rarr; bB | b \
           C &rarr; cC | c


    - **c.** S &rarr; BSA | A \
      &emsp; A &rarr; aA | λ \
      &emsp; B &rarr; Bba | λ

        - **1º** Tirando recursividade em S - aumentando a gramática
           - **S' &rarr; S** \
                S &rarr; BSA | A \
                A &rarr; aA | λ \
                B &rarr; Bba | λ

        - **2º** Eliminação de produções lambda
            - Anulaveis = {**B**, A, S, S'} \
                S &rarr; **B**SA | A \
                **B** &rarr; **B**ba | λ \
                S &rarr; BSA | A | **SA** \
                B &rarr; Bba | **ba**
            - Anulaveis = {B, **A**, S, S'} \
                S &rarr; BS**A** | **A** | S**A** \
                **A** &rarr; a**A** | λ \
                S &rarr; BSA | A | SA | **BS | S | λ** \
                A &rarr; aA | **a**
            - Anulaveis = {B, A, **S**, S'} \
                S' &rarr; **S** \
                **S** &rarr; B**S**A | A | **S**A | B**S** | λ \
                S' &rarr; S | λ \
                S &rarr; BSA | A | SA | BS | **BA | A | B** \
                S &rarr; BSA | SA | BS | **BA | A | B**
            - Anulaveis = {B, A, S, **S'**} \
                **S'** &rarr; S | λ

        - **G:** Resultado \
                S' &rarr; S | λ \
                S &rarr; BSA | SA | BS | BA | A | B \
                A &rarr; aA | a \
                B &rarr; Bba | ba

4. Para cada uma das gramáticas a seguir, obtenha uma gramática equivalente sem regras de cadeia:

    - **a.** S &rarr; AS | A \
       &emsp; A &rarr; aA | bB | C \
       &emsp; B &rarr; bB | b \
       &emsp; C &rarr; cC | B

        - **1º** Tirando recursividade em S - aumentando a gramática \
           **S' &rarr; S**\
           S &rarr; AS | A \
           A &rarr; aA | bB | C \
           B &rarr; bB | b \
           C &rarr; cC | B

        - **2º** Eliminação de produções lambda - não tem!

        - **3º** Remoção de cadeias

            - Cadeia = {S', S, A, **C**} \
              C &rarr; cC | B \
              C &rarr; cC | **bB | b**
            - Cadeia = {S', S, **A**, C} \
              A &rarr; aA | bB | C \
              A &rarr; aA | bB | **cC | bB | b**
            - Cadeia = {S', **S**, A, C} \
              S &rarr; AS | A \
              S &rarr; AS | **aA | bB | cC | bB | b**
            - Cadeia = {**S'**, S, A, C} \
              S' &rarr; S \
              S' &rarr; **AS | aA | bB | cC | bB | b**

        - **G:** Resultado \
           S' &rarr; **AS | aA | bB | cC | bB | b** \
           S &rarr; AS | **aA | bB | cC | bB | b** \
           A &rarr; aA | bB | **cC | bB | b** \
           B &rarr; bB | b \
           C &rarr; cC | **bB | b**

    - **b.** S &rarr; A | B | C \
       &emsp; A &rarr; aa | B \
       &emsp; B &rarr; bb | C \
       &emsp; C &rarr; cC | A

        - **1º** Tirando recursividade em S - não tem!

        - **2º** Eliminação de produções lambda - não tem!

        - **3º** Remoção de cadeias

            - Cadeia = {S, A, B, **C**} \
              C &rarr; cC | A \
              C &rarr; cC | **aa | B**

            - Cadeia = {S, A, **B**, C} \
              B &rarr; bb | C \
              B &rarr; bB | **cC | aa | B** \
              B &rarr; bB | **cC | aa**

            - Cadeia = {S, **A**, B, C} \
              A &rarr; aa | B \
              A &rarr; aA | **bB | cC | aa**

            - Cadeia = {**S**, A, B, C} \
              S &rarr; A | B | C \
              S &rarr; **aA | bB | cC | aa | bB | cC | aa | cC | aa | B** \
              S &rarr; aA | bB | cC | aa | B \
              S &rarr; aA | bB | cC | aa | **bB | cC | aa** \
              S &rarr; aA | **bB | cC | aa**

        - **Extra:** remover cadeia remanescente em C \
           C &rarr; cC | aa | B \
           C &rarr; cC | aa | **bB | cC | aa** \
           C &rarr; **cC | aa | bB**

        - **G:** Resultado \
           S &rarr; aA | bB | cC | aa \
           A &rarr; aA | bB | cC | aa \
           B &rarr; bB | cC | aa \
           C &rarr; cC | aa | bB

5. Para cada uma das gramáticas a seguir, obtenha uma gramática equivalente na FNC:

    - **a.** S &rarr; aAbB | ABC | a \
       &emsp; A &rarr; aA | a \
       &emsp; B &rarr; bBcC | b \
       &emsp; C &rarr; abc


    - **b.** S &rarr; A | ABa | AbA \
       &emsp; A &rarr; aA | λ \
       &emsp; B &rarr; Bb | BC \
       &emsp; C &rarr; CB | CA | bB

    - **c.** S &rarr; ABC \
       &emsp; A &rarr; a \
       &emsp; B &rarr; b | bb \
       &emsp; C &rarr; BaB | c

    - **d.** S &rarr; ADE | ABa | AbA \
       &emsp; A &rarr; Aa | λ \
       &emsp; B &rarr; Bb | BC \
       &emsp; C &rarr; CB | CA | bB \
       &emsp; D &rarr; EdD | E \
       &emsp; E &rarr; bcdE | D
