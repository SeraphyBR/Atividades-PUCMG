//Construa um método recursivo que gere a soma dos valores presentes em um vetor de reais. Teste-o a partir do método principal.

public class Exer4
{//Inicio classe
    public static void main(String[]args)
    {//Inicio main 
        double[] vetor = {1.0,2.0,3.0};
        System.out.println("A soma eh: " + somaVetor(vetor, 0));
    }//Fim main 

    public static double somaVetor(double[] vetor, int coluna)
    {//Inicio somaVetor
        double soma;
        if(coluna > (vetor.length - 1)) soma = 0;
        else soma = vetor[coluna] + somaVetor(vetor, coluna + 1);
        return soma;
    }//Fim somaVetor

}//Fim classe