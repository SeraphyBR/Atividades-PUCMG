//Autor: Luiz Junio Veloso Dos Santos
#include <stdio.h>

int main()
{//Inicio main 

    int alunos = 0; //Número de Alunos 
    int a, j; //Váriaveis para acessar a Matriz/Arranjo 

    do{
        scanf("%d", &alunos);
    }while(alunos < 1 || alunos > 100);

    char nome[alunos][16]; //Define um Arranjo de Strings contendo o nome dos alunos, com o máximo de Caracteres

    for(int i = 0; i < alunos; i++){
        scanf("%s", nome[i]);    //Entrada dos nomes pelo usuario;
    }

    int nota[alunos][4];//Define a matriz contendo as notas de cada aluno, de cada prova;
    int notaFinal[alunos];//Define um Arranjo contendo a soma das notas de cada prova, de cada aluno;

    for(a = 0; a < alunos; a++)
    {//Inicio for a 
        notaFinal[a] = 0;
        for(j = 0; j < 4; j++)
        {//Inicio for j 
            do{
                scanf("%d", &nota[a][j]); //Leitura das notas das provas
            }while(nota[a][j] < 0 || nota[a][j] > 25);
            notaFinal[a] += nota[a][j]; //Somatória das notas dos alunos
        }//Fim for j
    }//Fim for a 

    for(a = 0; a < alunos; a++){
        printf("%s %d\n", nome[a], notaFinal[a]);//Saída contendo o nomde de cada aluno e a somatoria das notas;
    }

    return(0);
}//Fim main 