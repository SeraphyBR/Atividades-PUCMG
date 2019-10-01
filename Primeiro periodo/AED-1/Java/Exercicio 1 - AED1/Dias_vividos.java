// Autor: Luiz Junio <luisjuniorbr@gmail.com>

import java.util.Scanner; 

public class Dias_vividos    
{
   public static void main(String[] args) 
   {   
      Scanner leia = new Scanner(System.in);
      
      System.out.println("Digite a sua idade: "); 
      int  idade = leia.nextInt();  
      int  dias = idade * 365 ;
      System.out.println("Voce viveu por: " + dias + " dias." );
   } 
} 