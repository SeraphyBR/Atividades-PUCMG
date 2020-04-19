
% Exemplo de Hello world!
hello :- write('Hello World!').

/*
    Esse é um comentario de bloco,
    abaixo estão algumas funções basicas
    de matemática.
*/
adicao(A, B, C):- C is A + B.
subtracao(A, B, C):- C is A - B.
multiplicacao(A, B, C):- C is A * B.
divisao(A, B, C):- C is A / B.

/*
    Exemplo de função/predicado Recursivo:
    O primeiro predicado fatorial diz para retornar 1
    se o número é 0.

    O segundo possue duas váriaveis A e B.

    Se A for maior que zero, ele avalia para verdadeiro.
    Então decrementa A em 1, e atribui o resultado em C.
    E depois chama recusivamente o fatorial de C com a nova
    variavel D.

    A ultima linha é atingida quando A se torna zero e irá
    retornar 1 no fatorial.
*/
fatorial(0, 1).
fatorial(A, B) :-
    A > 0,
    C is A - 1,
    fatorial(C,D),
    B is A * D.

% Jose é pai de ana
pai(jose,ana).
% Carlos é pai de jose
pai(carlos,jose).

% X é avô de Z se X é pai de Y e Y é pai de Z
avo(X,Z) :- pai(X,Y), pai(Y,Z).
