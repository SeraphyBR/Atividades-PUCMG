#include <stdio.h>
#include <math.h>
#include <time.h>
#include <stdlib.h>

#define n 1000000
#define bool short
#define true 1
#define false 0

//Variaveis globais
int array[n+1];
int i;
int j;

int leArraySystemIn()
{
	for(int indice=0;indice<n;indice++)
	{
		scanf("%d%*c", &array[indice]);
	}//fim for
	return 0;
}//fim de leArraySystemIn

//Retorna o maior elemento do arranjo.
int getMaior()
{
	int maior = array[0];
	for (i = 0; i < n; i++)
	{
    	if(maior < array[i])
		{
        	maior = array[i];
      	}
   	}
   	return maior;
}//fim getMaior


// Algoritmo de ordenacao
int countingSort()
{

   	//Array para contar o numero de ocorrencias de cada elemento
   	int tamCount = getMaior() + 1;
   	int* count = (int*) malloc(tamCount * sizeof(int));
   	int ordenado[n];

   	//Inicializar cada posicao do array de contagem
   	for(i=0;i<tamCount;i++)
	{
	   	count[i]=0;
	}//fim for
	
   	//Agora, o count[i] contem o numero de elemento iguais a i
   	for(int i=0;i<n;i++)
	{
		int tmp=count[array[i]];
		count[array[i]]=tmp+1;
	}//fim for

   	//Agora, o count[i] contem o numero de elemento menores ou iguais a i
   	for(i=1;i<tamCount;i++)
	{
		count[i]+=count[i-1];
	}//fim for

   	//Ordenando
   	for(i=n-1;i>=0;i--)
	{
		ordenado[count[array[i]]-1]=array[i];
		count[array[i]]--;
	}//fim for

   	//Copiando para o array original
   	for(i=0;i<n;i++)
	{
		array[i]=ordenado[i];
	}//fim for
	
	return 0;
}//fim countingSort

int imprimeArranjo()
{
	for(int indice=0;indice<n;indice++)
	{
		printf("%d\n", array[indice]);
	}//fim for
	return 0;
}//fim imprimeArranjo

bool isOrdenado()
{
	bool resposta=true;
	for(int i=1;i<n;i++)
	{
		if(array[i]<array[i-1])
		{
			i=n;
			resposta=false;
		}//fim if
	}//fim for
	return resposta;
}//fim isOrdenado

int main()
{
	//Lendo o arranjo
	printf("\nIniciando o programa\n");//teste
	leArraySystemIn();
	printf("\nArray lido com sucesso\n");//Teste
	countingSort();
	printf("\nArray ordenado com sucesso\n");//Teste
	imprimeArranjo();
	printf("\nArray impresso com sucesso\n");//Teste
	bool estaOrdenado=isOrdenado();
	printf("\nVerificacao realizada com sucesso\n");//Teste
	if(estaOrdenado)printf("\nO array esta ordenado.\n");
	else printf("\nO array nao esta ordenado.\n");
	printf("\nFim do programa\n");
	return 0;
}//fim main
