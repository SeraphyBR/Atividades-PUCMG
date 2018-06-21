import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Exer6
{//Inicio classe Exer6 
    public static void main(String[] args)
    {//Inicio main 
        BufferedWriter bw = null;
        BufferedReader br = null;
        try{
            OutputStream os = new FileOutputStream("exemplo.txt", true);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
            bw.write("\nEndereço:");
            bw.write("\nLua, Cratera Aristoteles");
            InputStream is = new FileInputStream("exemplo.txt");
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String str = br.readLine(); // lê a primeira linha   
            while (str != null){
                System.out.println(str);
                str = br.readLine();
            }
        }
        catch(IOException ioexception){
            System.err.println(ioexception);
        }
        finally{
            try{
                bw.close();
                br.close();
            }
            catch(IOException ioException2){
                System.err.println(ioException2);
            }
        }

    }//Fim main 

}//Fim classe Exer6 