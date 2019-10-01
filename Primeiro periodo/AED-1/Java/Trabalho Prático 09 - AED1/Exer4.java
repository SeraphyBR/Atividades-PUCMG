/*
Questão 04:
Construa um método que receba uma matriz de reais e calcule e retorne o número da
primeira linha da matriz em que está localizado o maior valor nela presente. 
*/
public class Exer4
{//Inicio classe
    public static void main(String[]args)
    {//Inicio main
        double[][] matriz = {{1.3,3.45,3.4},{4.2,5.7,6.9},{7.0,8.2,9.1}};
        System.out.println("Matriz: ");
        escreveMatriz(matriz);
        int maiorDaLinha1 = colunaDoMaiorNaLinha1(matriz);
        System.out.printf("O maior número na primeira linha eh %.3f , na coluna %d.\n",matriz[0][maiorDaLinha1],maiorDaLinha1 + 1);
    }//Fim main

    public static int colunaDoMaiorNaLinha1(double[][] matriz)
    {//Inicio colunaDoMaiorNaLinha1

     /***************************************************************
      * Nome do método: colunaDoMaiorNaLinha1
      * Data da elaboração: 01/05/2018
      * Data da última alteração: 01/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Saber a coluna do maior numero da primeira linha da matriz.
      * Argumentos: a matriz
      * Valor gerado: a coluna do maior da primeira linha.
      ****************************************************************
      */

        int coluna;
        int maior = 0;
        for(coluna = 1; coluna < matriz[0].length; coluna++)
        {//Inicio for 
            if(matriz[0][coluna] > matriz[0][coluna - 1]) maior = coluna;        
        }//Fim for 
        return maior;
    }//Fim colunaDoMaiorNaLinha1

    public static void escreveMatriz(double[][] matriz)
    {//Inicio escreveMatriz
     /***************************************************************
      * Nome do método: escreveMatriz
      * Data da elaboração: 25/04/2018
      * Data da última alteração: 01/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Escrever uma matriz na tela.
      * Argumentos: A matriz a ser exibida.
      * Valor gerado: nulo
      ****************************************************************
      */
        int coluna, linha;
      
        for(linha = 0; linha < matriz.length; linha++)
        {//Inicio for linha
            for(coluna = 0; coluna < matriz[linha].length ; coluna++)
            {//Inicio for coluna
                    System.out.print(matriz[linha][coluna] + ", " );
            }//Fim for coluna
        System.out.println();
        }//Fim for linha
    }//Fim escreveMatriz


}//Fim classe