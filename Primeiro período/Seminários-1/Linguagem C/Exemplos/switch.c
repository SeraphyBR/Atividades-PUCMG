#include  <stdio.h>

void main() {
   char c;

   scanf("%c", &c);
   switch (c) {
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u': printf("\nVogal!\n");
	    break;
      case ' ':  printf("\nEspaco!\n");
	    break;
      default:  printf("\nOutro caractere!\n");
   }
}
