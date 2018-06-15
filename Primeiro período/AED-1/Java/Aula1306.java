import java.io.File;
import java.io.IOException;

public class Aula1306
{//Inicio classe Aula1306
   public static void main(String[]args)
   {//Inicio main 
      File arquivo = new File("exemplo.txt");
      if(arquivo.exists())
      {//Inicio if
      
         System.out.println("Nome: " + arquivo.getName());
         System.out.println("Tamanho: " + arquivo.length());
         System.out.println("Diretorio: " + arquivo.getPath());
      
      }//Fim if 
      else
      {//Inicio else
      
         System.out.println("Arquivo ainda não foi criado!");
         
         try{
            if(arquivo.createNewFile()) System.out.println("O arquivo foi criado!");
            else System.out.println("Arquivo existente!");
         }
         catch(IOException ioException){
            System.out.print(ioException);
         }
      }//Fim else
   
   }//Fim main
}//Fim classe Aula1306
z