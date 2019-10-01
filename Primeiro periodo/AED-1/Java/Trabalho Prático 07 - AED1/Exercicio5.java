

public class Exercicio5
{//Inicio Classe
   public static void main(String[]args)
   {//Inicio main
   
      metodo5(1); 
            
   }//Fim main
   
   public static void metodo5(int num) 
   {//Inicio metodo5
   
      if(num > 10) return; 
      System.out.print(num + ", ");
      num++;
      metodo5(num);
      
   }//Fim metodo5
         
 
  
}//Fim classe
   
