//Autor: Luiz Junio Veloso Dos Santos
#include <stdio.h>

int main()
{//Inicio main 

    int alunos = 0;//Número de alunos;
    int a = 0, j = 0;//Váriaveis para navegar pela matriz/Array;
    int aprovados = 0, reprovados = 0;//Número de alunos aprovados e reprovados;
    float sucesso = 0;//Porcentagem de aprovados;

    do{
        scanf("%d", &alunos);//Leitura do número de alunos;
    }while(alunos < 1 || alunos > 100);

    char nome[alunos][16];//Define um Arranjo de Strings contendo o nome dos alunos, com o máximo de Caracteres;

    for(int i = 0; i < alunos; i++){
        scanf("%s", nome[i]);//Leitura dos nomes de cada aluno;
    }

    int nota[alunos][4];//Define a matriz contendo as notas de cada aluno, de cada prova;
    int notaFinal[alunos];//Define um Arranjo contendo a soma das notas de cada prova, de cada aluno;

    for(a = 0; a < alunos; a++)
    {//Inicio for a 
        notaFinal[a] = 0;
        for(j = 0; j < 4; j++)
        {//Inicio for j 
            do{
                scanf("%d", &nota[a][j]);//Leitura das notas de cada prova;
            }while(nota[a][j] < 0 || nota[a][j] > 25);
            notaFinal[a] += nota[a][j];//Somatorio das notas de cada aluno;
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

    printf("%d APROVADOS\n", aprovados);//Saída do número de aprovados;
    printf("%d REPROVADOS\n", reprovados);//Saída do número de reprovados;
    sucesso = (float)aprovados/(float)alunos * 100;//Calculo da Porcentagem de aprovados;
    printf("%.0f%%\n", sucesso);//Saída da Porcentagem de aprovados;

    return(0);
}//Fim main 
