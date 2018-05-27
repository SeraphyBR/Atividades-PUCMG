#include  <stdio.h>

void main() {
   char oper;
   float n1, n2;
   float res;

   scanf("%f %c %f", &n1, &oper, &n2);
   switch (oper) {
      case '+': res = n1+n2; break;
      case '-': res = n1-n2; break;
      case '*': res = n1*n2; break;
      case '/': res = n1/n2; break;
      default:  printf("\nOperação desconhecida!\n");
		return;
   }
   printf("%f %c %f = %f\n", n1,oper,n2,res); 
}
