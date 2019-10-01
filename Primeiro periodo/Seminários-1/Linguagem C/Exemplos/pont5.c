#include<stdio.h>
#include <stdlib.h>

int main() {
	
	int tamanho;
	int *v;
	int i;
	int *p;
	
	scanf("%d", &tamanho);
	v = (int*)calloc(tamanho,sizeof(int));
	
	printf("\nCarregando o vetor: ");
	for(i=0; i<tamanho; i++){
		v[i] = ((i+1)*2);
		printf("%d ", v[i]);
	}
	
	p = v;
	printf("\nPonteiro p:\n");
	printf("Endereço:%u \tValor:%d\n",p, *p);
	p++;
	printf("Após p++\n");
	printf("Endereço:%u \tValor:%d\n",p, *p);
	p += 3;
	printf("Após p+=3\n");
	printf("Endereço:%u \tValor:%d\n",p, *p);
	p--;
	printf("Após p--\n");
	printf("Endereço:%u \tValor:%d\n",p, *p);
	
	free(v);
    return 0;
}
