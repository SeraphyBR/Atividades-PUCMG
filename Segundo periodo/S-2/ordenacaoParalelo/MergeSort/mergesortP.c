#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

void mergesort(int a[], int i, int j, int proc);
void merge(int a[], int i1, int j1, int i2, int j2);
int a[1000000];
int Nthreads = 0, n = 0;

int main(){
    int i;
    int proc = omp_get_num_procs();
    omp_set_num_threads(proc);
    omp_set_nested(1);

    for(i = 0;i < 1000000; i++){
        scanf("%d",&a[i]);
    }
        
    mergesort(a, 0, 999999, proc);
    
    for(i= 0;i < 1000000; i++){
        printf ("%d\n", a[i]);
    }
}

void mergesort(int a[],int i,int j, int proc){
    int mid;
    n++;

    if(i < j){
        mid = (i + j)/2;

        if(n > 20){
            mergesort(a, i, mid, proc);
            mergesort(a, mid + 1, j, proc);
        }
        else{
            #pragma omp parallel sections num_threads(proc)
            {
                #pragma omp section
                {
                    mergesort(a, i, mid, proc);  
                }
                #pragma omp section
                {
                    mergesort(a, mid+1, j, proc);
                }
            }
        }
        
        merge(a, i, mid, mid+1, j);
    }
}
 
void merge(int a[], int i1, int j1, int i2, int j2){
    int temp[1000000];    
    int i, j, k;
    i = i1;    
    j = i2;    
    k = 0;
    
    while(i <= j1 && j <= j2){
        if(a[i] < a[j]){
            temp[k++]=a[i++];
        }
        else{
            temp[k++]=a[j++];
        }
    }    
    while(i <= j1){
        temp[k++]=a[i++];
    }
    while(j <= j2){
        temp[k++]=a[j++];
    }

    for(i = i1, j = 0; i <= j2; i++,j++){
        a[i]=temp[j];
    } 
}