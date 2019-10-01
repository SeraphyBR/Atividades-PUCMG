// Autor: Luiz Junio <luisjuniorbr@gmail.com>
// coding = utf-8

import java.util.Scanner; 

public class Calculadora    
{
   public static void main(String[] args) 
   {   
      Scanner leia = new Scanner(System.in);
      int exec = 0;
      double num1, num2, result;
      
      while(exec == 0){
         System.out.printf("\nCalculadora:\nQue operação deseja realizar?\n");
         System.out.printf("Digite:\n1-Sair do programa\n2-Somar\n3-Subtrair\n4-Multiplicar\n5-Dividir\n=> ");
         int op = leia.nextInt();
      
         switch (op){
         case 1:
            exec = 1;
            break;
         case 2:
            System.out.println(" A + B ");
            System.out.print("Insira o valor de A: ");
            num1 = leia.nextDouble();
            System.out.print("Insira o valor de B: ");
            num2 = leia.nextDouble();
            result = num1 + num2;
            System.out.println( num1 + " + " + num2 + " = " + result);
            break;
         case 3:
            System.out.println(" A - B ");
            System.out.print("Insira o valor de A: ");
            num1 = leia.nextDouble();
            System.out.print("Insira o valor de B: ");
            num2 = leia.nextDouble();
            result = num1 - num2;
            System.out.println( num1 + " - " + num2 + " = " + result);
            break;
         case 4:
            System.out.println(" A x B ");
            System.out.print("Insira o valor de A: ");
            num1 = leia.nextDouble();
            System.out.print("Insira o valor de B: ");
            num2 = leia.nextDouble();
            result = num1 * num2;
            System.out.println( num1 + " x " + num2 + " = " + result);
            break;
         case 5:
            System.out.println(" A / B ");
            System.out.print("Insira o valor de A: ");
            num1 = leia.nextDouble();
            System.out.print("Insira o valor de B: ");
            num2 = leia.nextDouble();
            result = num1 / num2;
            System.out.println( num1 + " / " + num2 + " = " + result);
            break;
    
         } 
          
      } 
      System.out.println("Obrigado por usar o programa.");
   }
}   