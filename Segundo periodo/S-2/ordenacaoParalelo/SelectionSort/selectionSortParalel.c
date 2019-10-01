
/*
 * Autor: Luiz Junio Veloso Dos Santos
 * Criado em: 27/10/2018
 * Modificado em: 29/10/2018
 */

#include <omp.h>
#include <stdio.h>
#include <stdlib.h>

// Structure for enabling reduction on the index of elements
struct Compare { int val; int index; };
// Custom reduction for finding the index of the max element.
#pragma omp declare reduction(maximum : struct Compare : omp_out = omp_in.val > omp_out.val ? omp_in : omp_out)

void swap(int *a, int *b)
{//Inicio swap
    int tmp = *a;
    *a = *b;
    *b = tmp;
}//Fim swap

void selectionSort(int* array, int numElementos)
{//Inicio selectionSort
    int i, j;

    for(i = numElementos - 1; i > 0; i--)
    {//Inicio for i

        // Declare the structure required for reduction
        struct Compare max;

        // Initialize the variables
        max.val = array[i];
        max.index = i;

        // Parallel for loop with custom reduction, at the end of the loop, max will have the max element and its index.
        #pragma omp parallel for reduction(maximum:max)
        for(j = numElementos - 1; j >= 0; --j)
        {//Inicio for j
            if(array[j] > max.val){
                max.index = j;
                max.val = array[j];
            }
        }//Fim for j
        swap(&array[max.index], &array[i]);
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
    int array[1000000];
    for(int i = 0; i < 1000000; i++){
        scanf("%d", &array[i]);
    }

    imprimeArray(array, 1000000);
    selectionSort(array, 1000000);
    imprimeArray(array, 1000000);

    return 0;
}//Programa principal 


