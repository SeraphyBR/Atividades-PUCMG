import java.util.Scanner;
import java.lang.Arithmetic; 


public class Calculadora
{//Inicio Calculadora
    public static void main(String[]args)
    {//Inicio main 
        try{
        menu();
    }//Fim main 

    public static int menu()
    {//Fim menu
        Scanner ler = new Scanner(System.in);
        System.out.print(
            "\tMenu Calculadora" +
            "\nDigite uma opção seguinte: " +
            "\n0 - Sair" +
            "\t1 - Adição" +
            "\n2 - Subtração" +
            "\t3 - Multiplicação" +
            "\n\t4 - Divisão" +
            "\n=> "
        );//Fim println
        int op = ler.nextInt();
        return op;
    }//Fim menu 


    public static double leReal()
    {//Inicio leReal
        boolean continuaLaco = true;
        Scanner ler = new Scanner(System.in);
        double real = 0;
        do{
            try{//Inicio try 
                real = ler.nextDouble();
                continuaLaco = false;
            }//Fim try 
            catch(InputMismatchException inputMismatchException)
            {
                System.out.print("Valor inserido não compativel! \nDigite novamente: ");
                ler.nextLine();
            }//Fim catch
        }while(continuaLaco);
        return real;
    }//Fim leReal

    public static double soma(double num1, double num2){
        return num1 + num2;
    }//Fim soma 

    public static double divide(double num1, double num2) throw Ari{
        return num1 / num2;
    }
}//Fim classe Calculadora 