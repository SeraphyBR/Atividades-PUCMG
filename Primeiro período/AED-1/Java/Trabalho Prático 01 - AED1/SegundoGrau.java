// Autor: Luiz Junio <luisjuniorbr@gmail.com>

import java.util.Scanner; 

public class SegundoGrau    
{
   public static void main(String[] args) 
   {   
      Scanner leia = new Scanner(System.in);
      System.out.println("Uma equação de segundo grau obedece o seguinte formato: Ax²+Bx+C");
      System.out.print("Digite o valor de A: ");
      double a = leia.nextDouble();
      System.out.print("Digite o valor de B: ");
      double b = leia.nextDouble();
      System.out.print("Digite o valor de C: "); 
      double c = leia.nextDouble();
      
     if (a == 0){
        System.out.print("Digite o valor de A: ");
        a = leia.nextDouble();
     }
     
     double x1 = ((0 - (b)) + Math.sqrt(Math.pow(b,2) - 4*a*c)) / (2.0 * a) ; 
     double x2 = ((0 - (b)) - Math.sqrt(Math.pow(b,2) - 4*a*c)) / (2.0 * a);
     
     if ( x1 != x1 ){
     System.out.print("Não há solução para essa equação.");
     }
     else if ( x1 == x2){
     System.out.print("A raiz é: " + x1);
     }
     else
     System.out.print("As raízes são: " + x1 + " e " + x2);
     
   } 
} 