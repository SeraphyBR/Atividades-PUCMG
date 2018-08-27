/*
 * Autor: Luiz Junio <luisjuniorbr@gmail.com>
 * Criado em: 21/08/2018
 * Ultima alteracao: 27/08/2018
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

    if((arquivo = fopen("numeros.txt", "wb+")) == NULL ){
        //Abrindo o arquivo para escrita em Byte
        printf("Arquivo não pode ser aberto\n");
    }
    else
    {//Inicio else
        scanf("%d", &numEntrada);
        for(int i = 0; i < numEntrada; i++){
            scanf("%lf", &valor);
            //fprintf(arquivo, "%lf\n", valor);
            //Usando o fwrite para escrever em bytes
            fwrite(&valor, sizeof(double), 1, arquivo);
        }
        fclose(arquivo);

        if((arquivo = fopen("numeros.txt", "r+")) == NULL){
            printf("Arquivo não pode ser aberto\n");
        }
        else{
            for(int i = numEntrada - 1; i > -1; i--){ 
                fseek(arquivo, i * sizeof(double), SEEK_SET);
                fread(&valor, sizeof(double), 1, arquivo);
                //fscanf(arquivo ,"%s", string);
                printf("%g\n", valor);
            }//Fim for
            fclose(arquivo);
        }//Fim else 2
    }//Fim else
    return 0;
}//Fim main 
