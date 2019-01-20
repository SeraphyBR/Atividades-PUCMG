#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

int arr[1000000];
int Nthreads = 4, n = 0;


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
    n++; 
    if (esq < dir)
    {
        pi = particao( esq, dir);

        if(n > 20){
            quickSort(esq, pi - 1);
            quickSort( pi + 1, dir);
        }
        else{                           
            #pragma omp parallel sections num_threads(Nthreads) 
            {
                #pragma omp section
                quickSort(esq, pi - 1);
                #pragma omp section
                quickSort( pi + 1, dir);
            }
        }
    }
}

void quicksort(){
    quickSort(0, 999999);
}

int main() {

    int i;
    omp_set_num_threads(4);
    omp_set_nested(1);

    for(i = 0; i < 1000000; i++){
        scanf ("%d", &arr[i]); 	
    }
    quicksort();
    for(i = 0; i < 1000000; i++){
        printf ("%d\n", arr[i]);
    }
}
