## Lista 6 de Fundamentos Teóricos da Computação

1. Verifique se as seguintes linguagens são decidiveis:
    1. L = { \<A> | A é um DFA que reconhece &sum;\* }.
        - **R:**
            - Teorema: L é decidivel.
            - Prova: Mostrar uma MT M<sub>A</sub> que decide L.
              - M<sub>A</sub> = Entrada: <A> onde A é um DFA.
                1. Considere o fato que <img src="https://latex.codecogs.com/png.latex?\overline{L(A)}" title="\overline{L(A)}"/> é regular.
                2. Construa um DFA B que reconhece <img src="https://latex.codecogs.com/png.latex?\overline{L(A)}" title="\overline{L(A)}"/>, basta trocar os estados de aceitaçao e rejeiçao de A.
                3. Simule uma MT M<sub>B</sub> que decide o vazio E<sub>DFA</sub> em B.
                4. Se M<sub>B</sub> aceitar, então rejeite. Se rejeitar, aceite.
    2. L = { \<A,w> | A é um DFA que reconhece w &isin; &sum;\* }.
        - **R:**
            - Teorema: L é decidivel.
            - Prova: Mostrar uma MT M<sub>A</sub> que decide L.
              - M<sub>A</sub> = Entrada: <A,w> onde A é um DFA e w é uma string.
                1. Simula A com entrada w.
                2. Se a simulação termina em um estado final, aceita; caso contrário, rejeita.

    3. L = { \<A,B> | A,B é um DFA's tal que L(A) &ne; L(B) }.
        - **R:**
            - Teorema: L é decidivel.
            - Prova: construir um DFA C tal que
              - L(C) = (L(A) &cap; L(B)') &cup; (L(A)' &cap; L(B))
                - L(A) = L(B) somente se L(C) = &empty;
              - MT M<sub>ED</sub> = Entrada: <A,B> onde A e B são DFA's
                1. Constrói o DFA C descrito acima
                2. Executa a MT M<sub>ED</sub> com entrada C.
                3. Se M<sub>ED</sub> aceita, então rejeita; caso contrário, aceita.
    4. L = { \<A,B> | A,B é um DFA's tal que L(A) &sube; L(B) }.
        - **R:**
            - Teorema: L é decidivel.
    5. L = { \<G> | G é uma gramática tal que λ &isin; L(G) }
        - **R:**
            - Teorema: L é decidivel.
