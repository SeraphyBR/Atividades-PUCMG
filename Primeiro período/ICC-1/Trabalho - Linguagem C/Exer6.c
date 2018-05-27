#include <stdio.h>

float sequenciaA(int N)
{//Inicio sequenciaA
    int denominador = 1, modeChange = 0;
    float H = 1;
    for(int i = 2; i <= N; i++){
        if(modeChange == 0)
        {//Inicio if  
            H -= 1.0 / (float)i;
            modeChange = 1;
        }//Fim if  
        else if (modeChange == 1)
        {//Inicio else if  
            H += 1.0 / (float)i;
            modeChange = 0;
        }//Fim else if 
    }
    return(H);
}//Fim sequenciaA

int main()
{//Inicio main 
    int valorLido;
    printf("Digite o valor de N: ");
    scanf("%d", &valorLido);
    float resultado = sequenciaA(valorLido);
    printf("H = %f\n", resultado);
    return(0);
}//Fim main 

