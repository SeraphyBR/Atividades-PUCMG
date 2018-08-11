// Autor: Luiz Junio <luisjuniorbr@gmail.com>

import java.util.Scanner; 

public class Perimetro_leitura    
{
   public static void main(String[] args) 
   {   
      Scanner leia = new Scanner(System.in);
      
      System.out.println("Digite o valor do lado do quadrado: "); 
      double  lado = leia.nextDouble();  
      double perimetro = lado * 4;
      System.out.println("O perimetro do quadrado e: " + perimetro );
   } 
} 