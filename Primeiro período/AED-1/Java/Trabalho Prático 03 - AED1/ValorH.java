// Autor: Luiz Junio <luisjuniorbr@gmail.com>
// coding: utf-8
import java.util.Scanner;

public class ValorH { 
   public static void main (String [] args)
   {
      int termos, num = 100;
      double h = 0;
      Scanner s = new Scanner(System.in);
      
      System.out.println("Esse programa calcula e escreve o valor de H, sendo H igual a: 1/100 + 1/97 + 1/94 + 1/91 + ...");
      System.out.print( "Digite a quantidade de termos a serem usados para calcular o valor de H: ");
      termos = s.nextInt();
      
      while (termos > 0) {
      h += 1.0 / num;
      num -= 3;
      termos-- ;
      }
      System.out.print(" O valor é: " + h );
   
 }
}
                  