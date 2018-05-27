#include<stdio.h>
#include <stdlib.h>

int main() {
	
	int tamanho;
	int *v;
	int i;

	scanf("%d", &tamanho);
	v = (int*)calloc(tamanho,sizeof(int));
	
	printf("\n Carregando o vetor: ");
	for(i=0; i<tamanho; i++){
		v[i] = ((i+1));
		printf("%d ", v[i]);
	}
	
	free(v);
    return 0;
}
