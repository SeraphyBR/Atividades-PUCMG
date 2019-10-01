#include<stdio.h>
#include<stdlib.h>
int main() {
  int i=42;
  float f=4.2f;
  double d=8.4d;
  int *pi;	
  float *pf;	
  double *pd;	

  printf("Endereços:\t pi:%u, pf:%u, pd:%u\n", pi, pf, pd);
  printf("Endereços:\t i:%u, f:%u, d:%u\n", &i, &f, &d);
  printf("Valores:\t pi:%d, pf:%f, pd:%f\n", *pi, *pf, *pd);
  pi = &i;
  pf = &f;
  pd = &d;
  printf("\nEndereços:\t pi:%u, pf:%u, pd:%u\n", pi, pf, pd);
  printf("Valores:\t pi:%d, pf:%f, pd:%f\n", *pi, *pf, *pd);
  return 0;
}
