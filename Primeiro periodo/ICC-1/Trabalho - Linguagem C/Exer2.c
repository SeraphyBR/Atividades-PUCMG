#include <stdio.h>

int main()
{//Inicio main 
    int valorLido = 0, menor = 100000, segundoMenor = 10000;

    printf("Digite um número positivo: ");
    scanf("%d", &valorLido);
    while(valorLido >= 0)
    {//Inicio while 
        if(valorLido < menor){
            segundoMenor = menor;
            menor = valorLido;
        }//Fim if      
        else if(valorLido > menor && valorLido < segundoMenor) segundoMenor = valorLido;
        printf("Digite um número positivo: ");
        scanf("%d", &valorLido);
    }//Fim while
    printf("O menor número digitado eh: %d\n", menor);
    printf("O segundo menor número digitado eh: %d\n", segundoMenor);

    return(0);

}//Fim main 
