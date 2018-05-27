// Autor: Luiz Junio <luisjuniorbr@gmail.com>

import java.util.Scanner;

class Potencia { 
   public static void main (String [] args)
   {  
      Scanner s = new Scanner (System.in);
      System.out.println("Esse programa calcula um número elevado a um expoente,");
      System.out.print("Digite um número para a base: ");
      double base = s.nextDouble();
      System.out.print("Digite o expoente da potenciação: ");
      double expoente = s.nextDouble();
      double result = Math.pow(base,expoente);
      System.out.print("O resultado é: " + result);
    
      
      
       
   }
}      