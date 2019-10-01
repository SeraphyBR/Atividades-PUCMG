// Autor: Luiz Junio <luisjuniorbr@gmail.com>
// coding: utf-8

import java.util.Scanner; 

public class IdadeMedia    
{
   public static void main(String[] args) 
   {   
      Scanner leia = new Scanner(System.in);
      int turma, cont = 1;
      double media, idade = 0;
      
      System.out.println("Esse programa calcula a idade média dos alunos de uma turma.");
      System.out.print("Quantos alunos tem a turma?\n=> ");
      turma = leia.nextInt();
      
      while ( cont <= turma){
         System.out.println("Digite a idade do aluno " + cont + " : ");
         idade = idade + leia.nextInt();
         cont = cont + 1;
      }   
      media = idade / turma;
      System.out.print("A idade média dos alunos da turma é: " + media + " anos." );

   }
}       