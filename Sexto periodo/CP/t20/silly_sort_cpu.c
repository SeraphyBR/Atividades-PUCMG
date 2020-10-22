#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i, j, n = 100000;

    // Allocate input, output and position arrays
    int *in = (int*) calloc(n, sizeof(int));
    int *pos = (int*) calloc(n, sizeof(int));
    int *out = (int*) calloc(n, sizeof(int));

    // Initialize input array in the reverse order
    #pragma omp parallel for private(i)
    for(i=0; i < n; i++)
        in[i] = n-i;

    // Print input array
    //   for(i=0; i < n; i++)
    //      printf("%d ",in[i]);

    // Silly sort (you have to make this code parallel)
    #pragma omp parallel private(i,j)
    {
        #pragma omp for schedule(dynamic, 1000)
        for(i=0; i < n; i++)
            for(j=0; j < n; j++)
                if(in[i] > in[j])
                    pos[i]++;
    }

    // Move elements to final position
    for(i=0; i < n; i++)
        out[pos[i]] = in[i];

    // print output array
    //   for(i=0; i < n; i++)
    //      printf("%d ",out[i]);

    // Check if answer is correct
    for(i=0; i < n; i++)
        if(i+1 != out[i])
        {
            printf("test failed\n");
            exit(0);
        }

    printf("test passed\n");
}