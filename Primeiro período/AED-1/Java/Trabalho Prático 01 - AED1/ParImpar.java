// Autor: Luiz Junio <luisjuniorbr@gmail.com>

import java.util.Scanner;

class ParImpar { 
   public static void main (String [] args)
   {  
      Scanner s = new Scanner (System.in);
      System.out.print("Digite um número inteiro: ");
      int num = s.nextInt();
      if (num % 2 == 0  ){
      System.out.print("O número "+ num + " é par.");
      }
      else System.out.print("O número "+ num + " é impar.");


      
     
   }
}  