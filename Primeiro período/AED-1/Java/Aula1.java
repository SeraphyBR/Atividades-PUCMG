import java.util.Scanner;

public class Aula1
{//Inicio Aula1
   public static void main(String[]args)
   {//Inicio Main
   
   /***************************************************************
    * Nome do método: main
    * Data da elaboração: 11/04/2018
    * Data da última alteração: 11/04/2018
    * Autor: Luiz Junio <luisjuniorbr@gmail.com>
    * Contexto de ação: Principal
    * Argumentos: nulo
    * Valor gerado: nulo
    ****************************************************************
    */
   
      Scanner ler = new Scanner(System.in);
      System.out.print("Qual termo de fibonacci deseja calcular?\n=> ");
      int num = ler.nextInt();
      System.out.println(fibonacci(num));
   }//Fim main
   
   public static long fibonacci(int k)
   {//Inicio fibonacci
   
   /***************************************************************
    * Nome do método: fibonacci
    * Data da elaboração: 11/04/2018
    * Data da última alteração: 11/04/2018
    * Autor: Luiz Junio <luisjuniorbr@gmail.com>
    * Contexto de ação: Calcular um termo da sequencia de fibonacci
    * Argumentos: termo a ser calculado
    * Valor gerado: valor correspondente ao termo na sequencia de fibonacci
    ****************************************************************
    */
   
      long result;
      if (k < 1) result = 0;
      else if (k == 1 || k == 2) result = 1;
      else result = fibonacci(k - 1) + fibonacci(k - 2);
      return result; 
   }//Fim fibonacci

}//Fim Aula1