#include<stdio.h>
#include <stdlib.h>

int main(){
	int alocar;
	int* p;
	int* pData;

	p = NULL;		  
	pData = NULL;	  
	printf("\nEndereço de p:%u \tpData:%u\n", p,pData);
	scanf("%d", &alocar);	  				// digitou 0 -> não aloca, 1 -> aloca

	if (alocar) {
        p = malloc(sizeof(int));          // aloca memória para um int e faz p apontar para lá
        printf("\nEndereço de p:%u \tpData:%u\n", p,pData);
       *p = 989;		           		  // atribui o valor 989 para o local apontado por p
        pData = p;						  // atribui o endereço de p a pData
        printf("\nEndereço de p:%u \tpData:%u\n", p,pData);
      }

	if (p != NULL) {
		printf("\nValor apontado por p: %d", *p);
		printf("\nValor apontado por pData: %d", *pData);
    }
    else
			printf("\nAlocação não realizada");
	free(p);							//libera a memória do ponteiro. Importante!!!

	return 0;

}
