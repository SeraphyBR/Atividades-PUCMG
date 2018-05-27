/*
Leia N números em um vetor de dimensão informada na entrada. Para este vetor, responda, em cada
linha: soma de todos os elementos; menor elemento do vetor; média dos elementos; quantidade de
elementos ímpares
*/

#include <stdio.h>

int main()
{//Inicio main
    int tamanho = 0, soma = 0, menor = 5000, impares = 0, erro = 0;
    float media = 0;

    do{
        //printf("Digite o número de elementos do vetor para serem lidos: ");
        scanf("%d",&tamanho);
        erro = tamanho <= 0;
        //if (erro) printf("\nValor inválido!\n");
    }while(erro);

    int vetor[tamanho];

    for(int i = 0; i < tamanho; i++){

        do{
            scanf("%d",&vetor[i]);
        }while(vetor[i] < 0 || vetor[i] > 5000);
        
        soma += vetor[i];
        if(vetor[i] % 2 == 1) impares++;
        if(vetor[i] < menor) menor = vetor[i];
    }
    media = (float)soma / (float)tamanho;
    printf("%d\n%d\n%f\n%d", soma, menor, media, impares);

    return(0);
}//Fim main 