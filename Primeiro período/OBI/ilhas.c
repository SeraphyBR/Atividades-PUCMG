//Autor: Luiz Junio Veloso Dos Santos <luisjuniorbr@gmail.com>
#include <stdio.h>

int main()
{//Inicio main 
    int N = 0;//Número de ilhas
    int M = 0;//Número de cabos 
    int S = 0;//Ilha do servidor
    int menor = 1000;//Menor ping
    int maior = 0;//Maior ping

    do{
    	scanf("%d", &N);
    }while(N < 2 || N > 1000);
   
    do{
    	scanf("%d", &M);
    }while(M < N - 1 || M > 100000);

    int conexao[M][3];
    
    for(int i = 0; i < M; i++)
    {//Inicio for 
	    do{
	        scanf("%d", &conexao[i][0]);
	    }while(conexao[i][0] < 1 || conexao[i][0] > N);

    	do{
    	    scanf("%d",&conexao[i][1]);
        }while(conexao[i][1] < 1 || conexao[i][1] > N);

    	do{
    	    scanf("%d",&conexao[i][2]);
    	}while(conexao[i][2] < 1 || conexao[i][2] > 1000);
    }//Fim for  

    do{
       scanf("%d", &S);
    }while(S < 1 || S > N);
	
    for(int i = 0; i < M; i++)
    {//Inicio for   
	    if(conexao[i][0] != S && conexao[i][1] != S)
        {
	    	if(conexao[i][2] < menor) menor = conexao[i][2];
	    	if(conexao[i][2] > maior) maior = conexao[i][2];
	    }
    }//Fim for   
    printf("%d\n", maior - menor);
    return(0);
  
}//Fim main 
