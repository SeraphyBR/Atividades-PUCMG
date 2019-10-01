#include<stdio.h>
#include<stdlib.h>
int main() {   // CONTEÚDO  ENDEREÇO
  int a;		// "lixo”	?
  int b;		// "lixo” 	?
  float x;		// "lixo” 	?

  printf("Endereços:\ta:%u \tb:%u \tx:%u\n",&a,&b,&x);
  printf("Valores  :\ta:%d \tb:%d \tx:%.2f\n",a,b,x);
  a = 0;		//  0		
  b = 1;		//  1		
  x = 2.2f;		// 2.2		
  
  do {
    a = a + 1;
    b = b + 2;
    x = x * a;
    x = x * b;
    printf("\nEndereços:\ta:%u \tb:%u \tx:%u\n",&a,&b,&x);
    printf("Valores  :\ta:%d \tb:%d \tx:%.2f\n",a,b,x);
  } while (x < 20.0f);
  return 0;
}
