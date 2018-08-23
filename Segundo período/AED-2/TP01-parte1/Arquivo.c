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
    int posicao = 0;
    if((arquivo = fopen("numeros.txt", "w")) == NULL ){
        printf("Arquivo não pode ser aberto\n");
    }
    else
    {//Inicio else
        scanf("%d", &numEntrada);

        for(int i = 0; i < numEntrada; i++){
            scanf("%f", &valor);
            fprintf(arquivo, "%f\n", valor);
        }
        fclose(arquivo);

        if((arquivo = fopen("numeros.txt", "r")) == NULL){
            printf("Arquivo não pode ser aberto\n");
        }
        else{
            fseek(arquivo, 0, SEEK_END);
            posicao = ftell(arquivo);
            for(int i = 0; ftell(arquivo) != 0 && i < numEntrada; i++){
                printf("Posicao i: %ld\n" ,ftell(arquivo));
                fseek(arquivo, 1 * sizeof(float), SEEK_CUR);
                printf("Posicao m: %ld\n", ftell(arquivo));
                fscanf(arquivo ,"%f", &valor);
                printf("Posicao f: %ld\n", ftell(arquivo));
                if(valor == (int) valor){//Se for um numero inteiro, será impresso como inteiro
                    printf("%d\n", (int) valor);
                }
                else{
                    printf("%g\n",valor);// g -> Imprime sem os zeros finais
                }
                fseek(arquivo, -1 * sizeof(float), SEEK_CUR);
            }//Fim for

            fclose(arquivo);
        }//Fim else 2
    }//Fim else
    return 0;
}//Fim main 
