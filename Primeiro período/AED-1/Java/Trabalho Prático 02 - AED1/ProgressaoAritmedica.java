// Autor : Luiz Junio <luisjuniorbr@gmail.com> 
// coding = utf-8

import java.util.Scanner;
public class  ProgressaoAritmedica 
{
   public static void main (String[] args)
   {  
      double razao, primeirotermo, valor;
      int termos, cont = 1;
      Scanner s = new Scanner (System.in);
      
      System.out.println("Esse programa mostra os N primeiros termos de uma P.A.");
      System.out.print("Digite o primeiro termo da P.A: ");
      primeirotermo = s.nextDouble();
      System.out.print("Digite a razão: ");
      razao = s.nextDouble();
      System.out.print("Digite o número de termos: ");
      termos = s.nextInt();
      
      do{
         valor = primeirotermo + ( cont - 1) * razao;
         System.out.println( cont + "º => " + valor);
         cont = cont + 1;
         
      }  while (cont <= termos );
   
   
  }  
}   