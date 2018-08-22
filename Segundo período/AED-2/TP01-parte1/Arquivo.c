/*
 * Autor: Luiz Junio <luisjuniorbr@gmail.com>
 * Criado em: 21/08/2018
 *
 *
 */

#include <stdio.h>
#include <stdlib.h>

int main()
{//Inicio main

    FILE *arquivo;
    int numEntrada = 0;
    float valor = 0.0;
    if((arquivo = fopen("numeros.txt", "w")) == NULL ){
        printf("Arquivo não pode ser aberto\n");
    }
    else
    {//Inicio else
        scanf("%d", &numEntrada);

        for(int i = 0; i < numEntrada; i++){
            scanf("%f", &valor);
            if(valor == (int) valor){
                fprintf(arquivo, "%d\n", (int) valor);
            }
            else{
                fprintf(arquivo, "%f\n", valor);
            }
        }
        fclose(arquivo);

        arquivo = fopen("numeros.txt", "r");

        for(int i = 0; i < numEntrada; i++){
            fseek(arquivo, -1 * i * sizeof(double), SEEK_END);
            fscanf(arquivo, "%f", &valor);
            if(valor == (int) valor){
                printf("%d\n", (int) valor);
            }
            else{
                printf("%g\n",valor);// g -> Imprime sem os zeros finais
            }
        }

        fclose(arquivo);
    }//Fim else
    return 0;
}//Fim main 
