/*
Questão 06:
Construa um método que retorne verdadeiro se a primeira linha de 
uma  matriz de reais for igual à sua diagonal principal, e falso, caso contrário.
Argumento: Uma matriz de reais.
Obs: Verifique algum cenário que impeça a execução da funcionalidade
*/

public class Exer6
{//Inicio classe
    public static void main(String[]args)
    {//Inicio main 
      /***************************************************************
      * Nome do método: main
      * Data da elaboração: 01/05/2018
      * Data da última alteração: 05/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Teste dos demais métodos.
      * Argumentos: nulo
      * Valor gerado: nulo
      ****************************************************************
      */

        double[][] matriz = {{1.3,2.1,3.4},{3.4,2.1,6.9},{7.0,8.2,3.4}};
        System.out.println("Matriz: ");
        escreveMatriz(matriz);
        if(diagonalPrinIgualLinha1(matriz)) System.out.println("A primeira linha eh igual a diagonal principal!");
        else System.out.println("A primeira linha não eh igual a diagonal principal!");
    }//Fim main 

    public static boolean diagonalPrinIgualLinha1(double[][] matriz)
    {//Inicio diagonalPrinIgualLinha1
     /***************************************************************
      * Nome do método: diagonalPrinIgualLinha1
      * Data da elaboração: 01/05/2018
      * Data da última alteração: 01/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Saber se a primeira linha da matriz eh igual a sua diagonal principal.
      * Argumentos: a matriz
      * Valor gerado: Verdadeiro se for igual a diagonal principal, falso caso não seja igual ou não seja
                      uma matriz quadrada.
      ****************************************************************
      */

        int linha = 0, coluna;
        boolean resultado = true;
        if(ehMatrizQuadrada(matriz))
        {
            for(coluna = 0; coluna < matriz[0].length ; coluna++)
            {//Inicio for 
                if (matriz[0][coluna] != matriz[linha][coluna] )
                {
                    resultado = false;
                    break;
                }
                linha++; 
            }//Fim for 
        }
        else
        {
            System.out.println("Erro! Não eh uma matriz quadrada.");
            resultado = false;
        } 
        return resultado;
    }//Fim diagonalPrinIgualLinha1

    public static boolean ehMatrizQuadrada(double[][] matriz)
    {//Inicio ehMatrizQuadrada 
     /***************************************************************
      * Nome do método: ehMatrizQuadrada
      * Data da elaboração: 01/05/2018
      * Data da última alteração: 01/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Saber se aa matriz possue numero de linhas e colunas iguais.
      * Argumentos: a matriz
      * Valor gerado: Verdadeiro se for quadrado, falso caso contrário.
      ****************************************************************
      */

        int tam_linhas, tam_colunas = 0, i = 0;
        boolean tam_colunas_iguais, resultado = false;

        tam_linhas = matriz.length;
        tam_colunas_iguais = true;
        
        while(i < tam_linhas && tam_colunas_iguais)
        {//inicio while 
            if (matriz[0].length != matriz[i].length){
                tam_colunas_iguais = false;
            }
            i++;
        }//Fim while

        if (tam_colunas_iguais) tam_colunas = matriz[0].length;
        if(tam_colunas == tam_linhas) resultado = true;
        
        return resultado;
    }//Fim ehMatrizQuadrada

    
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