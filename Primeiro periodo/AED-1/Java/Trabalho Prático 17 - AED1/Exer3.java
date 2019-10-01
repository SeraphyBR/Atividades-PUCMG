import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Exer3
{//Inicio classe Exer3
    public static void main(String[] args)
    {//Inicio main
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Digite o nome do arquivo a ser impresso: ");
        String nome = "";
        try{
            nome = br.readLine();
        }
        catch(IOException ioException){
            System.out.print("Erro de leitura do teclado!");
        }
        File arquivo = new File(nome);
        try(FileReader fr= new FileReader(arquivo)){
            int  c = fr.read();
            while( c != -1){
                System.out.print( (char) c );
                c = fr.read();
            } 
        } 
        catch(IOException ioException)
        { 
            System.out.print(ioException);
        }
    }//Fim main 
}//Fim classe Exer3 