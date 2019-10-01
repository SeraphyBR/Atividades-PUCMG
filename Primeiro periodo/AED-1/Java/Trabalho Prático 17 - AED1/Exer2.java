import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exer2
{//Inicio classe Exer2 
    public static void main(String[] args)
    {//Inicio main 
        File arquivo = new File("exemplo.txt");
        try(FileWriter fw = new FileWriter(arquivo)){
            fw.write("Luiz Junio\n");
            fw.write("624037\n");
            fw.write("31989300801\n");
            fw.write("luisjuniorbr@gmail.com\n");
            fw.flush();
        }
        catch(IOException ioException){
            System.out.print(ioException);
        }
    }//Fim main 

}//Fim classe Exer2 