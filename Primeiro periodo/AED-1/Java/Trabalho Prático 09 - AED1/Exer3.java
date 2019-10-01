/*
Questão 03: 
Construa  um  método  que  receba  uma  matriz  de  reais  e  um  valor  real  qualquer, 
chave  de  pesquisa.  O método deverá retornar o número de ocorrências da chave na matriz.
*/
public class Exer3 
{//Inicio classe
    public static void main(String[]args)
    {//Inicio main
        double[][] matrix = {{1.3,2.1,3.4},{3.4,5.7,6.9},{7.0,8.2,9.1}};
        int ocorrencias = buscaNaMatriz(3.4,matrix);
        System.out.printf("O numero de 3.4 na matriz eh: %d\n",ocorrencias);
        
    }//Fim main

    public static int buscaNaMatriz(double chave, double[][]matriz)
    {//Inicio buscaNaMatriz
     /***************************************************************
      * Nome do método: buscaNaMatriz
      * Data da elaboração: 01/05/2018
      * Data da última alteração: 01/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: O numero de veses que um valor chave aparece na matriz.
      * Argumentos: Valor de busca e matriz.
      * Valor gerado: Número de ocorrências.
      ****************************************************************
      */
        int linha, coluna, ocorrencias = 0;
        for(linha = 0; linha < matriz.length; linha++)
        {//Inicio for linha
            for(coluna = 0; coluna < matriz[linha].length ; coluna++)
            {//Inicio for coluna
                if (matriz[linha][coluna] == chave) ocorrencias++;
            }//Fim for coluna
        }//Fim for linha
        return ocorrencias;
    }//Fim buscaNaMatriz

}//Fim classe