// Autor: Luiz Junio <luisjuniorbr@gmail.com>

import java.util.Scanner; 

public class Temperatura    
{
   public static void main(String[] args) 
   {   
      Scanner leia = new Scanner(System.in);
      
      System.out.println("Digite uma temperatura em farenheit: "); 
      double  farenheit = leia.nextDouble();  
      double  celcius = 5.0 / 9 * ( farenheit - 32 ) ;
      System.out.printf("A mesma temperatura em celcius: %.2f°c ", celcius);
   } 
} 