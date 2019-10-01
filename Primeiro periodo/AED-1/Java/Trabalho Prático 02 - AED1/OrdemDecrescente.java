// Autor : Luiz Junio <luisjuniorbr@gmail.com> 
// coding = utf-8

import java.util.Scanner;
public class  OrdemDecrescente 
{
   public static void main (String[] args)
   {  
      int inicio, fim;
      Scanner s = new Scanner (System.in);
      
      System.out.println("Esse programa mostra os numeros que estão entre um intervalo, em ordem decrescente.");
      System.out.print("Digite o primeiro valor: ");
      inicio = s.nextInt();
      System.out.print("Digite o ultimo valor: ");
      fim = s.nextInt();
      
      do{
         System.out.println(inicio);
         inicio = inicio - 1;
      }  while (inicio >= fim );
   
   
  }  
}   