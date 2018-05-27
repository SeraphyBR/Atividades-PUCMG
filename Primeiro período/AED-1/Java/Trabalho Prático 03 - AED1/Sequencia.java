// Autor: Luiz Junio <luisjuniorbr@gmail.com>
// coding = utf-8

import java.util.Scanner; 

public class Sequencia    
{
   public static void main(String[] args) 
   {   
      Scanner leia = new Scanner(System.in);
      int maior = 0, cont = 0, valores = 0, num;
      double media;
      
      System.out.println("Esse programa lê os números digitados, calcula a média desses números e imprime o maior valor que foi lido.");
      System.out.println("Para parar o processo de leitura, digite 0.\nObs: O programa não irá aceitar valores negativos.\n");
      
      do{
         System.out.print("Digite um número natural: ");
         num = leia.nextInt();
         if ( num < 0 ) System.out.println("Número Inválido");
         else if ( num == 0) System.out.println("Encerrando leitura....");
         else{
              valores += num;
              cont++;
              if ( num >= maior) maior = num;
         }
      }while (num !=0);
      
      if ( cont > 0 ){
         media = (double) valores / cont;
         System.out.println("A média dos números lidos é: " + media);
         System.out.println("O maior valor lido é: " + maior);
      }
      else System.out.print("Não há nada para ser calculado!");
      
      
 }
} 

      