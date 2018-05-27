#include  <stdio.h>

void main() {
   int n;
   int soma = 0;

   scanf("%d", &n);
   do { 
      soma = soma + (n % 10);
      n = n/10;
   } while (n > 0);
   printf ("Soma dos dígitos: %d\n", soma);
}
