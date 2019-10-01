/*
Construa um método que calcule e retorne a soma dos valores de uma determinada coluna da matriz. 
Argumentos do método: uma matriz de reais e um valor inteiro relativo à coluna a ser somada.
Valor de retorno: um valor real relativo à soma de uma coluna da matriz.
*/
public class Exer9
{//Inicio classe
    public static void main(String[]args)
    {//Inicio main
        System.out.println("Matriz:");
        double[][] matriz = {{1.0,2.0,3.0},{4.0,5.0,6.0},{7.0,8.0,9.0}};
        escreveMatriz(matriz);
        System.out.println("A soma dos números da coluna 2 eh: " + somaColuna(matriz,1));

    }//Fim main

    public static double somaColuna(double[][] matriz, int coluna)
    {//Inicio somaColuna
     /***************************************************************
      * Nome do método: somaColuna
      * Data da elaboração: 05/05/2018
      * Data da última alteração: 05/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Calcular a soma dos valores de determinada coluna da matriz.
      * Argumentos: a matriz e o número da coluna a ser somada, sendo 0 a primeira coluna.
      * Valor gerado: A soma dos valores da coluna, caso o valor da coluna não seja coerente com a matriz ou
                      a matriz não tiver o mesmo número de colunas em cada linha, irá retornar "menos zero".
      ****************************************************************
      */
        double soma = 0.0;
        int colunas = matriz[0].length - 1;
        if(coluna <= colunas && coluna >= 0 && ehTamColunasIguais(matriz))
        {
            for (int linha = 0; linha < matriz.length; linha++){
                soma += matriz[linha][coluna];
            }
        }
        else soma = -0.0;    
        return soma;

    }//Fim somaColuna

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


