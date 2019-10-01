/*
Construa um método que verifique se um valor real está presente ou não em uma matriz.
Argumentos do método: uma matriz de reais e um valor real chave da pesquisa.
Valor de retorno: verdadeiro, se a chave estiver presente na matriz, ou falso, caso contrário.
*/
public class Exer10
{//Inicio classe
    public static void main(String[]args)
    {
        double valor = 5.001;
        double[][] matriz = {{1.0,2.0,3.0},{4.0,5.001,6.0},{7.0,8.0,9.0}};
        System.out.println("Matriz:");
        escreveMatriz(matriz);
        if(encontreiNaMatriz(matriz,valor)) System.out.printf("Tem um %.3f na matriz\n",valor);
        else System.out.printf("Não tem um %.3f na matriz\n",valor);

    }


    public static boolean encontreiNaMatriz(double[][] matriz, double chave)
    {//Inicio buscaNaMatriz
     /***************************************************************
      * Nome do método: buscaNaMatriz
      * Data da elaboração: 06/05/2018
      * Data da última alteração: 06/05/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Verificar se um valor real está presente ou não em uma matriz.
      * Argumentos: Matriz de reais e valor real a ser encontrado.
      * Valor gerado: Verdadeiro se encontrar o valor na matriz, falso caso contrário.
      ****************************************************************
      */
        int linha = 0, coluna;
        boolean encontrei = false;
        while(linha < matriz.length && !encontrei)
        {//Inicio while linha
            coluna = 0;
            while(coluna < matriz[linha].length && !encontrei)
            {//Inicio while coluna
                if (matriz[linha][coluna] == chave) encontrei = true; 
                coluna++;
            }//Fim while coluna
            linha++;
        }//Fim while linha
        
        return encontrei;
    }//Fim buscaNaMatriz

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









