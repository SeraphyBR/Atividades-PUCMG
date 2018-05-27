// Autor: Luiz Junio <luisjuniorbr@gmail.com>
// coding: utf-8
import java.util.Scanner;

public class Htermos { 
   public static void main (String [] args)
   {
      int termos, b = 100, a = 1, troca = 0;
      double h = 0;
      Scanner s = new Scanner(System.in);
      
      System.out.println("Esse programa calcula os termos da seguinte sequencia: 1/100, 97/2, 3/94, 91/4, 5/88, ... ");
      System.out.print( "Digite a quantidade de termos: ");
      termos = s.nextInt();
      while (termos > 0) {
          
          if ( troca == 0){
             h = (double) a / (double) b;
             troca = 1;
          }
          else {
                     h = (double)b / (double) a;
                     troca = 0;
          }           
          
         System.out.println(h);
         a++;
         b -= 3;
         
         
         termos--;
      
       
      }
      
   
 }
}
                  