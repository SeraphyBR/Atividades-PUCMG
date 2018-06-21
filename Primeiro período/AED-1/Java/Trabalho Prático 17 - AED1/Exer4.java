import java.io.File;
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class Exer4
{//Inicio main  
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite o nome do arquivo: ");
        String nome = ler.nextLine();
        lerTexto(nome);
    }

    public static void lerTexto(String nomeArq)
    {//Inicio main 
        try{ 
            File arquivo = new File(nomeArq); 
            Scanner scanner = new Scanner(arquivo); 
            while(scanner.hasNext()){ 
                System.out.print(scanner.nextLine() + "\n"); 
            } 
            scanner.close(); 
        }
        catch(FileNotFoundException fileNotFoundException){ 
            fileNotFoundException.printStackTrace(); 
        } 
    }//Fim main 
}//Fim classe Exer4 