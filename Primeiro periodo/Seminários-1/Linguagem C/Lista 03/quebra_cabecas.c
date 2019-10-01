/*
Escreva um programa que, dado um inteiro N e N−1 inteiros numerados de 1 a N, descubra qual
inteiro está faltando.
*/

#include <stdio.h>

void ordenaVetor(int *vetor, int tamanho)
{//Inicio ordenaVetor
    int aux = 0, i = 0, j = 0;
    for(i = 0; i < tamanho; i++)
    {//Inicio for i  
        for(j = 0; j < tamanho; j++)
        {//Inicio for j 
            if(vetor[i] < vetor[j])
            {//Inicio if  
                aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
            }//Fim if  
        }//Fim for j 
    }//Fim for i  

}//Fim ordenaVetor

int main() 
{//Inicio main 
    int tamanho = 0, i, busca = 1;
    int encontrado = 0, faltante = 0;
    
    //Leitura do tamanho do vetor; 
    do{
        //printf("Digite o tamanho do quebra cabeças: ");
        scanf("%d", &tamanho);
    }while(tamanho < 2 || tamanho > 1000);

    tamanho--; //Tirando um do tamanho, considerando que falta uma peça

    int vetor[tamanho];

    //Preenchendo o vetor 
    for(i = 0; i < tamanho ; i++)
    {//Inicio for 

        do{
            //printf("Digite o %dº valor:", i + 1);
            scanf("%d", &vetor[i]);
        }while(vetor[i] < 1 || vetor[i] > tamanho + 1);

    }//Fim for 

    ordenaVetor(vetor,tamanho);

    if(vetor[0] != 1) faltante = 1;
    else
    {//Inicio else 
        i = 0;
        while(i < tamanho && encontrado == 0)
        {//Inicio while 
            if(vetor[i + 1] != (vetor[i] + 1))
            {//Inicio if  
                faltante = vetor[i] + 1;
                encontrado = 1;
            }//Fim if  
            i++;
        }//Fim while 
    }//Fim else 
    printf("%d\n", faltante);

    return(0);

}//Fim main