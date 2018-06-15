//Autor: Luiz Junio Veloso Dos Santos
#include <stdio.h>

int main()
{//Inicio main 

    int alunos = 0;//Número de alunos; 
    int a, j; //Váriaveis para acessar a Matriz/Arranjo; 

    do{
        scanf("%d", &alunos); //Leitura da quantidade de alunos;
    }while(alunos < 1 || alunos > 100);

    char nome[alunos][16];//Define um Arranjo de Strings contendo o nome dos alunos, com o máximo de Caracteres;

    for(int i = 0; i < alunos; i++){
        scanf("%s", nome[i]); //Leitura dos nomes de cada aluno;
    }

    int nota[alunos][4];//Define a matriz contendo as notas de cada aluno, de cada prova;
    int notaFinal[alunos];//Define um Arranjo contendo a soma das notas de cada prova, de cada aluno;
    int maiorNota = 0;//Váriavel para armazenar a maior nota;
    int alunoMaiorNota = 0;//Váriavel para armazenar a posição do array em que está o aluno com a maior nota;

    for(a = 0; a < alunos; a++)
    {//Inicio for a 
        notaFinal[a] = 0;
        for(j = 0; j < 4; j++)
        {//Inicio for j 
            do{
                scanf("%d", &nota[a][j]);//Leitura das notas das provas;
            }while(nota[a][j] < 0 || nota[a][j] > 25);
            notaFinal[a] += nota[a][j];//Somatorio das notas de cada aluno;
        }//Fim for j
        if(notaFinal[a] > maiorNota){
            maiorNota = notaFinal[a];//Encontrando o aluno com a maior nota final;
            alunoMaiorNota = a;//Definido a posição do array do aluno de maior nota;
        }
    }//Fim for a 

    float mediaProva[4];//Arranjo contendo a média das notas de cada prova, do total de alunos;
    for(int p = 0; p < 4; p++)
    {//Inicio for p 
        mediaProva[p] = 0;//Iniciando com zero para garantir que nenhum lixo de memória seja incluso
        for(a = 0; a < alunos; a++){
            mediaProva[p] += nota[a][p];//Somatorio das notas de cada prova;
        }
        mediaProva[p] /= (float)alunos;//Divisão para o calculo da média;
    }//Fim for p 

    for(a = 0; a < alunos - 1; a++){ 
        printf("PROVA %d %.2f\n", a + 1, mediaProva[a]);//Saída contendo a nota média obtida em cada prova;
    }//Fim for 
    printf("%s %d\n", nome[alunoMaiorNota], maiorNota);//Saída do nome do aluno que obteve a maior nota, e a sua nota;
    
    return(0);
}//Fim main 