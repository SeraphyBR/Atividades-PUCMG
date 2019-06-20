// Autor : Luiz Junio <luisjuniorbr@gmail.com> 
// coding = utf-8

import java.util.Scanner;
public class  ProgressaoAritmedica 
{
   public static void main (String[] args)
   {  
      double razao, primeirotermo, valor;
      int termos, cont = 1, x, divisiveis = 0, exec;
      char op;
      Scanner s = new Scanner (System.in);
      
      System.out.println("Esse programa calcula o número de termos da P.A, que são dívisiveis por X.");
      do{
         System.out.print("Digite o valor de X: ");
         x = s.nextInt();
         System.out.print("Digite o primeiro termo da P.A: ");
         primeirotermo = s.nextDouble();
         System.out.print("Digite a razão: ");
         razao = s.nextDouble();
         do{
            System.out.print("Digite o número de termos: ");
            termos = s.nextInt();
            if (termos <= 0 ) System.out.println("Valor inválido!");
         }while(termos <= 0);
             
         do{
            valor = primeirotermo + ( cont - 1) * razao;
            System.out.println( cont + "º => " + valor);
            cont = cont + 1;
            if ( valor % x == 0 ) divisiveis++; 
         }  while (cont <= termos );
         
         System.out.println(" A quantidade de termos que é divisivel por " + x + " é: " + divisiveis);
    
         do{
            exec = 0;
            System.out.print("Deseja fazer um novo calculo? [s/n]: ");
            op =  Character.toLowerCase(s.next().charAt(0));
            if ( op == 's' ) exec = 1;
            if ( op == 'n' ) exec = 2;
         }while(exec == 0);
      
    }while(exec == 1);  
  }  
}   
