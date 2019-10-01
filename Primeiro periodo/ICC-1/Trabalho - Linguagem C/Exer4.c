#include <stdio.h>

int fatorial(int num)
{//Inicio fatorial
    int fat = 1;    
    for(int i = 1; i <= num; i++){
        fat *= i;
    }
    return(fat);

}//Fim fatorial

int main()
{//Inicio main 
    int valorLido = 0;
    printf("Digite um número: ");
    scanf("%d", &valorLido);
    int fat = fatorial(valorLido);
    printf("O fatorial de %d eh: %d\n", valorLido, fat);
    return(0);
}//Fim main 