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
        scanf("%s", nome[i]);
    }

    int nota[alunos][4];
    int notaFinal[alunos];
    int maiorNota = 0;
    int alunoMaiorNota = 0;

    for(a = 0; a < alunos; a++)
    {//Inicio for a 
        for(j = 0; j < 4; j++)
        {//Inicio for j 
            do{
                scanf("%d", &nota[a][j]);
            }while(nota[a][j] < 0 || nota[a][j] > 25);
            notaFinal[a] += nota[a][j];
        }//Fim for j
        if(notaFinal[a] > maiorNota){
            maiorNota = notaFinal[a];
            alunoMaiorNota = a;
        }
    }//Fim for a 

    float mediaProva[4];
    for(int p = 0; p < 4; p++)
    {//Inicio for p 
        for(a = 0; a < alunos; a++){
            mediaProva[p] += nota[a][p];
        }
        mediaProva[p] /= (float)alunos;
    }//Fim for p 

    for(a = 0; a < alunos; a++){ 
        printf("PROVA %d %.2f\n", a + 1, mediaProva[a]);
    }//Fim for 
    printf("%s %d\n", nome[alunoMaiorNota], maiorNota);
    

    return(0);
}//Fim main 