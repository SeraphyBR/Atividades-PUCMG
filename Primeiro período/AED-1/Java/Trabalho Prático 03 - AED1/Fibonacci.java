// Autor: Luiz Junio <luisjuniorbr@gmail.com>
// coding = utf-8

import java.util.Scanner; 

public class Fibonacci    
{
   public static void main(String[] args) 
   {   
      int termos, f1 = 0, f2 = 1, f3 = 1, cont = 0;
      
      Scanner ler = new Scanner(System.in);
      
      System.out.println("Quantos termos de fibonacci devem ser calculados?");
      termos = ler.nextInt();
      System.out.println(f2);
      while (cont < termos){    
          System.out.println( f3 );
          f1 = f2;
          f2 = f3;
          f3 = f2 + f1; 
          cont++;
      
      }

   
   
   
   
   
   
   
   
 }  
}   