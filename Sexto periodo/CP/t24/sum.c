#include <stdio.h>
#include <stdlib.h>

int main() {
    int width = 40000000;
    int size = width * sizeof(double);

    double sum = 0;
    double *a = (double*) malloc (size);

    //#pragma omp parallel for
    for(int i = 0; i < width; i++)
        a[i] = i;

    #pragma omp target map(tofrom:sum) map(to:a[:width])
    #pragma omp teams distribute parallel for simd reduction(+:sum)
    //#pragma omp parallel for reduction(+:sum)
    for(int i = 0; i < width; i++)
        sum += a[i];

    printf("\nSum = %f\n",sum);

    return 0;
}