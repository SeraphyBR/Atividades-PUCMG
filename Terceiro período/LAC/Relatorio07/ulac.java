import java.io.*;

public class ulac
{//Begin classe ulac

    private RandomAccessFile program;
    private RandomAccessFile bin;

    public static void main (String[] args)
    {//Begin main
        switch(args.length)
        {//Begin switch args.length
            case 0:
                System.out.println("Missing parameters!");
                System.out.println("Run 'ulac -h' for information.");
                break;
            case 1:
                if (args[0].equals("-h")) getHelp();
                else if (args[0].equals("-s")) System.out.println("Missing parameters!\nRun 'ulac -h' for information.");
                else System.out.println("Unknown parameter!\nRun 'ulac -h' for information.");
                break;
            case 2:
                if (args[0].equals("-c")) executionStatus(compile(args[1]));
                else if (args[0].equals("-r") || args[0].equals("-e")) System.out.println("You must specify the arduino port!");
                break;
            case 4:
                switch(args[0]){
                    case "-e":
                        if (args[2].equals("-p")) executionStatus(run(args[1], args[3], false));
                        else System.out.println("This parameter is not expected, or does not exist!");
                        break;
                    case "-r":
                        if (args[2].equals("-p")) executionStatus(compileAndRun(args[1], args[3], false));
                        else System.out.println("This parameter is not expected, or does not exist!");  
                        break;
                    case "-p":
                        if(args[2].equals("-e")) executionStatus(run(args[3], args[1], false));
                        else if(args[2] == "-r") executionStatus(compileAndRun(args[3], args[1], false));
                        else System.out.println("This parameter is not expected, or does not exist!");  
                        break;
                    default:
                        System.out.println("This parameter is not expected, or does not exist!");  
                        break;
                }
                break;
            case 5:
                int p = 0;
                String arg = args[0];
                if (arg.equals("-s")) p = 1;
                else if (!args[4].equals("-s")) arg = " "; 
                switch(arg){
                    case "-e":
                        if (args[p + 2].equals("-p")) executionStatus(run(args[p + 1], args[p + 3], true));
                        else System.out.println("This parameter is not expected, or does not exist!");
                        break;
                    case "-r":
                        if (args[p + 2].equals("-p")) executionStatus(compileAndRun(args[p + 1], args[p + 3], true));
                        else System.out.println("This parameter is not expected, or does not exist!");  
                        break;
                    case "-p":
                        if(args[p + 2].equals("-e")) executionStatus(run(args[p + 3], args[p + 1], true));
                        else if(args[p + 2] == "-r") executionStatus(compileAndRun(args[p + 3], args[p + 1], true));
                        else System.out.println("This parameter is not expected, or does not exist!");  
                        break;
                    default:
                        System.out.println("This parameter is not expected, or does not exist!");  
                        break;
                } 
                break;
            default:
                System.out.println("Error in the parameters!\nRun 'ulac -h' for information.");
                break;
        }//End switch args.length
    }//End main

    private static void getHelp(){
        System.out.println(
                "Usage: ulac [Options] file.[ula,hex]\n" + 
                "Options: \n" + 
                "-h\tDisplay this information.\n" + 
                "-c\tCompile code to hex.\n" +
                "-e\tRun code to Arduino.\n" +
                "-s\tRun instruction step by step (Use on Begin/End of options)\n" +
                "-p\tArduino Port\n" +
                "-r\tCompile and Run code to Arduino\n"
                );
    }

    private static void executionStatus(byte returnCode)
    {//Begin executionStatus
        switch(returnCode){
            case 0:
                break;
            default:
                break;
        }

    }//End returnCode

    private static byte compile(String filename){
        byte returnCode = 0;
        return returnCode;
    }

    private static byte run(String filename, String port, boolean stepByStep){
        byte returnCode = 0;
        return returnCode;
    }

    private static byte compileAndRun(String filename, String port, boolean stepByStep){
        byte returnCode = 0;
        return returnCode;
    }

    private static byte sendArduino(String val, String port)
    {//Begin sendArduino
        byte returnCode = 0;
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
        return returnCode;
    }//End sendArduino   

}//End class ulac 
