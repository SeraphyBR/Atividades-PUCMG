/*
Dada   uma   sequência   de   divisões   realizadas   por   Juliana   em   uma   barra   de   chocolate,   determinar
quantos pedaços serão armazenados em estoque para uso futuro
*/

#include <stdio.h>

int main() {
    int divisoes = 0;
    int armazenados = 0;
    int numero = 0;

    do{
        scanf("%d", &divisoes);
    }while(divisoes < 1 || divisoes > 1000);

    for(int i = 0; i < divisoes; i++)
    {//Inicio for 
        do{
            scanf("%d", &numero);
        }while(numero < 2 || numero > 10);
        armazenados += numero - 1;
    }//Fim for
    
    printf("%d",armazenados);
    return(0);
}