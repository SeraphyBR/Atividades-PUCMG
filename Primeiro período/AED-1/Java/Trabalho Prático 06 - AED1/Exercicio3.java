import java.util.Scanner;

public class Exercicio3 {
   public static void main(String[]args)
   { //Inicio main
      
      /***************************************************************
      * Nome do método: main
      * Data da elaboração: 08/04/2018
      * Data da última alteração: 09/04/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Principal
      * Argumentos: nulo
      * Valor gerado: nulo
      ****************************************************************
      */
      double num1, num2, result;
      num1 = leia();
      num2 = leia();
      result = ehMaior( num1, num2);
      System.out.println("O maior número é: " + result);
   
   } //Fim main  
   
   public static double leia()
   {//Inicio leia
   
     /***************************************************************
      * Nome do método: leia
      * Data da elaboração: 08/04/2018
      * Data da última alteração: 09/04/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Fazer a leitura de um número real
      * Argumentos: nulo
      * Valor gerado: valor lido
      ****************************************************************
      */
   
      Scanner ler = new Scanner(System.in);
   
      System.out.print("Digite um numero real: ");
      double num = ler.nextDouble();
      return num;
   
   }//Fim leia
   
   
   
   public static double ehMaior(double x, double y)
   {//Inicio ehMaior
   
     /***************************************************************
      * Nome do método: leia
      * Data da elaboração: 08/04/2018
      * Data da última alteração: 09/04/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Verificar o maior entre dois números
      * Argumentos: os dois números para comparar
      * Valor gerado: o maior valor
      ****************************************************************
      */
      double maior = 0;
      if ( x >= y) maior = x;
      if ( x < y) maior = y;
      return maior;
   }//Fim ehMaior   

} //Fim classe   