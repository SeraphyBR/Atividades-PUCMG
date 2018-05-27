import java.util.Scanner;

public class Exercicio2 {
   public static void main(String[]args)
   { //Inicio main
      
      /***************************************************************
      * Nome do método: main
      * Data da elaboração: 04/04/2018
      * Data da última alteração: 09/04/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Principal
      * Argumentos: nulo
      * Valor gerado: nulo
      ****************************************************************
      */
      int num; char desejo;
      Scanner ler = new Scanner(System.in);
      do{
         System.out.print("Digite um número inteiro: ");
         num = ler.nextInt();
         if( ehPar(num) ) System.out.println( num + " é par!");
         else System.out.println(num + " é impar!");
         do{
            System.out.print("Deseja verificar mais números? [S/N]\n=>");
            desejo = Character.toUpperCase( ler.next().charAt(0) );
         }while(desejo != 'S' && desejo != 'N');
      }while(desejo == 'S');
   
   }//Fim main



   public static boolean ehPar(int num)
   {  //Inicio ehPar
   
     /***************************************************************
      * Nome do método: ehPar
      * Data da elaboração: 04/04/2018
      * Data da última alteração: 08/04/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: chamada
      * Argumentos: um valor inteiro relativo ao número a ser verificado
      * Valor gerado: verdadeiro, se o argumento for par, ou falso, caso contrário
      ****************************************************************
      */
   
      boolean par = true;
      if ( num % 2 == 1) par = false;
      return par;  
   }//Fim EhPar
   
   
   
}//Fim classe   