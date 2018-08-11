// Autor: Luiz Junio <luisjuniorbr@gmail.com>
import java.util.Scanner;

public class fatorial {
   public static void main(String []args){
   int fatorial; 
   int num;
   
   Scanner read = new Scanner(System.in); 
   
   System.out.println("Esse programa calcula o fatorial de um número.");
   System.out.println("Digite um número negativo para encerrar o programa.");
   do{
      System.out.print("Digite um número inteiro: ");
      num = read.nextInt();
      fatorial = 1;
      if ( num > 0 ){
         for( int cont = num ; cont > 0; cont-- ){
         fatorial *= cont;
         }
         System.out.println("O fatorial de " + num + " é: " + fatorial);
         
      }
   }while( num >= 0);
   System.out.println("Encerrando....");
 }  
}   