/*
Dado um número inteiro, calcule e mostre, nesta ordem:
* Se ele é par ou ímpar;
* O seu dobro;
* O seu quadrado;
* Caso haja uma letra correspondente ao número, informar esta letra.
*/

#include <stdio.h>

int main() 
{//Inicio main
    int numero = 0;

    do{
            scanf("%d", &numero);
    }while(numero < 0 || numero > 5000);

    while(numero != 0)
    {//Inicio while 
        
        if(numero % 2 == 0) printf("PAR,");
        else printf("IMPAR,");
        
        printf("%d,", numero * 2);
        printf("%d,", numero * numero);
        if (numero >= 65 && numero <= 90 || numero >= 97 && numero <= 122) printf("%c\n", numero); //tabela ASCII
        else printf("NAO E LETRA\n");

        do{
            scanf("%d", &numero);
        }while(numero < 0 || numero > 5000);
    }//Fim while

}//Fim main