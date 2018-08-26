/*
 * Autor: Luiz Junio <luisjuniorbr@gmail.com>
 * Criado em: 21/08/2018
 *
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{//Inicio main

    FILE *arquivo;
    int numEntrada = 0;
    double valor = 0.0;
    char string[30];
    char *tmp;

    if((arquivo = fopen("numeros.txt", "w")) == NULL ){
        printf("Arquivo não pode ser aberto\n");
    }
    else
    {//Inicio else
        scanf("%d", &numEntrada);
        for(int i = 0; i < numEntrada; i++){
            scanf("%s", string);
            valor = strtod(string, &tmp);
            fprintf(arquivo, "%lf\n", valor);
        }
        fclose(arquivo);

        if((arquivo = fopen("numeros.txt", "r")) == NULL){
            printf("Arquivo não pode ser aberto\n");
        }
        else{
            for(int i = numEntrada; i > -1; i--){ 
                fseek(arquivo, i * sizeof(double), SEEK_SET);
                fread(string, sizeof(double), 1, arquivo);
                //fscanf(arquivo ,"%s", string);
                valor = strtod(string , &tmp);//Converte String para double
                printf("%g\n", valor);
            }//Fim for

            fclose(arquivo);
        }//Fim else 2
    }//Fim else
    return 0;
}//Fim main 
