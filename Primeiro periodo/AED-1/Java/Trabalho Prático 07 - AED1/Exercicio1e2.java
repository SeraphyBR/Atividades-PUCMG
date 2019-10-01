import java.util.Scanner;

public class Exercicio1e2 
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
      System.out.println("f(x) = " + funcao(num));   
        
   }//Fim main
   
   public static int funcao(int n)
   {//Inicio funcao
   
      int valor;
      if (n == 0) valor = 1;
      else valor = n * funcao(n-1);
      return valor;
         
   }//Fim funcao   
  
  
}//Fim classe
   
/*  

   RESPOSTA QUESTÃO DOIS: 

    public static int funcao(int n){
         if (n == 0)
            return (1);
         else
            return(n * funcao(n-1));
    } 
   
 i. funcao(0)  = 1
ii. funcao(1)  = 1
iii. funcao(2) = 2
iv. funcao(3) = 6
v. funcao(4)  = 24  
*/     