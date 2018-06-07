#include <stdio.h>

int main()
{//Inicio main 
    int N = 0;
    int X[2], Y[2];
    int localFigura[2];

    do{
        scanf("%d",&N);
    }while((N % 2 != 0) && (N < 2 || N > 1000));

    for(int i = 0; i < 2; i++)
    {//Inicio for 
        do{
            scanf("%d", &X[i]);
        }while(X[i] < 1 || X[i] > N);

        do{
            scanf("%d", &Y[i]);
        }while(Y[i] < 1 || Y[i] > N);
    }//Fim for 

    //Dividindo o quadrado em Quatro partes, em sentido Horario
    for(int i = 0; i < 2; i++)
    {//Inicio for 
        if(X[i] <= N/2)
        {//Inicio if  
            if(Y[i] <= N/2) localFigura[i] = 1;
            else localFigura[i] = 4; 
        }//Fim if  
        else
        {//Inicio else  
            if(Y[i] <= N/2) localFigura[i] = 2;
            else localFigura[i] = 3;
        }//Fim else 
    }//Fim for 

    if(localFigura[0] == localFigura[1]) printf("N\n");
    else printf("S\n");
}//Fim main 