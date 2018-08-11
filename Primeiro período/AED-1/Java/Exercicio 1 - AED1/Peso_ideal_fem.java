// Autor: Luiz Junio <luisjuniorbr@gmail.com>

import java.util.Scanner; 

public class Peso_ideal_fem    
{
   public static void main(String[] args) 
   {   
      Scanner leia = new Scanner(System.in);
      
      System.out.println("Digite a sua altura: "); 
      double  altura = leia.nextDouble();  
      double  peso = (62.1 * altura) - 44.7 ;
      System.out.printf("Seu o peso ideal e: %.2fkg ", peso);
   } 
} 