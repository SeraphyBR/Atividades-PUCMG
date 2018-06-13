//Autor: Luiz Junio Veloso Dos Santos
#include <stdio.h>

int main()
{//Inicio main 

    int alunos = 0;
    int a = 0, j = 0;
    int aprovados = 0, reprovados = 0;
    float sucesso = 0;

    do{
        scanf("%d", &alunos);
    }while(alunos < 1 || alunos > 100);

    char nome[alunos][10];

    for(int i = 0; i < alunos; i++){
        scanf("%s", nome[i]);
    }

    int nota[alunos][4];
    int notaFinal[alunos];

    for(a = 0; a < alunos; a++)
    {//Inicio for a 
        notaFinal[a] = 0;
        for(j = 0; j < 4; j++)
        {//Inicio for j 
            do{
                scanf("%d", &nota[a][j]);
            }while(nota[a][j] < 0 || nota[a][j] > 25);
            notaFinal[a] += nota[a][j];
        }//Fim for j
    }//Fim for a 

    for(a = 0; a < alunos; a++)
    {//Inicio for 
        printf("%s ", nome[a]);
        if(notaFinal[a] >= 60){
            printf("APROVADO\n");
            aprovados++;
        }    
        else{
            printf("REPROVADO\n");
            reprovados++;
        }
    }//Fim for 

    printf("%d APROVADOS\n", aprovados);
    printf("%d REPROVADOS\n", reprovados);
    sucesso = (float)aprovados/(float)alunos * 100;
    printf("%.0f%%\n", sucesso);

    return(0);
}//Fim main 