/*
 *  Autor: Luiz Junio <luisjuniorbr@gmail.com>
 *  Enunciado:
 *   Is - Crie um metodo iterativo que recebe uma string e retorna true se a mesma e composta
 *   somente por vogais. Crie outro metodo iterativo que recebe uma string e retorna true se a
 *   mesma e composta somente por consoantes. Crie um terceiro metodo iterativo que recebe uma
 *   string e retorna true se a mesma corresponde a um numero inteiro. Crie um quarto metodo
 *   iterativo que recebe uma string e retorna true se a mesma corresponde a um numero real. Na
 *   saida padrao, para cada linha de entrada, escreva outra de saida da seguinte forma X1 X2 X3
 *   X4 onde cada Xi e um booleano indicando se a entrada e: composta somente por vogais (X1);
 *   composta somente somente por consoantes (X2); um numero inteiro (X3); um numero real (X4).
 *   Se Xi for verdadeiro, seu valor sera SIM, caso contrario, NAO.
*/

public class Is
{//Inicio classe Is
    public static void main(String[] args)
    {//Inicio main 
        String[] palavra = new String[1000];
        int numEntrada = 0;

        do{//Leitura da entrada padrao
            palavra[numEntrada] = MyIO.readLine();
        }while (!ehIgual(palavra[numEntrada++],"FIM"));

        numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
    }//Fim main

    public static boolean ehApenasVogais(String palavra)
    {//Inicio ehApenasVogais
        int tam = palavra.length();
        while()


    }//Fim ehApenasVogais

    public static boolean ehApenasConsoantes(String palavra)
    {//Inicio ehApenasConsoantes


    }//Fim ehApenasConsoantes

    public static boolean ehNumInteiro(String palavra)
    {//Inicio ehNumInteiro


    }//Fim ehNumInteiro

    public static boolean ehNumReal(String palavra)
    {//Inicio ehNumReal


    }//Fim ehNumReal

    public static char paraMaiusculo(char letra)
    {//Inicio paraMaisculo
        char modificado = '0'
        if(letra <= 'z' && letra >= 'a') modificado = letra - 40;
        else modificado = letra;
        return modificado;
    }//Fim paraMaiusculo

    public static boolean ehIgual(String p1, String p2)
    {//Inicio ehIgual
     /***************************************************************
      * Nome do método: ehIgual
      * Data da elaboração: 08/08/2018
      * Data da última alteração: 08/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Verifica se uma String é igual a outra.
      * Valor gerado: verdadeiro se forem iguais, falso caso contrário.
      ****************************************************************
      */ 
        boolean igual = true;
        int i = 0;
        if(p1.length() != p2.length()) igual = false;
        else while(i < p1.length() && igual){
                if(p1.charAt(i) != p2.charAt(i))//Comparacao caractere por caractere
                    igual = false;
                i++;
        }//Fim while
        return igual;
    }//Fim ehIgual


}//Fim classe Is
