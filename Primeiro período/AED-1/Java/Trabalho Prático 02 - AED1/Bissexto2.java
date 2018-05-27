// Autor: Luiz Junio <luisjuniorbr@gmail.com>
// coding: utf-8
import java.util.Scanner;

public class Bissexto2 { 
   public static void main (String [] args)
   {
      int exec = 0;
      char opcao;
      do{ 
         
         Scanner s = new Scanner (System.in);
         if ( exec == 0){
         System.out.println("Esse programa irá dizer se um ano é bissexto ou não.");
         System.out.print("Digite um ano: ");
         }
         else System.out.print("Digite um ano: ");
         int ano = s.nextInt();
      
         if ((ano%4 == 0)&&((ano%100 !=0)||(ano%400 == 0))){
            System.out.printf("O ano %d é bissexto.\n",ano);
         }
           
         else System.out.printf("O ano %d não é bissexto.\n",ano);
         
         do {
            System.out.print("\nDeseja digitar outro ano?\nDigite: s => sim e n => não.\n>: ");
            opcao = s.next().charAt(0);
            if ( opcao == 's' ) exec = 1 ;
            else exec = 0;
         } while( (opcao != 's') && (opcao != 'n'));
         
      }while( exec == 1);  
   }
}       