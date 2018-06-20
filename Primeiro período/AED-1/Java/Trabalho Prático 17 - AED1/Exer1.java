
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader; 
public class Exer1
{
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nomeArquivo;
        System.out.printf("Digite o nome do arquivo: ");
        try{
            nomeArquivo = br.readLine();
        }
        catch(){
            
        }


        File arquivo = new File("exemplo.txt");
        try{
            if(arquivo.createNewFile()){
                System.out.println("Foi criado o arquivo exemplo.txt");
            }
        }
        catch(IOException ioException)
        {
            System.out.print(ioException);
        }
        if(arquivo.exists()){
            System.out.println("Nome: " + arquivo.getName());
            System.out.println("Tamanho: " + arquivo.length());
            System.out.println("Diretório: "+ arquivo.getPath());
        }
        else {
            System.out.println("Arquivo inexistente.");
        }
    }



}