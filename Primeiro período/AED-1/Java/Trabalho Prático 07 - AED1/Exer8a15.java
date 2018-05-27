import java.util.Scanner;

public class Exer8a15
{//Inicio Classe Exer8a15
   public static void main(String[]args)
   {//Inicio main
   
      Scanner s = new Scanner(System.in);
      int x, y;
      double a,b;
      System.out.println("Qual método deseja executar?");
      System.out.println("1 - metodo8\n2 - metodo9\n3 - metodo10\n4 - metodo11");
      System.out.print("5 - metodo12\n6 - metodo13\n=> ");
      
      int opcao = s.nextInt();
      switch (opcao){
         case 1:
            System.out.println("Esse método calcula a soma dos números entre X e Y.");
            System.out.print("Digite o valor de X: ");
            x = s.nextInt();
            System.out.print("Digite o valor de Y: ");
            y = s.nextInt();
            System.out.print("O resultado eh: " + Solucoes.somaIntervalo(x,y) ); 
            break;
         case 2: 
            System.out.println("Esse método calcula o fatorial de um numero.");
            System.out.print("Digite o numero: ");
            x = s.nextInt();
            System.out.println("O fatorial eh: " + Solucoes.fatorial(x) );
            break; 
         case 3: 
            System.out.println("Esse metodo realiza um calculo de potenciacao.");
            System.out.print("Digite o valor da base: ");
            a = s.nextDouble();
            System.out.print("Digite um número natural para o expoente: ");
            y = s.nextInt();
            System.out.println("O resultado eh: " + Solucoes.metodo10(a,y) );
            break;
         case 4:
            System.out.print("Qual termo de fibonacci deseja calcular?\n=> ");
            x = s.nextInt();
            System.out.println("Resultado: " + Solucoes.fibonacci(x) ); 
          break;
         case 5:
            System.out.println("Esse programa imprime os números entre N e 0.");
            System.out.print("Digite o valor de N: ");
            x = s.nextInt();
            Solucoes.decrescente(x);
            break; 
         case 6:
            System.out.println("Esse programa calcula a soma dos primeiros N cubos.");
            System.out.print("Digite o valor de N: ");
            x = s.nextInt();
            System.out.println("A soma eh: " + Solucoes.somaNcubos(x) );
            break;
      }
            
   }//Fim main  
}//Fim classe Exer8a15
   
   
class Solucoes
{//Inicio classe solucoes
   public static int somaIntervalo(int n, int m) 
   {//Inicio metodo8
   
      int soma = 0;
      if ( n > m) return soma;
      else{
         soma = n + somaIntervalo((n+1),m);
         return soma;  
      }    
      
   }//Fim metodo8
   
   public static int fatorial(int n)
   {//Inicio metodo9
   
      int fat;
      if ( n == 1) fat = 1;
      else fat = n * fatorial( n - 1);
      return fat;
      
   }//Fim metodo9
   
   public static double metodo10(double base, int expoente)
   {//Inicio metodo10
   
      double potencia;
      if (expoente < 0) potencia = 0;
      else if (expoente == 0) potencia = 1;
      else potencia = base * metodo10(base, (expoente - 1));
      return potencia;
      
   }//Fim metodo10
   
   public static long fibonacci(int termo)
   {//Inicio metodo11
   
      long result;
      if (termo < 1) result = 0;
      else if (termo == 1 || termo == 2) result = 1;
      else result = fibonacci(termo - 1) + fibonacci(termo - 2);
      return result; 
      
   }//Fim metodo11
   
   public static void decrescente(int n)
   {//Inicio metodo12
   
      if ( n < 0) return;
      System.out.print( n + ", ");
      decrescente(n - 1);
      
   }//Fim metodo12
   
   public static int somaNcubos(int n)
   {
      int soma;
      if (n == 1) soma = 1;
      else soma = n^3 + somaNcubos(n -1);
      return soma;
   
   }   
}//Fim classe solucoes   