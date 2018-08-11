/*
    Autor: Luiz Junio <luisjuniorbr@gmail.com>
    Enunciado:
    Palindromo - Crie um metodo iterativo que recebe uma string como parametro e retorna true
    se essa e um palindromo. Na saida padrao, para cada linha de entrada, escreva uma linha de
    saida com SIM / NAO indicando se a linha e um palindromo.
*/


public class Palindromo
{//Inicio classe Palindromo     
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

    public static boolean ehPalindromo(String palavra)
    {//Inicio ehPalindromo
     /***************************************************************
      * Nome do metodo: ehPalindromo
      * Data da elaboração: 08/08/2018
      * Data da ultima alteração: 08/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Verificar se uma String pode ser lida da esquerda
      * para a direita, e vice-versa.
      * Valor gerado: verdadeiro se for um paindromo, falso caso contrário.
      ****************************************************************
      */ 

        boolean palindromo = true;
        int letra = 0;
        int ultimo = palavra.length() - 1;//posicao da ultima letra

        while(letra < palavra.length() / 2 && palindromo){
            if(palavra.charAt(letra) != palavra.charAt(ultimo - letra)){ 
                palindromo = false;
            }//Fim if 
            letra++;
        }//Fim while
        return palindromo;
    }//Fim ehPalindromo

}//Fim classe Palindromo
