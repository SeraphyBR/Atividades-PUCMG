/*
    Autor: Luiz Junio <luisjuniorbr@gmail.com>
    Enunciado:
    A) Faca um metodo que receba um array de inteiros e um numero inteiro x 
    e retorne um valor booleano informando se o elemento x está contido no array.
    B) Repita o exercício acima considerando que os elementos do array estão ordenados de forma crescente. 
    Uma sugestão seria começar a pesquisa pelo meio do array

*/ 
public class Exer01_array
{//Inicio classe Exer01-array
    public static void main(String[] args)
    {//Inicio main 
        int[] arranjo = {1,2,3,4,5};
        if (noArranjoB(3, arranjo)) MyIO.println("Está no arranjo!");
        else MyIO.println("Não está no arranjo!");

    }//Fim main 

    public static boolean noArranjoA(int x, int[] num)
    {//Inicio noArranjoA
        boolean encontrei = false;
        int cont = 0;
        while(!encontrei && cont < num.length){
            if(x == num[cont]) encontrei = true;
            cont++;
        }
        return encontrei;  
    }//Fim noArranjoA

    public static boolean noArranjoB(int x, int[] num)
    {//Inicio noArranjoB
        boolean encontrei = false;
        int inicio = 0;
        int meio;
        int fim = num.length - 1;

        while(inicio <= fim && !encontrei){
            meio = (inicio + fim) / 2;
            if(x == num[meio]) encontrei = true;
            else if (x > num[meio]) inicio = meio + 1;
            else if (x < num[meio]) fim = meio - 1;
        }
        return encontrei;
    }//Inicio noArranjoB

}//Fim classe Exer01-array
