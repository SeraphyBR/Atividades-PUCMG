import java.util.Scanner;

public class Exercicio1 {
   public static void main(String[]args)
   { //Inicio main
      
      /***************************************************************
      * Nome do método: main
      * Data da elaboração: 04/04/2018
      * Data da última alteração: 08/04/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Principal
      * Argumentos: nulo
      * Valor gerado: nulo
      ****************************************************************
      */
      
      int somaIdade = 0;
      int idade, cont = 0;
      double idadeMedia;
      
      System.out.println("Esse programa calcula a media da idade de uma turma, digite 0 para encerrar.");
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
   
        /***************************************************************
      * Nome do método: lerIdade
      * Data da elaboração: 04/04/2018
      * Data da última alteração: 08/04/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Ler uma idade
      * Argumentos: nulo
      * Valor gerado: Idade entre 0 e 150
      ****************************************************************
      */
      
   
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