// Autor: Luiz Junio <luisjuniorbr@gmail.com>

import java.util.Scanner;

class Grau { 
   public static void main (String [] args)
   {
      Scanner s = new Scanner (System.in);
      System.out.print("Digite escreva um grau em farenheit: ");
      double grauf = s.nextDouble();
      double grauc = 5.0/9 * (grauf - 32);
      System.out.printf("O grau em celcius é: %.2f°C ",grauc);
      
      
       
   }
}      