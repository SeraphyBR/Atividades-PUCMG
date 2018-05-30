import java.util.Scanner;

public class Exercicio1 {
   public static void main(String[]args)
   { //Inicio main
      
      int somaIdade = 0;
      int idade, cont = 0;
      double idadeMedia;
      
      idade = lerIdade();
      while(idade != 0)
      {//Inicio while
       
         somaIdade += idade;
         cont++;
         idade = lerIdade();
      
      }//Fim while
      idadeMedia = (double)somaIdade/(double)cont;   
      System.out.printf("A idade media eh: %.2f",idadeMedia);
   
   }//Fim main
   
   public static int lerIdade()
   {//Inicio lerIdade
   
      Scanner ler = new Scanner(System.in);
      int idade;
      boolean erro;
      do{
         System.out.print("Digite a idade: ");
         idade = ler.nextInt();
         erro = ( idade < 0 ) || ( idade > 150); 
         if (erro) System.out.println("Idade Invalida");
      }while(erro);
      return idade;  
       
   }//Fim lerIdade



}//Fim da classe   