import java.io.*;

public class ulac
{//Begin classe ulac

    private RandomAccessFile program;
    private RandomAccessFile bin;

    public static void main (String[] args)
    {//Begin main 
        switch(args.length)
        {
            case 0:
                System.out.println("Missing parameters!");
                System.out.println("Run 'ulac -h' for information.");
                break;
            case 1:
                if (args[0] == "-h") getHelp();
                else if (args[0] == "-p") System.out.println("Missing parameters!");
                else System.out.println("Unknown parameter!\nRun 'ulac -h' for information");
                break;
            case 2:
                if (args[0] == "-c") executionStatus(compile(args[1]));
                else if (args[0] == "-r" || args[0] == "-e") System.out.println("You must specify the arduino port!");
                break;
            case 4:
                switch(args[0]){
                    case "-e":
                        if (args[2] == "-p") run(args[1], args[3]);
                        else System.out.println("This parameter is not expected, or does not exist!");
                        break;
                    case "-r":
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }//End main

    private static void getHelp(){
        System.out.println(
                "Usage: ulac [Options] file.[ula,hex]\n" + 
                "Options: \n" + 
                "-h Display this information.\n" + 
                "-c Compile code to hex.\n" +
                "-e Run code to Arduino.\n" +
                "-p Arduino Port\n" +
                "-r Compile and Run code to Arduino\n"
        );
    }

    private static void executionStatus(byte executionCode)
    {//Begin executionStatus
        switch(executionCode){
            case 0:
                break;
            default:
                break;
        }

    }//End executionCode

    private static byte compile(String filename){
        byte executionCode = 0;
        return executionCode;
    }

    private static byte run(String filename, String port){
        byte executionCode = 0;
        return executionCode;
    }

    private static void sendArduino(String val, String port)
    {//Begin sendArduino
        Process p;
        ProcessBuilder pb;
        try{
            pb = new ProcessBuilder("envia.exe", port, val);
            p = pb.start();
            p.waitFor( ); 
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }//End sendArduino   

}//End class ulac 
