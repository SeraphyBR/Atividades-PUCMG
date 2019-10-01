public class Exercicio6
{//Inicio Classe
   public static void main(String[]args)
   {//Inicio main
   
      metodo6(0); 
            
   }//Fim main
   
   public static void metodo6(int num) 
   {//Inicio metodo6
   
      if (num == 5) return;
      num++;
      System.out.print(num + ", ");
      metodo6(num);
      System.out.print(num + ", ");
      num--; 
   }//Fim metodo6
         
 
  
}//Fim classe
   
