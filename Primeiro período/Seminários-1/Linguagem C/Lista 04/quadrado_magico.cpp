#include <stdio.h>

int main()
{//Inicio main 
    int N = 0, i = 0, j = 0;
    int somaLinha = 0, somaColuna = 0, somaDiagonal = 0;

    do{
        scanf("%d", &N);
    }while(N < 3 || N > 100);

    int quadrado[N][N];
    for(i = 0; i < N; i++)
    {//Inicio for i  
        for(j = 0; j < N; j++)
        {//Inicio for j
            do{
                scanf("%d", &quadrado[i][j]);
            }while(quadrado[i][j] < 1 || quadrado[i][j] > 100);
        }//Fim for j 
    }//Fim for i  

    for(i = 0; i < N; i++){
        somaLinha += quadrado[i][0];
    }

    for(j = 0; j < N; j++){
        somaColuna += quadrado[0][j];
    }

    for(i = 0; i < N; i++){
        somaDiagonal += quadrado[i][i];
    }

    if(somaLinha == somaColuna && somaLinha == somaDiagonal) printf("%d\n",somaLinha);
    else printf("0\n");

    return(0);
}//Fim main 