#include <stdio.h>
#include <stdlib.h>

/*
    Tempo sequencial:
    real    0m0.314s
    user    0m0.044s
    sys     0m0.000s

    Tempo Paralelo CPU:
    real    0m0.106s
    user    0m0.055s
    sys     0m0.005s

    Tempo Paralelo GPU (distribute):
    real    0m3.017s
    user    0m0.908s
    sys     0m0.431s

    Nvprof: warps_launched       11928       11928       11928       11928
            warp_execution_efficiency                 Warp Execution Efficiency     100.00%     100.00%     100.00%

    Tempo Paralelo GPU (distribute parallel for):
    real    0m1.878s
    user    0m0.429s
    sys     0m0.192s

    Nvprof: warps_launched        1944        1944        1944        1944
            warp_execution_efficiency                 Warp Execution Efficiency     100.00%     100.00%     100.00%

    Tempo Paralelo GPU (distribute parallel for simd):
    real    0m1.376s
    user    0m0.180s
    sys     0m0.205s

    Nvprof: warps_launched         720         720         720         720
            warp_execution_efficiency                 Warp Execution Efficiency      13.10%      13.10%      13.10%

*/

void mm(double* a, double* b, double* c, int width)
{
    #pragma omp target map(to:a[:width * width]) map(to:b[:width * width]) map(tofrom:c[:width * width])
    #pragma omp teams distribute
	for (int i = 0; i < width; i++) {
		for (int j = 0; j < width; j++) {
			double sum = 0;
			for (int k = 0; k < width; k++) {
				double x = a[i * width + k];
				double y = b[k * width + j];
				sum += x * y;
			}
			c[i * width + j] = sum;
		}
	}
}

int main()
{
	int width = 300;
	double *a = (double*) malloc (width * width * sizeof(double));
	double *b = (double*) malloc (width * width * sizeof(double));
	double *c = (double*) malloc (width * width * sizeof(double));

    #pragma omp parallel for
	for(int i = 0; i < width; i++) {
		for(int j = 0; j < width; j++) {
			a[i*width+j] = i;
			b[i*width+j] = j;
			c[i*width+j] = 0;
		}
	}

	mm(a,b,c,width);

	//  for(int i = 0; i < width; i++) {
	//  for(int j = 0; j < width; j++) {
	//    printf("\n c[%d][%d] = %f",i,j,c[i*width+j]);
	//  }
	// }

}
