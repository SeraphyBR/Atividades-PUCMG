// Autor: Luiz Junio <luisjuniorbr@gmail.com>

import java.util.Scanner;

public class Lista05{
   public static void main(String []args){
      /********************************************
       * Nome do método: main
       * Data da elaboração: 21/03/18
       * Data da última alteração: 21/03/2018
       * Autor: Luiz Junio
       * Contexto de ação: 
       
       * Argumentos: nulo
       * Valor gerado: nulo
       ********************************************
      */
   
   
   
      Scanner s = new Scanner(System.in);
      System.out.print("Digite o numero de veses: ");
      int n = s.nextInt();  
      mensagem(n,"Luiz Junio");
      System.out.println("Soma: ");
      System.out.println("Digite os dois valores: ");
      double a = s.nextDouble();
      double b = s.nextDouble();
      double result = soma(a,b);
      System.out.print(result);
      
           
   }
   
   public static double soma(double x, double y){
        /********************************************
       * Nome do método: soma
       * Data da elaboração: 21/03/2018
       * Data da última alteração: 21/03/2018
       * Autor: Luiz Junio
       * Contexto de ação: Realizar a soma de dois valores
                           e retornar o resultado.
       * Argumentos:
       * Valor gerado:
       ********************************************
      */
   
      double r;
      r = x + y;
      return r;
  } 
   
  
   
}   