
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader; 
public class Exer1
{//Inicio classe Exer1 
    public static void main(String[] args)
    {//Inicio main 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nomeArquivo = "";
        try{
            System.out.printf("Digite o nome do arquivo: ");
            nomeArquivo = br.readLine();
        }
        catch(IOException ioException){
            System.out.print("Erro ao ler o teclado!");
        }    
        File arquivo = new File(nomeArquivo);
        try{
            if(arquivo.createNewFile()){
                System.out.println("Foi criado o arquivo!");
            }
        }    
        catch(IOException ioException){
            System.out.print("Erro ao criar o arquivo!");
        }    
        if(arquivo.exists()){
            System.out.println("Nome: " + arquivo.getName());
            System.out.println("Tamanho: " + arquivo.length());
            System.out.println("Diretório: "+ arquivo.getPath());
        }
        else {
            System.out.println("Arquivo inexistente.");
        }
    }//Fim main 
}//Fim classe Exer1 