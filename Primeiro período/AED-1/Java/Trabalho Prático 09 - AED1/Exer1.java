/*
Questão 01:
Construa um método que receba duas matrizes de reais e copie a primeira matriz na segunda.
Obs: Verifique algum cenário que impeça a execução da funcionalidade.
*/


public class Exer1
{//Inicio classe
   public static void main(String[]args)
    {//Inicio main
     /***************************************************************
      * Nome do método: main
      * Data da elaboração: 01/05/2018
      * Data da última alteração: 01/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Principal - teste
      * Argumentos: nulo
      * Valor gerado: nulo
      ****************************************************************
      */

        System.out.println("Teste 1:");
        double[][] matrix = {{1.3,2.1,3.4},{4.2,5.7,6.9},{7.0,8.2,9.1}};
        double[][] outro = {{1.0,2.2,3.1},{4.0,5.0,23.0},{7.0,8.1,9.5}};
        escreveMatriz(matrix);
        System.out.println();
        escreveMatriz(outro);
        copiaMatriz(matrix, outro);
        System.out.println("Resultado:");
        escreveMatriz(matrix);
        System.out.println();
        escreveMatriz(outro);
        System.out.println("\nTeste 2:");
        double[][] matrix2 = {{1.3,2.1,3.4},{4.2,5.7,6.9},{7.0,8.2,9.1}};
        double[][] outro2 = {{1.0,3.1},{4.0,5.0,23.0},{7.0,9.5}};
        escreveMatriz(matrix2);
        System.out.println();
        escreveMatriz(outro2);
        copiaMatriz(matrix2, outro2);
        System.out.println("Resultado:");
        escreveMatriz(matrix2);
        System.out.println();
        escreveMatriz(outro2);
    }//Fim main


   public static void copiaMatriz(double[][] matriz1, double[][] matriz2)
   {   
     /***************************************************************
      * Nome do método: copiaMatriz
      * Data da elaboração: 01/05/2018
      * Data da última alteração: 01/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Copiar os valores de uma matriz real em outra.
      * Argumentos: a primeira matriz de base e a outra que ficará igual.
      * Valor gerado: nulo
      ****************************************************************
      */    
        if(matrizesTamIguais(matriz1, matriz2))
        {//Inicio if matrizesTamIguais
            int coluna, linha;
            int linhas = matriz2.length;
            int colunas = matriz2[0].length;
      
            for(linha = 0; linha < linhas; linha++)
            {//Inicio for linha
               for(coluna = 0; coluna < colunas; coluna++)
               {//Inicio for coluna
                  matriz2[linha][coluna] = matriz1[linha][coluna];
               }//Fim for coluna
            }//Fim for linha
            System.out.println("Copia finalizada!");
        }//Fim if matrizesTamIguais
        else System.out.println("Erro! As matrizes possuem dimensões diferentes.");        
   }//Fim copiaMatriz


    public static boolean matrizesTamIguais(double[][] matriz1, double[][] matriz2)
    {//Inicio matrizesTamIguais

     /***************************************************************
      * Nome do método: matrizesTamIguais
      * Data da elaboração: 01/05/2018
      * Data da última alteração: 05/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Verificar se as dimensoes de duas matrizes são as mesmas.
      * Argumentos: As duas matrizes a serem comparadas.
      * Valor gerado: verdadeiro se o numero de linhas e colunas forem iguais nas duas matrizes.
      ****************************************************************
      */

        int tam_linhas1, tam_linhas2, tam_colunas1 = 0, tam_colunas2 = 0;
        boolean resultado = false;

        tam_linhas1 = matriz1.length;
        tam_linhas2 = matriz2.length;
    
        if(ehTamColunasIguais(matriz1))
        {//Inicio if matriz1 
            tam_colunas1 = matriz1[0].length;
            if(ehTamColunasIguais(matriz2)) tam_colunas2 = matriz2[0].length;
        }//Fim if matriz1
        

        if ((tam_colunas1 == tam_colunas2) && (tam_linhas1 == tam_linhas2)){
            if (tam_colunas1 != 0) resultado = true;
        }
        return resultado;
    }//Fim matrizesTamIguais

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