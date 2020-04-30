## Lista 04 de Fundamentos Teóricos da Computação

5. Para cada uma das gramáticas a seguir, obtenha uma gramática equivalente na FNC:

    - **a.** S &rarr; aAbB | ABC | a \
       &emsp; A &rarr; aA | a \
       &emsp; B &rarr; bBcC | b \
       &emsp; C &rarr; abc

        - **1º** Tirando recursividade em S - não tem!

        - **2º** Eliminação de produções lambda - não tem!

        - **3º** Remoção de cadeias - não tem!

        - **4º** Eliminação de simbolos inuteis
            - **4.1** Não produzem terminal - não tem!
            - **4.2** Não são alcançaveis - não tem!

        - **G:** Resultado após os passos acima \
           S &rarr; aAbB | ABC | a \
           A &rarr; aA | a \
           B &rarr; bBcC | b \
           C &rarr; abc

        - **5º final:** Modificar as produções para a FNC \
           S &rarr; A<sub>1</sub>A<sub>2</sub> | AB<sub>3</sub> | a \
           A &rarr; A<sub>1</sub>A | a \
           B &rarr; B<sub>1</sub>C<sub>1</sub> | b \
           C &rarr; A<sub>1</sub>C<sub>3</sub> \
           A<sub>1</sub> &rarr; a \
           A<sub>2</sub> &rarr; AB<sub>1</sub> \
           B<sub>1</sub> &rarr; B<sub>2</sub>B \
           B<sub>2</sub> &rarr; b \
           B<sub>3</sub> &rarr; BC \
           C<sub>1</sub> &rarr; C<sub>2</sub>C \
           C<sub>2</sub> &rarr; c \
           C<sub>3</sub> &rarr; B<sub>2</sub>C<sub>2</sub>

    - **b.** S &rarr; A | ABa | AbA \
       &emsp; A &rarr; Aa | λ \
       &emsp; B &rarr; Bb | BC \
       &emsp; C &rarr; CB | CA | bB

        - **1º** Tirando recursividade em S - não tem!

        - **2º** Eliminação de produções lambda

            - Anulaveis = {**A**, S} \
               S &rarr; **A** | **A**Ba | **A**b**A** \
               **A** &rarr; **A**a | λ \
               S &rarr; A | ABa | AbA | **Ba | Ab | bA | b | λ** \
               A &rarr; Aa | **a**
            - Anulaveis = {A, **S**} \
               **S** &rarr; A | ABa | AbA | Ba | Ab | bA | b | λ

        - **3º** Remoção de cadeias

            - Cadeia = {S} \
               **S** &rarr; A | ABa | AbA | Ba | Ab | bA | b | λ \
               **S** &rarr; **Aa | a** | ABa | AbA | Ba | Ab | bA | b | λ

        - **4º** Eliminação de simbolos inuteis

            - **4.1** Não produzem terminal

                - T = {S,A} \
                  S &rarr; Aa | a | ~~**ABa**~~ | AbA | ~~**Ba**~~ | Ab | bA | b | λ \
                  A &rarr; Aa | a

            - **4.2** Não são alcançáveis - não tem!

        - **G:** Resultado dos passos acima: \
           S &rarr; Aa | a | AbA | Ab | bA | b | λ \
           A &rarr; Aa | a

        - **5º final:** Modificar as produções para a FNC \
           S &rarr; AA<sub>1</sub> | a | AA<sub>2</sub> | AA<sub>3</sub> | A<sub>3</sub>A | b | λ \
           A &rarr; AA<sub>1</sub> | a \
           A<sub>1</sub> &rarr; a \
           A<sub>2</sub> &rarr; A<sub>3</sub>A \
           A<sub>3</sub> &rarr; b

    - **c.** S &rarr; ABC \
       &emsp; A &rarr; a \
       &emsp; B &rarr; b | bb \
       &emsp; C &rarr; BaB | c

        - **1º** Tirando recursividade em S - não tem!

        - **2º** Eliminação de produções lambda - não tem!

        - **3º** Remoção de cadeias - não tem!

        - **4º** Eliminação de simbolos inuteis
            - **4.1** Não produzem terminal - não tem!
            - **4.2** Não são alcançaveis - não tem!

        - **5º final:** Modificar as produções para a FNC \
            S &rarr; AA<sub>1</sub> \
            A &rarr; a \
            B &rarr; b | B<sub>1</sub>B<sub>1</sub> \
            C &rarr; BC<sub>1</sub> | c \
            A<sub>1</sub> &rarr; BC \
            B<sub>1</sub> &rarr; b \
            C<sub>1</sub> &rarr; AB


    - **d.** S &rarr; ADE | ABa | AbA \
       &emsp; A &rarr; Aa | λ \
       &emsp; B &rarr; Bb | BC \
       &emsp; C &rarr; CB | CA | bB \
       &emsp; D &rarr; EdD | E \
       &emsp; E &rarr; bcdE | D

6. Prove usando o pumping lemma que as seguintes linguagens não são livres de contexto:

    - **a.** L = { a<sup>n</sup> b<sup>n</sup> a<sup>n</sup> b<sup>n</sup> | n > 0 }

        - Hípotese: L é livre de contexto.
        - Considere uma gramatíca livre de contexto na forma normal de Chomsky com K váriaveis.\
          Seja z = a <sup>k</sup> b<sup>k</sup> a<sup>k</sup> b<sup>k</sup>, k = 2<sup>n</sup>.\
          Como |z| = 4k = 4 \* 2<sup>n</sup> e |z| &ge; 2<sup>n</sup>, então pelo lema do bombeamento:
            - **1.** v, x só conter um tipo de terminal:
              - **1.1** a's.
               z = a <sup>k</sup> b<sup>k</sup> a<sup>k</sup> b<sup>k</sup>

    - **b.** { 0<sup>n</sup> 1<sup>2n</sup> 2<sup>n</sup> | n > 0}

    - **c.** { w w<sup>R</sup> w | w ∈ {a, b}\* }

7. Construa autômatos de pilha que reconheçam as seguintes linguagens:

    - **a.** { w0w<sup>R</sup> | w ∈ {a, b}\* }

        - **R:** <br><img src="./imagens/pilha1.png" width="340"/>

    - **b.** { a<sup>n</sup> b<sup>n</sup> a<sup>m</sup> | n, m &ge; 0 }

        - **R:** <br><img src="./imagens/pilha2.png" width="340"/>

    - **c.** { w | w ∈ {a, b, c}\* e o primeiro c seja precedido por aaa }

        - **R:** <br><img src="./imagens/pilha3.png" width="340"/>
