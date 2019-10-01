import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.io.Console;
/**
 * @author SeraphyBR (Luiz Junio Veloso Dos Santos)
 * @version 1.0
 */
public class ulac
{//Begin classe ulac

    private static RandomAccessFile program;
    private static RandomAccessFile bin;

    /**
     * Main method that checks the arguments passed and performs 
     * the instructions accordingly, terminating the application 
     * with its error code or success of the operation performed.
     * */
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
                        else if(args[2].equals("-r")) exitCode = executionStatus(compileAndRun(args[3], args[1], false));
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
                switch(args[p]){
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
                        else if(args[p + 2].equals("-r")) exitCode = executionStatus(compileAndRun(args[p + 3], args[p + 1], true));
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

    /**
     * Method that receives a value and shows its respective error or success message.
     * @param returnCode The return code of a method
     * @return The int received
     */
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
            case 8:
                System.out.println("Something wrong happened!");
                break;
            case 9:
                System.out.println("Is missing 'inicio:'");
                break;
            case 10:
                System.out.println("File does not have .hex extension!");
                break;
            default:
                break;
        }
        return returnCode;
    }//End returnCode

    /**
     * Method that prints the help screen.
     * */
    private static void getHelp()
    {//Begin getHelp
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
    }//End getHelp

    /**
     * @param mnemonic The statement to be verified
     * @return A char representing the instruction to be sent to the Arduino
     * */
    private static char instructionToHex(String mnemonic)
    {//Begin instructionToHex
        char hex = ' ';
        switch(mnemonic){
            case "zeroL;":
                hex = '0';
                break;
            case "umL;":
                hex = '1';
                break;
            case "An;":
                hex = '2';
                break;
            case "Bn;":
                hex = '3';
                break;
            case "AouB;":
                hex = '4';
                break;
            case "AeB;":
                hex = '5';
                break;
            case "AxorB;":
                hex = '6';
                break;
            case "AnandB;":
                hex = '7';
                break;
            case "AnorB;":
                hex = '8';
                break;
            case "AxnorB;":
                hex = '9';
                break;
            case "AnouB;":
                hex = 'A';
                break;
            case "AouBn;":
                hex = 'B';
                break;
            case "AneB;":
                hex = 'C';
                break;
            case "AeBn;":
                hex = 'D';
                break;
            case "AnouBn;":
                hex = 'E';
                break;
            case "AneBn;":
                hex = 'F';
                break;
        }
        return hex;
    }//End instructionToHex

    /**
     * I method that read the .ula code and generates a .hex file containing 
     * the arduino instructions.
     * @param filename Filename with .ula extension
     * @return Return code representing the error or success of the operation
     * */
    private static int compile(String filename)
    {//Begin compile
        int returnCode = 0;
        if(filename.contains(".ula")){
            try{
                String line;
                char a, b, instruction;
                program = new RandomAccessFile(filename, "r");
                bin = new RandomAccessFile(filename.replace(".ula", ".hex"), "rw");
                if(program.readLine().equals("inicio:")){
                    a = b = instruction = ' ';
                    while((line = program.readLine()) != null && !line.equals("fim.")){
                        if(line.contains("=")){
                            if(line.charAt(0) == 'A') a = line.charAt(2);
                            else if (line.charAt(0) == 'B') b = line.charAt(2);
                        }
                        else{
                            instruction = instructionToHex(line);
                            if (a != ' ' && b != ' ' && instruction != ' '){
                                bin.writeUTF(a + "" + b + "" + instruction + "\n");
                            }
                        }
                    }
                }
                else returnCode = 9;
            }
            catch(FileNotFoundException ex){
                returnCode = 6;
            }
            catch(Exception ex){
                ex.printStackTrace();
                returnCode = 8;
            }
        }
        else returnCode = 7;
        return returnCode;
    }//End compile

    /**
     * Method that read instructions in .hex and send to arduino.
     * @param filename Filename with .hex extension
     * @param port Serial port that is connected to the Arduino
     * @param stepByStep Enable step-by-step sending, with enter
     * @return Return code representing the error or success of the operation
     * */   
    private static int run(String filename, String port, boolean stepByStep){
        int returnCode = 0;
        if(filename.contains(".hex")){
            try{
                String line;
                Console c = System.console();
                Process p;
                ProcessBuilder pb = new ProcessBuilder();
                bin = new RandomAccessFile(filename, "r");
                while((line = bin.readUTF()) != null){
                    if(stepByStep){
                        c.format("Press ENTER to send: " + line);
                        c.readLine();
                    }
                    pb.command("envia.exe", port, line);
                    p = pb.start();
                    p.waitFor();
                }
            }
            catch(FileNotFoundException ex){
                returnCode = 6;
            }
            catch(Exception ex){
                returnCode = 8;
            }
        }
        else returnCode = 10;
        return returnCode;
    }

    /**
     * Method that read the .ula code, generates the .hex file containing 
     * the arduino instructions and sends them to the arduino.
     * @param filename Filename with .ula extension 
     * @param port Serial port that is connected to the Arduino
     * @param stepByStep Enable step-by-step sending, with enter  
     * @return Return code representing the error or success of the operation
     * */  
    private static int compileAndRun(String filename, String port, boolean stepByStep){
        int returnCode = compile(filename);
        if (returnCode == 0) returnCode = run(filename.replace(".ula", ".hex"), port, stepByStep);
        return returnCode;
    }

}//End class ulac 
