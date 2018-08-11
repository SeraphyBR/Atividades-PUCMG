import java.util.Scanner;

public class Exercicio4 
{//Inicio Classe
   public static void main(String[]args)
   {//Inicio main
      
      /***************************************************************
      * Nome do método: main
      * Data da elaboração: 08/04/2018
      * Data da última alteração: 09/04/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Principal
      * Argumentos: nulo
      * Valor gerado: nulo
      ****************************************************************
      */
      int ano;
      ano = leAno();
      if ( ehBissexto(ano)) System.out.println( ano + " é bissexto!");
      else System.out.println(ano + " não é bissexto!");

   }//Fim main


   public static int leAno()
   {//Inicio leAno
   
      Scanner ler = new Scanner(System.in);
      int ano;
      boolean invalido;
      do{
         System.out.print("Digite um ano: ");
         ano = ler.nextInt();
         invalido = ano < 0 ;
         if (invalido) System.out.println("Valor inválido!");
      }while(invalido);
      return ano;
   
   }//Fim leAno


   public static boolean ehBissexto(int ano)
   {//Inicio ehBissexto
    /********************************************
    * Nome do método: ehBissexto
    * Data da elaboração: 08/04/2018
    * Data da última alteraçãoo: 09/04/2018
    * Autor: Luiz Junio <luisjuniorbr@gmail.com>
    * Contexto de ação: Diz se o ano é bissexto ou não.
    * Argumentos: valor inteiro a ser verificado
    * Valor gerado: Verdadeiro, se ano for bissexto, Falso, caso contrário.
    ********************************************
    */
      
      boolean result = false;
      if ((ano%4 == 0)&&((ano%100 !=0)||(ano%400 == 0))) result = true;
      return result;
      
   }//Fim ehBissexto    

}//Fim classe