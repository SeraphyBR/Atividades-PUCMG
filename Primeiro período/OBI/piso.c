
#include <stdio.h>

int main()
{//Inicio main 
    int L = 0, C = 0;
    int tipo1 = 0, tipo2 = 0;	

    do{
        scanf("%d", &L);
    }while(L < 1 || L > 100);

    do{
        scanf("%d", &C);
    }while(C < 1 || C > 100);

    tipo2 = 2*(L - 1) + 2*(C - 1);
    tipo1 = C*L + (C - 1)*(L - 1);

    printf("%d\n",tipo1);
    printf("%d\n",tipo2);

    return(0);
}//Fim main 
