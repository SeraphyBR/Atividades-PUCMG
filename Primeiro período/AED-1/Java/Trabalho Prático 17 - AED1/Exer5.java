import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;

public class Exer5
{//Inicio classe Exer5 
    public static void main(String[] args)
    {//Inicio main 
        try{
            InputStream is = new FileInputStream("exemplo.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String str = br.readLine(); // lê a primeira linha
            while (str!= null) {
                System.out.println(str);
                str = br.readLine();
            }
            br.close();
        }
        catch(IOException ioexception){
            System.err.println(ioexception);
        }    
    }//Fim main 

}//Fim classe Exer5 