#include <stdio.h>


float sequenciaA(int N)
{//Inicio sequenciaA
    float S = 0;
    int cont = 1;
    for(int i = 0; i < N; i++){
        S +=  (float)cont / (N - i);
        cont++;
    }
    return(S);
}//Fim sequenciaA

int main()
{//Inicio main 
    int valorLido;
    printf("Digite o valor de N: ");
    scanf("%d", &valorLido);
    float resultado = sequenciaA(valorLido);
    printf("S = %f\n", resultado);
    return(0);
}//Fim main 

