import java.util.Scanner;

public class aula_2504
{//Inicio classe
   public static void main(String[]args)
   {//Inicio main
       
      int[][] matrix = new int[20][20];
      leMatriz(matrix);
      escreveMatriz(matrix);

   }//Fim main

   public static void escreveMatriz(int[][] matriz)
   {//Inicio escreveMatriz
      int coluna;
      
      for(int linha = 0; linha < matriz.length; linha++)
      {//Inicio for linha
              
         for(coluna = 0; coluna < matriz[linha].length ; coluna++)
         {//Inicio for coluna
         
            System.out.print(matriz[linha][coluna] + ", " );
      
         }//Fim for coluna
         
         System.out.println();
      
      }//Fim for linha
   
   }//Fim escreveMatriz
   
   public static void leMatriz(int[][] matriz)
   {//Inicio leMatriz
      int coluna;
      
      Scanner ler = new Scanner(System.in);
      System.out.println("Digite os valores para a matriz: ");
      
      for(int linha = 0; linha < matriz.length; linha++)
      {//Inicio for linha
        
         for(coluna = 0; coluna < matriz[linha].length ; coluna++)
         {//Inicio for coluna
         
            System.out.printf("Digite o valor para L = %d e C = %d: ",linha,coluna);
            matriz[linha][coluna] = ler.nextInt();
      
         }//Fim for coluna
         System.out.println();
      
      }//Fim for linha
   }//Fim leMatriz
   
}//Fim classe