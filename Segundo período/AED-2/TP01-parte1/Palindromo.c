
/*
 *  Autor: Luiz Junio <luisjuniorbr@gmail.com>
 *  Enunciado:
 *   Palindromo em C - Na linguagem C, crie um metodo iterativo que recebe uma string como
 *   parametro e retorna true se essa e um palindromo. Na saida padrao, para cada linha de entrada,
 *   escreva uma linha de saida com SIM / NAO indicando se a linha e um palindromo.
 *   Observacao: Uma linha de entrada pode ter caracteres nao letras.
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int ehPalindromo(char palavra[])
{//Inicio ehPalindromo
    int palindromo = 1;//TRUE
    int letra = 0;
    int ultimo = strlen(palavra) - 1;//Posicao da ultima letra

    while(letra < strlen(palavra) / 2 && palindromo)
    {//Inicio while
        if(palavra[letra] != palavra[ultimo - letra]){
            palindromo = 0;//FALSE
        }
        letra++;
    }//Fim while
    return palindromo;
}//Fim ehPalindromo

int main()
{//Inicio main
    char palavra[1000][1000];
    int numEntrada = 0;
    do{//leitura da entrada padrao
        scanf(" %[^\n]s", palavra[numEntrada]);
        //Esse scanf irá ler a string, incluindo espaços.
        //O espaço antes de % serve para limpar o buffer do teclado
    }while(strcmp(palavra[numEntrada++], "FIM") != 0);//Repete enquanto não for igual a FIM

    numEntrada--; //Desconsiderar ultima linha contendo a palavra FIM

    for(int i = 0; i < numEntrada; i++)
    {//Inicio for
        if(ehPalindromo(palavra[i])){
            printf("SIM\n");
        }
        else{
            printf("NAO\n");
        }
    }//Fim for

}//Fim main 

