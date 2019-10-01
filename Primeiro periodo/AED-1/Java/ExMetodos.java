// Autor: Luiz Junio <luisjuniorbr@gmail.com>

import java.util.Scanner;

public class ExMetodos{
   public static void main(String []args){
      Scanner s = new Scanner(System.in);
      System.out.print("Digite o numero de veses: ");
      int n = s.nextInt();  
      mensagem(n,"Luiz Junio");
      System.out.println("Soma: ");
      System.out.println("Digite os dois valores: ");
      double a = s.nextDouble();
      double b = s.nextDouble();
      double result = soma(a,b);
      System.out.print(result);
      
           
   }
   
   public static double soma(double x, double y){
      double r;
      r = x + y;
      return r;
  } 
   
   public static void mensagem(int x, String palavra ){
      for(int cont = 0; cont < x; cont++){  
        System.out.println(palavra);
      }
   }
  
   
}   