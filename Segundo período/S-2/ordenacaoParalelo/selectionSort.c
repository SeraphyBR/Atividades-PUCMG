
#include <stdio.h>

void swap(int *a, int *b)
{//Inicio swap
    int tmp = *a;
    *a = *b;
    *b = tmp;
}//Fim swap

void selectionSort(int array[], int numElementos)
{//Inicio selectionSort
    int i, j, posMenor;

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

void imprimeArray(int array[], int tamanho)
{
    if(array != NULL && tamanho > 0)
    {
        for(int i = 0; i < tamanho; i++){
            printf("%d", array[i]);
        }
        printf("\n"); 
    }
    else
    {
        printf("Parametros possuem valores invalidos!");
    }
}

int main()
{//Programa principal
    int array[] = {9,8,7,6,5,4,3,2,1,0};
    int tamanho = sizeof(array)/sizeof(array[0]);
    imprimeArray(array, tamanho);
    selectionSort(array, tamanho);
    imprimeArray(array, tamanho);

    return 0;
}//Programa principal 

