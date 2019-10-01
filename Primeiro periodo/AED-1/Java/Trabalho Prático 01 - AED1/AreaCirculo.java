// Autor: Luiz Junio <luisjuniorbr@gmail.com>

import java.util.Scanner;

class AreaCirculo { 
   public static void main (String [] args)
   {  
      Scanner s = new Scanner (System.in);
      System.out.print("Digite o raio do circulo: ");
      double raio = s.nextDouble();
      double area = Math.PI * Math.pow(raio,2);
      System.out.printf("A área do circulo é: %.2f  ", area);
   }
}  