import java.util.Scanner;

public class Exercicio3e4
{//Inicio Classe
   public static void main(String[]args)
   {//Inicio main
   
      Scanner ler = new Scanner(System.in);
      int num; boolean erro;
      do{
         System.out.print("Digite um valor positivo para X: ");
         num = ler.nextInt();
         erro = num < 0;
         if (erro) System.out.println("Valor inválido!");
      }while(erro);
      System.out.println("f(x) = " + f2(num));   
        
   }//Fim main
   
   public static int f2(int n) 
   {//Inicio f2
      int valor;
      if (n == 0) valor = 1;
      else if (n == 1) valor = 1;
      else  valor = f2(n - 1) + 2 * f2(n - 2);
      return valor;
   }//Fim f2
         
 
  
}//Fim classe
   
/*  

   RESPOSTA QUESTÃO TRÊS: 
   public static int f2(int n) {
      if (n == 0)
         return (1);
      if (n == 1)
         return (1);
      else  return(f2(n - 1)+ 2 * f2(n - 2));
}
Considere as entradas:
i. f2(0) =  1
ii. f2(1) = 1
iii. f2(5) = 21

*/