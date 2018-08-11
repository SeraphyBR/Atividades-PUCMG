// Autor: Luiz Junio <luisjuniorbr@gmail.com>
// coding: utf-8
import java.util.Scanner;

public class testeCharacter { 
   public static void main (String [] args)
   {
      int num;
      char continua;
      Scanner s = new Scanner(System.in);
      boolean erro;
      do { 
            System.out.print("Número: ");
            num = s.nextInt();
            if (num % 2 == 0 ) System.out.println("Par");
            else System.out.println("ímpar");
            do { 
                  System.out.print("Continua? [S/N]: ");
                  continua = s.next().charAt(0);
                  continua = Character.toUpperCase(continua);
                  erro = continua !='S' && continua !='N';
                  if (erro) System.out.println("Inválido");
                  
               }while(erro);
      }while(continua == 'S');
 }
}
                  