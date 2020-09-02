#include <stdio.h>
#include <stdlib.h>

/*
    tempo sequencial:
    real    2,037
    user    2,032
    sys     0,004

    tempo pararelo sem politica:
    real    1,466
    user    2,758
    sys     0,012

    tempo paralelo com dynamic 1000:
    real    1,117
    user    2,222
    sys     0,000

    tempo paralelo com guided 200:
    real    1,181
    user    2,289
    sys     0,004

    Speedup sequencial/dynamic = 1.82
*/
int main()
{
    int i, j, n = 30000;

    // Allocate input, output and position arrays
    int *in = (int*) calloc(n, sizeof(int));
    int *pos = (int*) calloc(n, sizeof(int));
    int *out = (int*) calloc(n, sizeof(int));

    // Initialize input array in the reverse order
    #pragma omp parallel for private(i) num_threads(2)
    for(i=0; i < n; i++)
        in[i] = n-i;

    // Print input array
    //   for(i=0; i < n; i++)
    //      printf("%d ",in[i]);

    // Silly sort (you have to make this code parallel)
    #pragma omp parallel num_threads(2) private(i,j)
    {
        #pragma omp for schedule(guided, 200)
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
