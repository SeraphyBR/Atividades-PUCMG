/*
 * Autor: Luiz Junio <luisjuniorbr@gmail.com>
 * Criado em: 23/08/2018
 * Enunciado:
 * Palindromo - Crie um metodo *recursivo que recebe uma string como parametro e retorna true
 * se essa e um palindromo. Na saida padrao, para cada linha de entrada, escreva uma linha de
 * saida com SIM / NAO indicando se a linha e um palindromo.
 */

public class PalindromoRecursivo
{//Inicio classe PalindromoRecursivo
    public static void main(String[] args)
    {//Inicio main
        String[] palavra = new String[1000];
        int numEntrada = 0;

        do{//Leitura da entrada padrao  
            palavra[numEntrada] = MyIO.readLine();
        }while (!ehIgual(palavra[numEntrada++],"FIM"));

        numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

        //Impressao da saida
        for(int i = 0; i < numEntrada; i++)
        {//Inicio for
            if(ehPalindromo(palavra[i])){
                MyIO.println("SIM");
            }
            else MyIO.println("NAO");
        }//Fim for    

    }//Fim main

    public static boolean ehPalindromo(String palavra)
    {//Inicio ehPalindromo
        return ehPalindromo(palavra, 0);
    }//Fim ehPalindromo

    private static boolean ehPalindromo(String palavra, int i)
    {//Inicio ehPalindromo
        boolean palindromo = true;
        int ultimo = palavra.length() - 1;
        if(i < palavra.length() / 2 ){
            if(palavra.charAt(i) == palavra.charAt(ultimo - i))
                palindromo = true && ehPalindromo(palavra, i + 1);
            else
                palindromo = false;
        }
        return palindromo;
    }//Fim ehPalindromo

    public static boolean ehIgual(String p1, String p2)
    {//Inicio ehIgual
        boolean resp = true;
        if(p1.length() != p2.length())
            resp = false;
        else
            resp = ehIgual(p1,p2,0);
        return resp;
    }//Fim ehIgual

    private static boolean ehIgual(String p1, String p2, int i)
    {//Inicio ehIgual
     /***************************************************************
      * Nome do método: ehIgual
      * Data da elaboração: 23/08/2018
      * Data da última alteração: 23/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Verifica se uma String é igual a outra.
      * Valor gerado: verdadeiro se forem iguais, falso caso contrário.
      ****************************************************************
      */ 
        boolean igual = true;
        if(i < p1.length()){
            if(p1.charAt(i) == p2.charAt(i))
                igual = true && ehIgual(p1,p2,i + 1);
            else
                igual = false;
        }
        return igual;
    }//Fim ehIgual

}//Fim classe PalindromoRecursivo

