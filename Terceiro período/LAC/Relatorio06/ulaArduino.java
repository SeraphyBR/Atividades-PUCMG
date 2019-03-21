import java.io.*;

public class ulaArduino
{//Inicio classe ulaArduino
    public static void main (String[] args)
    {//Inicio main
        String porta = "COM5";
        String entrada = args[0];
        int result = 0, vaiUm = 0;
        char x = entrada.charAt(0);
        char y = entrada.charAt(1);
        boolean a = charToBool(x);
        boolean b = charToBool(y);
        int op = Character.getNumericValue(entrada.charAt(2));
        switch(op){
            case 0:
                if(a && b) result = 1;
                break;
            case 1:
                if(a || b) result = 1;
                break;
            case 2:
                if(a == true) result = 0;
                else result = 1;
                break;
            case 3:
                if(a != b){
                    result = 1;
                }
                else{
                    result = 0;
                    vaiUm = 1;
                }
                break;
            default:
                result = 0;
                vaiUm = 0;
                break;
        }
        //System.out.println(x + "" + y + "" + result + "" + vaiUm);
        enviaValores(x + "" + y + "" + result + "" + vaiUm, porta);

    }//Fim main

    private static boolean charToBool(char c){
        boolean b = true;
        if (c == '0') b = false;
        return b;
    }

    private static void enviaValores(String val, String porta)
    {//Inicio enviaValores
        Process p;
        ProcessBuilder pb;
        try{
            pb = new ProcessBuilder("envia.exe", porta, val);
            p = pb.start();
            p.waitFor( ); 
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }//Fim enviaValores
}//Fim classe ulaArduino  
