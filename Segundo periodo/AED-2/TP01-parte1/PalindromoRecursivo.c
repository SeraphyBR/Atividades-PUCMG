/*
 *  Autor: Luiz Junio <luisjuniorbr@gmail.com>
 *  Enunciado:
 *   Palindromo em C - Na linguagem C, crie um metodo *Recursivo que recebe uma string como
 *   parametro e retorna true se essa e um palindromo. Na saida padrao, para cada linha de entrada,
 *   escreva uma linha de saida com SIM / NAO indicando se a linha e um palindromo.
 *   Observacao: Uma linha de entrada pode ter caracteres nao letras.
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int ehPalindromo(char palavra[], int i)
{//Inicio ehPalindromo
    /***************************************************************
    * Nome do metodo: ehPalindromo
    * Data da elaboração: 14/08/2018
    * Data da ultima alteração: 14/08/2018
    * Autor: Luiz Junio <luisjuniorbr@gmail.com>
    * Contexto de ação: Verificar se uma String pode ser lida da esquerda
    * para a direita, e vice-versa.
    * Valor gerado: 1 se for um paindromo, 0 caso contrário.
    ****************************************************************
    */
    int palindromo = 1;//TRUE
    int ultimo = strlen(palavra) - 1;//Posicao da ultima letra

    if(i < strlen(palavra) / 2)
    {//Inicio if
        if(palavra[i] == palavra[ultimo - i]){
            palindromo = ehPalindromo(palavra, i + 1);
        }
        else{
            palindromo = 0;//FALSE
        }
    }//Fim if
    return palindromo;
}//Fim ehPalindromo

int main()
{//Inicio main
    char palavra[1000][1000];//Iniciando um Array de "Strings"
    int numEntrada = 0;
    do{
        //Esse scanf irá ler a string, incluindo espaços.
        //O espaço antes de % serve para limpar o buffer do teclado 
        scanf(" %[^\n]s", palavra[numEntrada]);
    }while(strcmp(palavra[numEntrada++], "FIM") != 0);//Repete enquanto não for igual a FIM

    numEntrada--; //Desconsiderar ultima linha contendo a palavra FIM

    for(int i = 0; i < numEntrada; i++)
    {//Inicio for
        if(ehPalindromo(palavra[i], 0)){
            printf("SIM\n");
        }
        else{
            printf("NAO\n");
        }
    }//Fim for
    return 0;//Indica que o programa terminou com sucesso
}//Fim main 

