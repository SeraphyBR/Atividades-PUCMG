#include<stdio.h>

int main(){
	unsigned int v = 0;
	
	printf("\n\tMaior inteiro sem sinal: %u", --v);
	printf("\n\tMaior inteiro positivo: %d", v/2);
	printf("\n\tMaior inteiro negativo: %d", -(int)(v/2)-1);
	printf("\n\tBytes de um inteiro: %lu\n", sizeof(int));
	return(0);
}
