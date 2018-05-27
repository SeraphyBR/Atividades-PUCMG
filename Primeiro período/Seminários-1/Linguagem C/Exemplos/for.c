#include  <stdio.h>
void main() {
   int i;
   int quantos;
   int vet[100];
   float soma, media;

   scanf("%d", &quantos);
   soma = 0;
   for (i = 0; i<quantos; i++) { 
      scanf("%d", &vet[i]);
   }
   for (i = 0; i<quantos; i++) { 
      soma+=vet[i];
   }
   media = soma/quantos;
   printf ("Média do vetor: %f\n", media);
}
