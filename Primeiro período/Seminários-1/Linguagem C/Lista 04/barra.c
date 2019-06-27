//Autor: Luiz Junio Veloso Dos Santos 
#include <stdio.h>

int main()
{//Inicio main 
    int N = 0;//Tamanho do quadrado, largura e altura;
    int X[2], Y[2];//Arranjos contendo as coordenadas das duas figurinhas;
    int localFigura[2];//Arranjo para saber em que parte do quadrado cada figurinha está;

    do{
        scanf("%d",&N);//Leitura da dimensão do quadrado;
    }while((N % 2 != 0) && (N < 2 || N > 1000));

    for(int i = 0; i < 2; i++)
    {//Inicio for 
        do{
            scanf("%d", &X[i]);//Leitura da coordenada X de cada figurinha;
        }while(X[i] < 1 || X[i] > N);

        do{
            scanf("%d", &Y[i]);//Leitura da coordenada Y de cada figurinha;
        }while(Y[i] < 1 || Y[i] > N);
    }//Fim for 

    //Dividindo a barra de chocolate em Quatro partes, em sentido Horario: (Ideia dos quadrantes de uma circunferência)
    for(int i = 0; i < 2; i++)
    {//Inicio for 
        if(X[i] <= N/2)
        {//Inicio if  
            if(Y[i] <= N/2) localFigura[i] = 1; //Identificação da localização da figurinha na barra;
            else localFigura[i] = 4; //Identificação da localização da figurinha na barra;
        }//Fim if  
        else
        {//Inicio else  
            if(Y[i] <= N/2) localFigura[i] = 2; //Identificação da localização da figurinha na barra;
            else localFigura[i] = 3; //Identificação da localização da figurinha na barra;
        }//Fim else 
    }//Fim for 

    if(localFigura[0] == localFigura[1]) printf("N\n");//Saída falando se é possível dividir a barra ao meio e ter uma figurinha em cada pedaço;
    else printf("S\n");

    return(0);
}//Fim main 