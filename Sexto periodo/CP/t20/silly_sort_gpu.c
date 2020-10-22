#include <stdio.h>
#include <stdlib.h>

/*
03:
    tempo sequencial:
    real    0m20.731s
    user    0m20.714s
    sys     0m0.008s

    tempo pararelo CPU, dynamic 1000:
    real    0m7.984s
    user    0m31.766s
    sys     0m0.032s

    tempo paralelo GPU:
    real    0m3.244s
    user    0m2.498s
    sys     0m0.744s

*/
int main()
{
    int i, j, n = 100000;

    // Allocate input, output and position arrays
    int *in = (int*) calloc(n, sizeof(int));
    int *pos = (int*) calloc(n, sizeof(int));
    int *out = (int*) calloc(n, sizeof(int));

    // Initialize input array in the reverse order
    for(i=0; i < n; i++)
        in[i] = n-i;

    // Print input array
    //   for(i=0; i < n; i++)
    //      printf("%d ",in[i]);

    // Silly sort (you have to make this code parallel)
    #pragma omp target map(tofrom:pos[:n]) map(to:in[:n])
    #pragma omp teams distribute parallel for simd
    for(i=0; i < n; i++)
        for(j=0; j < n; j++)
            if(in[i] > in[j])
                pos[i]++;

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
