//Autor: Luiz Junio Veloso Dos Santos
#include <stdio.h>

int main()
{//Inicio main 
    int N = 0, i = 0, j = 0;//Dimensões do quadrado; Variaveis para navegar pelas matrizes/Array;
    int somaLinha = 0, somaColuna = 0, somaDiagonal = 0;//Soma das linhas, colunas e diagonal;

    do{
        scanf("%d", &N);//Leitura das Dimensões do quadrado, lado e altura;
    }while(N < 3 || N > 100);

    int quadrado[N][N];
    for(i = 0; i < N; i++)
    {//Inicio for i  
        for(j = 0; j < N; j++)
        {//Inicio for j
            do{
                scanf("%d", &quadrado[i][j]);//Leitura dos números do quadrado mágico;
            }while(quadrado[i][j] < 1 || quadrado[i][j] > 100);
            
        }//Fim for j 
    }//Fim for i  

    for(i = 0; i < N; i++){
        somaLinha += quadrado[i][0];//Somatorio dos valores da primeira linha;
    }

    for(j = 0; j < N; j++){
        somaColuna += quadrado[0][j];//Somatorio dos valores da primeira coluna;
    }

    for(i = 0; i < N; i++){
        somaDiagonal += quadrado[i][i];//Somatorio dos valores na Diagonal principal;
    }

    if(somaLinha == somaColuna && somaLinha == somaDiagonal) printf("%d\n",somaLinha);
    else printf("0\n");

    return(0);
}//Fim main 