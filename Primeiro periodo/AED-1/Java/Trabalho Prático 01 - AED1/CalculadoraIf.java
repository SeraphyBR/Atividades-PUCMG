// Autor: Luiz Junio <luisjuniorbr@gmail.com>

import java.util.Scanner; 

public class CalculadoraIf    
{
   public static void main(String[] args) 
   {   
      Scanner leia = new Scanner(System.in);
      double num1, num2, result;
      
      System.out.printf("Calculadora:\nQue operação deseja realizar?\n");
      System.out.printf("Digite:\n1-Somar\n2-Subtrair\n3-Multiplicar\n4-Dividir\n=> ");
      int op = leia.nextInt();
      
      if (op == 1){
      System.out.println(" A + B ");
      System.out.print("Insira o valor de A: ");
      num1 = leia.nextDouble();
      System.out.print("Insira o valor de B: ");
      num2 = leia.nextDouble();
      result = num1 + num2;
      System.out.print( num1 + " + " + num2 + " = " + result);
      }
     
      if (op == 2){
      System.out.println(" A - B ");
      System.out.print("Insira o valor de A: ");
      num1 = leia.nextDouble();
      System.out.print("Insira o valor de B: ");
      num2 = leia.nextDouble();
      result = num1 - num2;
      System.out.print( num1 + " - " + num2 + " = " + result);
      }
      
      if (op == 3){
      System.out.println(" A x B ");
      System.out.print("Insira o valor de A: ");
      num1 = leia.nextDouble();
      System.out.print("Insira o valor de B: ");
      num2 = leia.nextDouble();
      result = num1 * num2;
      System.out.print( num1 + " x " + num2 + " = " + result);
      }
     
      if (op == 4){
      System.out.println(" A / B ");
      System.out.print("Insira o valor de A: ");
      num1 = leia.nextDouble();
      System.out.print("Insira o valor de B: ");
      num2 = leia.nextDouble();
      result = num1 / num2;
      System.out.print( num1 + " / " + num2 + " = " + result);
      }
     
   } 
} 