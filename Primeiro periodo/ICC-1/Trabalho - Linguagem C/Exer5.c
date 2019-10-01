#include <stdio.h>

void sequenciaA(int termos)
{//Inicio sequenciaA
    int denominador = 1;
    printf(" 1 ");
    for(int i = 0; i < termos; i++){
        denominador *= 3;
        printf(" 1/%d ", denominador);        
    }
}//Fim sequenciaA

int main()
{//Inicio main 
    int valorLido;
    printf("Digite o numero de termos: ");
    scanf("%d", &valorLido);
    sequenciaA(valorLido);
    printf("\n");
    return(0);
}//Fim main 
