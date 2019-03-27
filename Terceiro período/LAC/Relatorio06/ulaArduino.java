import java.io.*;

public class ulaArduino
{
    public static void main (String[] args) throws Exception
    {
        Process p;
        ProcessBuilder pb;
        int tempo = 500;
        String input;
        Long start_time;
        Long diff_time;

        pb = new ProcessBuilder("envia.exe", args[0], args[1]);
        p = pb.start();
        start_time = System.nanoTime();
        p.waitFor( );
        diff_time = (System.nanoTime() - start_time)/1000000;
        System.out.println("atraso=" + diff_time + " ms" + " -- O que foi enviado: envia.exe com... " + args[1]);
    }
}
