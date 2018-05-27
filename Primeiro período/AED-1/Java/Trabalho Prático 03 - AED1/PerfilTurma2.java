// Autor: Luiz Junio <luisjuniorbr@gmail.com>
// coding = utf-8

import java.util.Scanner; 

public class PerfilTurma2    
{
   public static void main(String[] args) 
   {   
      Scanner leia = new Scanner(System.in);
      int idade, velho = 0, jovem = 100, cont = 1;
      double homens = 0, mulheres = 0, adulto = 0;
      char genero;
     
     System.out.println("Esse programa irá identificar o perfil de uma turma.");
     System.out.println("Digite [ s ] como gênero para finalizar a leitura.\n");
     
     do{
         
         do{
         
            System.out.print("Aluno " + cont +  ": Qual o seu gênero? [ m / f ]: ");
            genero = leia.next().charAt(0);
            genero = Character.toLowerCase(genero);
            
         }while(genero != 'm' && genero != 'f' && genero != 's');
         
         if ( genero == 'm') homens++;
         if ( genero == 'f' ) mulheres++;
         
         if ( genero != 's'){      
            do{     
            
               System.out.println("Qual a sua idade?");
               idade = leia.nextInt();
               if ( idade > 100 || idade < 0 ) System.out.println("Valor inválido!");   
            }while( idade > 100 || idade < 0);
         
            if ( idade >= 18) adulto++;
            if ( idade >= velho) velho = idade;
            if ( idade <= jovem) jovem = idade;
            
            cont++;
         }
        else System.out.println("Encerrando leitura...."); 
         
     }while( genero != 's');
     
     if (cont > 1){
      System.out.printf("O percentual de homens na turma é: %.1f%% \n",  (homens / cont) * 100 );
      System.out.printf("O percentual de mulheres na turma é: %.1f%% \n", (mulheres/cont) * 100 );
      System.out.printf("O percentual de alunos maiores de idade é: %.1f%% \n", (adulto/cont) * 100 );
      System.out.println("A idade da pessoa mais velha é: " + velho + " anos.");
      System.out.print("A idade da pessoa mais nova é: " + jovem + " anos.");
      }
     else System.out.print("Não há informação para mostrar!"); 
 }
} 

      