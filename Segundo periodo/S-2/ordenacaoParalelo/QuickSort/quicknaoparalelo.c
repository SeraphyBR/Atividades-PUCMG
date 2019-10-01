#include <stdio.h>
#include <stdlib.h>

int arr[1000000];

void swap(int* a, int* b) 
{ 
    int t = *a; 
    *a = *b; 
    *b = t;
} 

/*  
    Essa função usa o último elemento como pivô, 
    posiciona o elemento pivô na posição correta no 
    array ordenado e coloca todos os menores que o
    pivô à esquerda (do pivô) e todos os elementos
    maiores à direita
    */
int particao (int esq, int dir) 
{ 
    int pivo = arr[dir]; 
    int i = (esq - 1);  //menor elemento

    for (int j = esq; j <= dir- 1; j++) 
    { 
        if (arr[j] <= pivo) 
        { 
            i++;
            swap(&arr[i], &arr[j]); 
        } 
    } 
    swap(&arr[i + 1], &arr[dir]); 
    return (i + 1); 
} 

void quickSort(int esq, int dir)
{
    int pi; 
    if (esq < dir)
    {
        pi = particao( esq, dir);
        quickSort(esq, pi - 1);
        quickSort( pi + 1, dir);
    }
}

void quicksort(){
    quickSort(0, 999999);
}

int main() {

    int i;

    for(i = 0; i < 1000000; i++){
        scanf ("%d", &arr[i]); 	
    }
    quicksort();
    for(i = 0; i < 1000000; i++){
        printf ("%d\n", arr[i]);
    }
}
