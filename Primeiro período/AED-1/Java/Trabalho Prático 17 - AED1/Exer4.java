import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class Exer4{ 
    public static void lerTexto(String nomeArq)
    {//Inicio main 
        try{ 
            File arquivo = new File(nomeArq); 
            Scanner scanner = new Scanner(arquivo); 
            while(scanner.hasNext()){ 
                System.out.print(scanner.nextLine()); 
            } 
            scanner.close(); 
        }
        catch(FileNotFoundException fileNotFoundException){ 
            fileNotFoundException.printStackTrace(); 
        } 
    }//Fim main 
}//Fim classe Exer4 