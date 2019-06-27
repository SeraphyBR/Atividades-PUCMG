#include <stdio.h>

int main()
{//Inicio main 
    int dias = 0, menorSaldo, saldo = 0;
    int valorLido = 0;
    do{
        scanf("%d", &dias);
    }while(dias < 1 || dias > 30);

    scanf("%d", &saldo);
    
    menorSaldo = saldo;

    for(int cont = 0; cont < dias; cont++)
    {//Inicio for
        scanf("%d", &valorLido);
        saldo+= valorLido;
        if(saldo < menorSaldo) menorSaldo = saldo;
    }//Fim for
    printf("%d", menorSaldo);

    return(0);
}//Fim main 