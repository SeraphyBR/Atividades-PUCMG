// Autor: Luiz Junio <luisjuniorbr@gmail.com>
// coding: utf-8
import java.util.Scanner;

public class Eleicao { 
   public static void main (String [] args)
   {
         int chapa1 = 0,chapa2 = 0 ,branco = 0,nulo = 0,op,conte = 0 ,exec = 1;
         int alunos;
         double percentual;
         
         Scanner ler = new Scanner(System.in);
         
         System.out.println("Quantos alunos tem a turma, que realizará a votação? ");
         alunos = ler.nextInt();
         
         while(alunos > 0 && exec == 1){
            System.out.println("O D.A.C.C está realizando uma eleição com duas chapas,\nQual será o seu voto?");  
            System.out.println("0 - Sair do Programa\n1 - Chapa 1\n2 - Chapa 2\n3 - Voto em branco\n4 - Voto nulo");
            op = ler.nextInt();
         
           switch ( op ){
              case 0:
                 exec = 0;
                 break;
              case 1: 
                 chapa1++;
                 conte++;
                 alunos--;
                 break;
              case 2:
                 chapa2++;
                 conte++;
                 alunos--;
                 break;
              case 3:
                 branco++;
                 conte++;
                 alunos--;
                 break;
              case 4: 
                 nulo++;
                 conte++;
                 alunos--;
                 break;            
              default:
                 System.out.print("Digito Inválido, por favor vote novamente.");
                 break;
         }        
         if ( alunos == 0){
            System.out.println("Votos chapa 1 = "+ chapa1 );
            System.out.println("Votos chapa 2 = "+ chapa2 );
            System.out.println("Votos em branco = "+ branco );
            System.out.println("Votos nulos = "+ nulo );
            
            if ( chapa1 > chapa2){
               percentual = ( chapa1/ (double) conte) * 100;
               System.out.print("A chapa 1 é vencedora, com percentual de " + percentual + "% dos votos!");
            }   
            else if ( chapa2 > chapa1) {
               percentual = ( chapa2 / (double) conte) * 100;
               System.out.print("A chapa 2 é vencedora, com percentual de " + percentual + "% dos votos!");
            }  
            else System.out.print("A chapa 1 e chapa 2 estão empatados!"); 
      }
 }  
 }
}
                  