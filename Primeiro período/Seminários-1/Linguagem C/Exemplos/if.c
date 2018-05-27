/* Converte uma letra maiúscula para minúscula*/

#include <stdio.h>

void main() {
   char letra;
   int dif;

   dif = 'a' - 'A';
   scanf("%c", &letra);
   if (letra >= 'A' && letra <= 'Z') {
        letra = letra + dif;
	printf("A letra em minúscula: %c\n", letra);
   }
   else
       printf ("\nNao e' maiuscula: %c\n", letra);
}
