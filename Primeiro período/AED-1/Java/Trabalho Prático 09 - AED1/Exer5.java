/*
Questão 05:
Construa um método que calcule e retorne o número de ocorrências em uma matriz 
de reais maior que o seu valor médio. A média deverá ser calculada em um método específico para essa funcionalidade
*/

public class Exer5 
{//Inicio classe
    public static void main(String[]args)
    {//Inicio main
        double[][] matriz = {{1.3,2.1,3.4},{3.4,5.7,6.9},{7.0,8.2,9.1}};
        double valorMedio = mediaMatriz(matriz);
        int valoresAcima = acimaDoValorMatriz(matriz, valorMedio);
        System.out.printf("O valor médio eh %.2f, e há %d valores acima da média.\n",valorMedio, valoresAcima);
    }//Fim main 

    public static double mediaMatriz(double[][] matriz)
    {//Inicio mediaMatriz
     /***************************************************************
      * Nome do método: mediaMatriz
      * Data da elaboração: 01/05/2018
      * Data da última alteração: 01/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Calcular a media dos valores da matriz.
      * Argumentos: A matriz.
      * Valor gerado: A media dos valores
      ****************************************************************
      */
        int linha, coluna, conta = 0, soma = 0;
        double media;
        for(linha = 0; linha < matriz.length; linha++)
        {//Inicio for linha
            for(coluna = 0; coluna < matriz[linha].length ; coluna++)
            {//Inicio for coluna
                soma += matriz[linha][coluna];
                conta++;
            }//Fim for coluna
        }//Fim for linha
        media = (double)soma / (double)conta;
        return media;
    }//Fim mediaMatriz

    public static int acimaDoValorMatriz(double[][] matriz, double valor)
    {//Inicio acimaDoValorMatriz
     /***************************************************************
      * Nome do método: acimaDoValorMatriz
      * Data da elaboração: 01/05/2018
      * Data da última alteração: 01/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Saber quantos números são maiores que um valor.
      * Argumentos: a matriz e o valor a ser comparado
      * Valor gerado: O número de valores maiores que o argumento.
      ****************************************************************
      */

        int linha, coluna, ocorrencias = 0;
        for(linha = 0; linha < matriz.length; linha++)
        {//Inicio for linha
            for(coluna = 0; coluna < matriz[linha].length; coluna++)
            {//Inicio for coluna
                if (matriz[linha][coluna] > valor) ocorrencias++;
            }//Fim for coluna
        }//Fim for linha
        return ocorrencias;
    }//Fim acimaDoValorMatriz



}//Fim classe