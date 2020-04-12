## Lista 03 de Fundamentos Teóricos da Computação

1. Dê a gramática para as seguintes linguagens:

    - a. { a<sup>n</sup> b<sup>n</sup> | n ∈ N }

        - G: S &rarr; aSb | λ

    - b. { a<sup>n</sup> b<sup>k</sup> c<sup>m</sup> | k = n + m }

        - a<sup>n</sup> b<sup>k = n + m</sup> c<sup>m</sup> \
          a<sup>n</sup> b<sup>n</sup>&emsp;b<sup>m</sup> c<sup>m</sup>

        - G: S &rarr; AB \
           &emsp; A &rarr; aAb | λ \
           &emsp; B &rarr; bBc | λ

    - c. { a<sup>n</sup> b<sup>k</sup> c<sup>m</sup> | k = 2n + m }

        - a<sup>n</sup> b<sup>k = 2n + m</sup> c<sup>m</sup> \
          a<sup>n</sup> b<sup>2n</sup>&emsp;b<sup>m</sup> c<sup>m</sup>

        - G: S &rarr; AB \
           &emsp; A &rarr; aAbb | λ \
           &emsp; B &rarr; bBc | λ

    - d. { a<sup>m</sup> b<sup>n</sup> c<sup>i</sup> | m > n + i }

        - a<sup>m > n + i</sup> b<sup>n</sup> c<sup>i</sup> \
           a<sup>m = n + i + 1</sup> b<sup>n</sup> c<sup>i</sup> \
           a (a<sup>i</sup> (a<sup>n</sup> b<sup>n</sup>) c<sup>i</sup>) \
           a . (a<sup>i</sup> (a.b)<sup>n</sup> c<sup>i</sup>)

        - G: S &rarr; aA | aB \
           &emsp; A &rarr; aAc | B | λ \
           &emsp; B &rarr; aBb | λ

    - e. { w ∈ {a, b}<sup>\*</sup> | w não contenha o substring aba }

        - G: S &rarr;

    - f. { w | w contenha um número igual de a's b's }

        - G: S &rarr; aSb | bSa | λ

    - g. { ww<sup>R</sup> | w ∈ {a, b}<sup>\*</sup> }

        - G: S &rarr;

2. Para cada uma das gramáticas a seguir, descreva a linguagem gerada pela gramática:

    - a. S &rarr; aaSB | λ \
      &emsp; B &rarr; bB | λ

        - L: { (aa)<sup>n</sup> b<sup>k</sup> | n,k ∈ N }

    - b. S &rarr; aSbb | A \
      &emsp; A &rarr; cA | c

        - L: { a<sup>n</sup> b<sup>n + 1</sup> U c<sup>k</sup> | n > 0, k > 0 }

    - c. S &rarr; aS | bS | A \
      &emsp; A &rarr; cA | c | λ

        - L: { a<sup>n</sup> b<sup>m</sup> c<sup>k</sup> | n,m,k &ge; 0 }

    - d. S &rarr; abSdc | A \
      &emsp; A &rarr; cdAba | λ

        - L: {}

    - e. S &rarr; aA | λ \
      &emsp; A &rarr; bS
        - L: {}

3. Para cada uma das gramáticas a seguir, obtenha uma gramática essencialmente não contratíl:

    - a. S &rarr; aS | bS | B \
      &emsp; B &rarr; bb | C | λ \
      &emsp; C &rarr; cC | λ

    - b. S &rarr; ABC | λ \
      &emsp; A &rarr; aA | λ \
      &emsp; B &rarr; bB | λ \
      &emsp; C &rarr; cC | λ

    - c. S &rarr; BSA | A \
      &emsp; A &rarr; aA | λ \
      &emsp; B &rarr; Bba | λ

4. Para cada uma das gramáticas a seguir, obtenha uma gramática equivalente sem regras de cadeia:

    - a. S &rarr; AS | A \
       &emsp; A &rarr; aA | bB | C \
       &emsp; B &rarr; bB | b \
       &emsp; C &rarr; cC | B

    - b. S &rarr; A | B | C \
       &emsp; A &rarr; aa | B \
       &emsp; B &rarr; bb | C \
       &emsp; C &rarr; cC | A

5. Para cada uma das gramáticas a seguir, obtenha uma gramática equivalente na FNC:

    - a. S &rarr; aAbB | ABC | a \
       &emsp; A &rarr; aA | a \
       &emsp; B &rarr; bBcC | b \
       &emsp; C &rarr; abc

    - b. S &rarr; A | ABa | AbA \
       &emsp; A &rarr; aA | λ \
       &emsp; B &rarr; Bb | BC \
       &emsp; C &rarr; CB | CA | bB

    - c. S &rarr; ABC \
       &emsp; A &rarr; a \
       &emsp; B &rarr; b | bb \
       &emsp; C &rarr; BaB | c

    - d. S &rarr; ADE | ABa | AbA \
       &emsp; A &rarr; Aa | λ \
       &emsp; B &rarr; Bb | BC \
       &emsp; C &rarr; CB | CA | bB \
       &emsp; D &rarr; EdD | E \
       &emsp; E &rarr; bcdE | D
