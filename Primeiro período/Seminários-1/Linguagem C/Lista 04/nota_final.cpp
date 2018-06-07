#include <stdio.h>

int main()
{//Inicio main 

    int alunos = 0;
    int a, j;

    do{
        scanf("%d", &alunos);
    }while(alunos < 1 || alunos > 100);

    char nome[alunos][10];

    for(int i = 0; i < alunos; i++){
        scanf("%s", &nome[i]);
    }

    int nota[alunos][4];
    int notaFinal[alunos];

    for(a = 0; a < alunos; a++)
    {//Inicio for a 
        for(j = 0; j < 4; j++)
        {//Inicio for j 
            do{
                scanf("%d", &nota[a][j]);
            }while(nota[a][j] < 0 || nota[a][j] > 25);
            notaFinal[a] += nota[a][j];
        }//Fim for j
    }//Fim for a 

    printf("SAIDA\n");
    for(a = 0; a < alunos; a++){
        printf("%s %d\n", nome[a], notaFinal[a]);
    }

    return(0);
}//Fim main 