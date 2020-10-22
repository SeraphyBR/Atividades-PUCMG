#include <stdio.h>
#include <stdlib.h>

/*
    Tempo sequencial:
    real    1m6.953s
    user    1m6.791s
    sys     0m0.100s

    Tempo Paralelo CPU:
    real    0m17.541s
    user    1m9.719s
    sys     0m0.144s

    Tempo Paralelo GPU (distribute parallel for simd):
    real    0m5.409s
    user    0m3.535s
    sys     0m1.883s

    Nvprof: warps_launched          72          72          72          72
            warp_execution_efficiency                 Warp Execution Efficiency      13.10%      13.10%      13.10%

    Tempo Paralelo GPU (CUDA):
    real    0m0.883s
    user    0m0.028s
    sys     0m0.776s

    Nvprof: warps_launched        3200        3200        3200        3200
            warp_execution_efficiency                 Warp Execution Efficiency      93.77%      93.77%      93.77%

*/

__global__ void mm_cuda(double* a, double* b, double* c, int width) {
    int i = blockIdx.x * blockDim.x + threadIdx.x;
    int j = blockIdx.y * blockDim.y + threadIdx.y;

    double sum = 0;
    if(i < width && j < width) {
        for (int k = 0; k < width; k++) {
            double x = a[i * width + k];
            double y = b[k * width + j];
            sum += x * y;
        }
        c[i * width + j] = sum;
    }
}

int main()
{
	int width = 2000;
    int size = width * width * sizeof(double);
	double *a = (double*) malloc (size);
	double *b = (double*) malloc (size);
	double *c = (double*) malloc (size);

	for(int i = 0; i < width; i++) {
		for(int j = 0; j < width; j++) {
			a[i*width+j] = i;
			b[i*width+j] = j;
			c[i*width+j] = 0;
		}
	}

    double *d_a, *d_b, *d_c;

    cudaMalloc((void **) &d_a, size);
    cudaMemcpy(d_a, a, size, cudaMemcpyHostToDevice);

    cudaMalloc((void **) &d_b, size);
    cudaMemcpy(d_b, b, size, cudaMemcpyHostToDevice);

    cudaMalloc((void **) &d_c, size);

    int block_size = 32; // 32 * 32 = 1024;

    int num_blocks = (width - 1) / block_size + 1;
    dim3 dimGrid(num_blocks, num_blocks, 1);
    dim3 dimBlock(block_size, block_size, 1);

	mm_cuda<<<dimGrid, dimBlock>>>(d_a,d_b,d_c,width);

    cudaMemcpy(c, d_c, size, cudaMemcpyDeviceToHost);

	//for(int i = 0; i < width; i++) {
	//    for(int j = 0; j < width; j++) {
	//        printf("\n c[%d][%d] = %f",i,j,c[i*width+j]);
	//    }
	//}

    cudaFree(d_a);
    cudaFree(d_b);
    cudaFree(d_c);
}
