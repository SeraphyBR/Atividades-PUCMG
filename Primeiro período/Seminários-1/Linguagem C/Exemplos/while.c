#include  <stdio.h>

void main() {
   int c;
   int quantos = 0;

   scanf("%i", &c);
   while (c >= 0 && c <= 100) {
      printf("\nOK!: %d\n", c);
      quantos++;
      scanf("%i", &c);
   }
   printf ("\n\tFim de leitura. Quantidade de números: %d\n", quantos);
}
