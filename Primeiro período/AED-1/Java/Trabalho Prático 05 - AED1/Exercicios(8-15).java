import java.util.Scanner;
public class Exercicios(8-15)
{//Inicio Classe
   public static void main(String[]args)
   {//Inicio main
   
      Scanner s = new Scanner(System.in);
      double x, y;
      System.out.println("Qual método deseja executar?");
      System.out.println("1 - metodo8\n2 - soma\n3 - par\n4 - perimetroQuadrado");
      System.out.println("5 - areaQuadrado\n6 - bissexto\n=> ");
      
      int opcao = s.nextInt();
      switch (opcao){
         case 1:
            metodo8(1,5) 
            break;
         case 2: 
            
            break; 
         case 3: 
            
            break;
         case 4:
          
          break;
         case 5:
            
            break; 
         case 6:
            
            break;

            
   }//Fim main  
}//Fim classe
   
public class solucoes
{//Inicio classe solucoes
   public static int metodo8(int n, int m) 
   {//Inicio metodo8
      int soma;
      if ( n == m) return soma;
      soma = n + metodo8((n+1),m)
   }//Fim metodo8
         
   
   
   
   
}//Fim classe solucoes   