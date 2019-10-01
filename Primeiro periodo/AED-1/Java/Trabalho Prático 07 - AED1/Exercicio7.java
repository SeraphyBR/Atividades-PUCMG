import java.util.Scanner;

public class Exercicio7
{//Inicio Classe
   public static void main(String[]args)
   {//Inicio main
      Scanner ler = new Scanner(System.in);
      System.out.print("Digite o limite inferior: ");
      int inferior = ler.nextInt();
      System.out.print("Digite o limite superior: ");
      int superior = ler.nextInt();
      metodo7(inferior,superior); 
            
   }//Fim main
   
   public static void metodo7(int inferior, int superior) 
   {//Inicio metodo7
      int num = inferior;
      if (num == superior) return;
      num++;
      System.out.print(num + ", ");
      metodo7(num,superior);
      System.out.print(num + ", ");
      num--; 
   }//Fim metodo7
         
 
  
}//Fim classe
   
