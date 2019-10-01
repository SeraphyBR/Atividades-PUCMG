/*
Questão 02:
Construa  um  método  que  recebe  duas  matrizes  de  reais  e 
retorne  verdadeiro,  se  forem exatamente iguais, e falso, caso contrário.
*/

public class Exer2 
{//Inicio classe
    public static void main(String[]args)
    {
        double[][] matrix = {{1.3,2.1,3.4},{4.2,5.7,6.9},{7.0,8.2,9.1}};
        double[][] outro = {{1.3,2.1,3.4},{4.2,5.7,6.9},{7.0,8.2,9.1}};
        if(matrizesIguais(matrix,outro)) System.out.println("São Iguais.");
        else System.out.println("São diferentes.");
    }


    public static boolean matrizesIguais(double[][] matriz1, double[][] matriz2)
    {//Inicio matrizesIguais
     /***************************************************************
      * Nome do método: matrizesIguais
      * Data da elaboração: 01/05/2018
      * Data da última alteração: 01/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Verifica se o conteudo de duas matrizes são iguais.
      * Argumentos: As duas matrizes a serem comparadas
      * Valor gerado: verdadeiro se forem iguais, falso caso contrário.
      ****************************************************************
      */
        int coluna, linha = 0;
        boolean ehIgual = true;
        if(matrizesTamIguais(matriz1,matriz2))
        {//Inicio if
            while(linha < matriz1.length && ehIgual)
            {//Inicio while linha;
                coluna = 0;
                while(coluna < matriz1[linha].length && ehIgual)
                {//Inicio while coluna 
                    if(matriz1[linha][coluna] != matriz2[linha][coluna])
                    {
                        ehIgual = false;
                    }
                    coluna++;
                }//Fim while coluna 
                linha++;
            }//Fim while linha 
        }//Fim if
        else ehIgual = false;
        return ehIgual;
    }//Fim matrizesIguais

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
}//Fim classe
