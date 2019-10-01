import java.util.Scanner;

public class Exercicio5 
{//Inicio Classe
   public static void main(String[]args)
   {//Inicio main
      
      /***************************************************************
      * Nome do método: main
      * Data da elaboração: 09/04/2018
      * Data da última alteração: 09/04/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Principal
      * Argumentos: nulo
      * Valor gerado: nulo
      ****************************************************************
      */
      Scanner ler = new Scanner(System.in);
      int resultado;
      char desejo;
      do{
         resultado = fatorial( leiaNum());     
         System.out.println("O fatorial é: " + resultado);
         do{
              System.out.print("Deseja fazer mais calculos? [S/N]\n=>");
              desejo = Character.toUpperCase( ler.next().charAt(0) );
         }while(desejo != 'S' && desejo != 'N');
      }while(desejo == 'S');

   }//Fim main
   
   public static int fatorial(int num)
   {//Inicio fatorial
   
     /***************************************************************
      * Nome do método: fatorial
      * Data da elaboração: 09/04/2018
      * Data da última alteração: 09/04/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Calcular o fatorial de um número.
      * Argumentos: numero inteiro positivo a ser calculado.
      * Valor gerado: fatorial do argumento do método.
      ****************************************************************
      */
      int result = 1;
      for (int cont = 1; cont <= num; cont++) result *=  cont;
      return result;   
   
   }//Fim fatorial
   
   public static int leiaNum()
   {//Inicio leia
   
     /***************************************************************
      * Nome do método: leiaNum
      * Data da elaboração: 09/04/2018
      * Data da última alteração: 09/04/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Fazer a leitura de um número inteiro positivo
      * Argumentos: nulo
      * Valor gerado: valor lido
      ****************************************************************
      */
      int num;
      boolean invalido;
      Scanner ler = new Scanner(System.in);
      do{
         System.out.print("Digite um numero inteiro: ");
         num = ler.nextInt();
         invalido = num < 0;
         if (invalido) System.out.println("Valor invalido!");
      }while(invalido);
      return num;
   
   }//Fim leiaNum
   
   
   
}//Fim classe   