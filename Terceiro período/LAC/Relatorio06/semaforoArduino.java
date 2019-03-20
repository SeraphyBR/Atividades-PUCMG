import java.io.*;

public class semaforoArduino
{//Inicio classe semaforoArduino
    public static void main (String[] args)
    {//Inicio main
        short time = 1000;
        byte piscaVerm = 3;
        byte piscaAma = 2;
        byte piscaVerd = 4;
        String porta = "COM5";
        try{
            while(true){
                for(byte c = 0; c < piscaVerm; c++){
                    enviaEstado(0, porta);
                    Thread.sleep(time);
                    enviaEstado(1, porta);
                    Thread.sleep(time);  
                } 
                for(byte c = 0; c < piscaVerd; c++){
                    enviaEstado(2, porta);
                    Thread.sleep(time);
                    enviaEstado(3, porta);
                    Thread.sleep(time);  
                } 
                for(byte c = 0; c < piscaAma; c++){
                    enviaEstado(4, porta);
                    Thread.sleep(time);
                    enviaEstado(5, porta);
                    Thread.sleep(time);  
                } 
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }//Fim main

    public static void enviaEstado(int estado, String porta)
    {//Inicio enviaEstado
        Process p;
        ProcessBuilder pb;
        try{
            pb = new ProcessBuilder("envia.exe", porta, Integer.toString(estado));
            p = pb.start();
            p.waitFor( ); 
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }//Fim enviaEstado
}//Fim classe semaforoArduino
