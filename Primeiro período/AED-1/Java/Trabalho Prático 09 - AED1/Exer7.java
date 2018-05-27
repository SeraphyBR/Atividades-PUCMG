/*
Questão 07:
Construa um método que calcule e retorne o maior valor acima da diagonal principal
de uma matriz de reais (não considerar a própria diagonal).
Obs: Verifique algum cenário que impeça a execução da funcionalidade.
*/
public class Exer7
{//Inicio classe
    public static void main(String[]args)
    {//Inicio main
        
        System.out.println("Matriz 1:");
        double[][] matriz = {{1.0,2.0,3.0},{4.0,5.0},{7.0,8.0,9.0}};
        escreveMatriz(matriz);
        System.out.println("Maior valor acima da diagonal principal: " + maiorValorAcimDiagonalPrinc(matriz));
        System.out.println("Matriz 2:");
        double[][] matriz2 = {{1.0,2.0,3.0},{4.0,5.0,6.0},{7.0,8.0,9.0}};
        escreveMatriz(matriz2);
        System.out.println("Maior valor acima da diagonal principal: " + maiorValorAcimDiagonalPrinc(matriz2));

    }//Fim main 

    public static double maiorValorAcimDiagonalPrinc(double[][] matriz)
    {//Inicio maiorValorAcimDiagonalPrinc
     /***************************************************************
      * Nome do método: maiorValorAcimDiagonalPrinc
      * Data da elaboração: 01/05/2018
      * Data da última alteração: 01/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Calcula o maior valor presente acima da diagonal principal da matriz.
      * Argumentos: a matriz
      * Valor gerado: O maior valor acima da diagonal principal.
      ****************************************************************
      */

        int linha = 0, coluna;
        int colunas = matriz[0].length;
        int linhas = matriz.length;
        double maior = matriz[0][1];
        if(ehMatrizQuadrada(matriz))
        {
            for(linha = 0; linha < linhas; linha++)
            {//Inicio for linha
               for(coluna = linha + 1; coluna < colunas; coluna++)
               {//Inicio for coluna
                  if (matriz[linha][coluna] > maior) maior = matriz[linha][coluna];
               }//Fim for coluna
            }//Fim for linha
        }
        else
        {
            System.out.println("Erro! Não eh uma matriz quadrada.");
            maior = -0.0;
        } 
        return maior;
    }//Fim maiorValorAcimDiagonalPrinc

    public static boolean ehMatrizQuadrada(double[][] matriz)
    {//Inicio ehMatrizQuadrada 
     /***************************************************************
      * Nome do método: ehMatrizQuadrada
      * Data da elaboração: 01/05/2018
      * Data da última alteração: 05/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Saber se aa matriz possue numero de linhas e colunas iguais.
      * Argumentos: a matriz
      * Valor gerado: Verdadeiro se for quadrado, falso caso contrário.
      ****************************************************************
      */

        int tam_colunas = 0;
        int tam_linhas = matriz.length;
        boolean resultado = false;
        
        if (ehTamColunasIguais(matriz))
        {//Inicio if
            tam_colunas = matriz[0].length;
            if(tam_colunas == tam_linhas) resultado = true;
        }//Fim if
        return resultado;
    }//Fim ehMatrizQuadrada

    public static boolean ehTamColunasIguais(double[][] matriz)
    {//Inicio ehTamColunasIguais
        
     /***************************************************************
      * Nome do método: ehTamColunasIguais
      * Data da elaboração: 05/05/2018
      * Data da última alteração: 05/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Verificar se o número de colunas é o mesmo em cada linha da matriz.
      * Argumentos: A matriz.
      * Valor gerado: verdadeiro se o numero de colunas de cada linha for igual.
      ****************************************************************
      */

        int i = 0; 
        int tam_linhas = matriz.length;
        boolean tam_colunas_iguais = true;
        while(i < tam_linhas && tam_colunas_iguais)
        {//Inicio while 
            if(matriz[0].length != matriz[i].length){
                 tam_colunas_iguais = false;
            }
            i++;
        }//Fim while
        return tam_colunas_iguais;
    }//Fim ehTamColunasIguais


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