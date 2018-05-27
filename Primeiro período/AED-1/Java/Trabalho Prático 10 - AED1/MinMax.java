/*
Na Teoria dos Sistemas, define-se o elemento MINMAX de uma matriz como sendo o maior elemento 
da linha onde se encontra o menor elemento da matriz. Construa um método que receba uma matriz de 
reais e calcule e retorne seu MINMAX. 
A tarefa deste método deverá ser distribuída em outros métodos.
Construa o método main( ) 
que permita testar sua solução
*/

public class MinMax
{//Inicio classe
    public static void main(String[]args)
    {//Inicio main 
     /***************************************************************
      * Nome do método: main 
      * Data da elaboração: 07/05/2018
      * Data da última alteração: 07/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Principal.
      * Argumentos: Nulo.
      * Valor gerado: Nulo.
      ****************************************************************
      */
        double[][] matriz = {{1.0,2.0,3.0},{4.0,5.0,6.0},{7.0,8.0,9.0}};
        System.out.println("O MINMAX da matriz eh: " + minMax(matriz));
    }//Fim main 

    public static double minMax(double[][] matriz)
    {//Inicio minMax
     /***************************************************************
      * Nome do método: minMax
      * Data da elaboração: 07/05/2018
      * Data da última alteração: 07/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Descobrir o MINMAX de uma matriz.
      * Argumentos: a matriz contendo os valores.
      * Valor gerado: O maior número presente na linha do menor valor.
      ****************************************************************
      */
        return maiorDaLinha(matriz, localizaMenorMatriz(matriz));
    }//Fim minMax

    public static double maiorDaLinha(double[][] matriz, int linha)
    {//Inicio maiorDaLinha
     /***************************************************************
      * Nome do método: maiorDaLinha
      * Data da elaboração: 07/05/2018
      * Data da última alteração: 07/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Saber o maior valor de uma linha da matriz. 
      * Argumentos: a matriz contendo os valores e um valor inteiro correspondente a linha.
      * Valor gerado: O maior valor da linha.
      ****************************************************************
      */
        double maior = matriz[linha][0];
        for(int coluna = 0; coluna < matriz[linha].length; coluna++){
            if(matriz[linha][coluna] > maior) maior = matriz[linha][coluna];
        }
        return maior;

    }//Fim maiorDaLinha       

    public static int localizaMenorMatriz(double[][] matriz)
    {//Inicio localizaMenorMatriz
     /***************************************************************
      * Nome do método: localizaMenorMatriz
      * Data da elaboração: 07/05/2018
      * Data da última alteração: 07/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Saber em qual linha está o menor valor da matriz.
      * Argumentos: a matriz contendo os valores.
      * Valor gerado: A número da linha do menor valor.
      ****************************************************************
      */
        int linha, coluna;
        int linhaDoMenor = 0;
        double menor = matriz[0][0];
        for(linha = 0; linha < matriz.length; linha++)
        {//Inicio for linha
            for(coluna = 0; coluna < matriz[linha].length; coluna++)
            {//Inicio for coluna
                if (matriz[linha][coluna] < menor){
                    menor = matriz[linha][coluna];
                    linhaDoMenor = linha;
                } 
            }//Fim for coluna
        }//Fim for linha
        return linhaDoMenor;
    }//Fim localizaMenorMatriz

}//Fim classe