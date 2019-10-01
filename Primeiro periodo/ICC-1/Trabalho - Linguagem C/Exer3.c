#include <stdio.h>

int somaPrimeirosValores(int N)
{//Inicio somaValores
    int soma = 0;
    for(int i = 0; i <= N; i++){
        soma+= i;
    }
    return(soma);
}//Fim somaValores

int main()
{//Inicio main
    int quantidade = 0;
    int soma = 0;
    printf("Digite o valor de N, para somar os N primeiros números inteiros: ");
    scanf("%d", &quantidade);
    soma = somaPrimeirosValores(quantidade);
    printf("A soma dos números eh: %d", soma);
    return(0);
}//Fim main
