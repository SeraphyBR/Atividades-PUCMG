
/*
 * Autor: Luiz Junio Veloso Dos Santos
 * Criado em: 27/10/2018
 * Modificado em: 29/10/2018
 */

#include <stdio.h>
#include <stdlib.h>

void swap(int *a, int *b)
{//Inicio swap
    int tmp = *a;
    *a = *b;
    *b = tmp;
}//Fim swap

void selectionSort(int* array, int numElementos)
{//Inicio selectionSort
    int i, j, posMenor;

    #pragma omp parallel for private(j)
    for(i = 0; i < numElementos - 1; i++)
    {//Inicio for i
        posMenor = i;
        for(j = i + 1; j < numElementos; j++)
        {//Inicio for j
            if(array[j] < array[posMenor]){
                posMenor = j;
            }
        }//Fim for j
        swap(&array[posMenor], &array[i]);
    }//Fim for i

}//Fim selectionSort

void imprimeArray(int* array, int tamanho)
{//Inicio imprimeArray
    if(array != NULL && tamanho > 0){
        for(int i = 0; i < tamanho; i++){
            printf("%d\n", array[i]);
        }
    } 
    else{
        printf("Parametros possuem valores invalidos!");
    }
}//Fim imprimeArray

int main()
{//Programa principal
    int array[10000];
    for(int i = 0; i < 10000; i++){
        scanf("%d", &array[i]);
    }

    imprimeArray(array, 10000);
    selectionSort(array, 10000);
    imprimeArray(array, 10000);

    return 0;
}//Programa principal 


