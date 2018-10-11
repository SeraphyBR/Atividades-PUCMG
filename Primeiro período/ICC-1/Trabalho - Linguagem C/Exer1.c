
#include <stdio.h>

int main()
{//Inicio main 
    float alturasMulheres = 0, alturasHomens = 0, valor = 0;
    int cont = 1, genero = 0, homens = 0, mulheres = 0;
    float mediaMulheres = 0, mediaTurma = 0;
    float maiorAltura = 0, menorAltura = 3;

    printf("Digite a altura da %dª pessoa: ", cont);
    scanf("%f", &valor);
    while(valor > 0)
    {//Inicio while 
        printf("Digite o código de gênero da %dª pessoa: ",cont);
        scanf("%d", &genero);
        if(genero == 1)
        {//Inicio if 1
            alturasHomens += valor;
            homens++;
        }//Fim if 1    
        else if(genero == 2)
        {//Inicio else if  
            alturasMulheres += valor;
            mulheres++;
        }//Fim else if  
        if(valor > maiorAltura) maiorAltura = valor;
        if(valor < menorAltura) menorAltura = valor;
        cont++;
        printf("Digite a altura da %dª pessoa: ", cont);
        scanf("%f", &valor);
    }//Fim while
    if(cont > 0)
    {//Inicio if  
        mediaMulheres = alturasMulheres / mulheres;
        mediaTurma = (alturasHomens + alturasMulheres) / (homens + mulheres);
        printf("A maior altura da turma eh: %.3f metros.\n", maiorAltura);
        printf("A menor altura da turma eh: %.3f metros.\n", menorAltura);
        printf("A media da altura das mulheres eh: %.3f metros.\n", mediaMulheres);
        printf("A media da altura da turma eh: %.3f metros.\n", mediaTurma);
    }//Fim if  
    return(0);
}//Fim main 
