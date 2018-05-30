#include <stdio.h>

int main()
{
    int N = 0;//Número total de figurinhas 
    int C = 0;//Número total de figurinhas carimbadas 
    int M = 0;//Número de figurinhas compradas
    int cont = 0;//Contador 1
    int cont2 = 0;//Contador 2
    int faltaC = 0;//Número de figurinhas carimbadas que faltam

    do{
        scanf("%d", &N);
    }while(N < 1 || N > 100);

    do{
        scanf("%d", &C);
    }while(C < 1 || C > N/2);

    int carimbada[C];//O número de cada figurinha carimbada
    
    do{
        scanf("%d", &M);
    }while(M < 1 || M > 300);

    int figurinha[M];//o número de cada figurinha comprada

    for(cont = 0; cont < C; cont++)
    {//Inicio for C
	do{
    	    scanf("%d", &carimbada[cont]);
	}while(carimbada[cont] < 1 || carimbada[cont] > N);
    }//Fim for C

    for(cont = 0; cont < M; cont++)
    {//Inicio for M

	do{
	    scanf("%d", &figurinha[cont]);
	}while(figurinha[cont] < 1 || figurinha[cont] > N);
    }//Fim for M
    
    faltaC = C;//Definindo o total de carimbadas
	
    for(cont = 0; cont < C; cont++)
    {//Inicio for cont
	for(cont2 = 0; cont2 < M; cont2++)
        {//Inicio for cont2
	    if(carimbada[cont] == figurinha[cont2]) faltaC--;
	    
	}//Fim for cont2

    }//Fim for cont	

    printf("%d\n", faltaC);

    return(0);
}
