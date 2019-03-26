import java.io.*;

public class ulac
{//Begin classe ulac

    private static RandomAccessFile program;
    private static RandomAccessFile bin;

    public static void main (String[] args)
    {//Begin main
        int exitCode = 0;
        switch(args.length)
        {//Begin switch args.length
            case 0:
                exitCode = executionStatus(2);
                break;
            case 1:
                if (args[0].equals("-h")) getHelp();
                else if (args[0].equals("-s")) exitCode = executionStatus(2);  
                else exitCode = executionStatus(4);
                break;
            case 2:
                if (args[0].equals("-c")) exitCode = executionStatus(compile(args[1]));
                else if (args[0].equals("-r") || args[0].equals("-e")) exitCode = executionStatus(5);
                break;
            case 4:
                switch(args[0]){
                    case "-e":
                        if (args[2].equals("-p")) exitCode = executionStatus(run(args[1], args[3], false));
                        else exitCode = executionStatus(1); 
                        break;
                    case "-r":
                        if (args[2].equals("-p")) exitCode = executionStatus(compileAndRun(args[1], args[3], false));
                        else exitCode = executionStatus(1);  
                        break;
                    case "-p":
                        if(args[2].equals("-e")) exitCode = executionStatus(run(args[3], args[1], false));
                        else if(args[2] == "-r") exitCode = executionStatus(compileAndRun(args[3], args[1], false));
                        else exitCode = executionStatus(1);   
                        break;
                    default:
                        exitCode = executionStatus(1);   
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
                        if (args[p + 2].equals("-p")) exitCode = executionStatus(run(args[p + 1], args[p + 3], true));
                        else exitCode = executionStatus(1); 
                        break;
                    case "-r":
                        if (args[p + 2].equals("-p")) exitCode = executionStatus(compileAndRun(args[p + 1], args[p + 3], true));
                        else exitCode = executionStatus(1); 
                        break;
                    case "-p":
                        if(args[p + 2].equals("-e")) exitCode = executionStatus(run(args[p + 3], args[p + 1], true));
                        else if(args[p + 2] == "-r") exitCode = executionStatus(compileAndRun(args[p + 3], args[p + 1], true));
                        else exitCode = executionStatus(1);  
                        break;
                    default:
                        exitCode = executionStatus(1);  
                        break;
                } 
                break;
            default:
                exitCode = executionStatus(3);
                break;
        }//End switch args.length
        System.exit(exitCode);
    }//End main
    
    private static int executionStatus(int returnCode)
    {//Begin executionStatus
        switch(returnCode){
            case 0:
                System.out.println("done!");
                break; 
            case 1: 
                System.out.println("This parameter is not expected, or does not exist!");  
                break;
            case 2:
                System.out.println("Missing parameters!\nRun 'ulac -h' for information.");  
                break;     
            case 3:  
                System.out.println("Error in the parameters!\nRun 'ulac -h' for information.");  
                break;
            case 4:
                System.out.println("Unknown parameter!\nRun 'ulac -h' for information.");  
                break;
            case 5: 
                System.out.println("You must specify the arduino port!"); 
                break;
            case 6:
                System.out.println("File not found!");
                break;
            case 7:
                System.out.println("File does not have .ula extension!");
                break;
            default:
                break;
        }
        return returnCode;
    }//End returnCode

    private static void getHelp(){
        System.out.println(
                "Usage: ulac [Options] file.[ula,hex]\n" + 
                "Options: \n" + 
                "-h\tDisplay this information.\n" + 
                "-c\tCompile code to hex.\n" +
                "-e\tRun code to Arduino.\n" +
                "-s\tRun instruction step by step (Use on Begin/End of options)\n" +
                "-p\tArduino Port\n" +
                "-r\tCompile and Run code to Arduino\n" + 
                "\nExamples:\n" +
                "Just compile: ulac -c file.ula\n" +
                "Run code in Arduino: ulac -e file.hex"
                );
    }

    private static int compile(String filename){
        int returnCode = 0;
        if(filename.contains(".ula")){
            try{
                program = new RandomAccessFile(filename, "r");
            }
            catch(FileNotFoundException ex){
                returnCode = 6;
            }  
        }
        else returnCode = 7;
        return returnCode;
    }

    private static int run(String filename, String port, boolean stepByStep){
        int returnCode = 0;
        return returnCode;
    }

    private static int compileAndRun(String filename, String port, boolean stepByStep){
        int returnCode = 0;
        return returnCode;
    }

    private static int sendArduino(String val, String port)
    {//Begin sendArduino
        int returnCode = 0;
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
