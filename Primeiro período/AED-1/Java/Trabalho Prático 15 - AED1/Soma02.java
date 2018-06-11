import java.util.Scanner;
import java.util.InputMismatchException;

public class Soma02
{//Inicio classe Exer01
    public static void main(String[]args)
    {//Inicio main 
        double num1 = 0, num2 = 0;
        boolean continuaLaco = true;

        System.out.println("O programa calcula a soma de dois Números reais.\n");
        do{
            try
            {//Inicio try
                System.out.print("Digite o primeiro número: ");
                num1 = leReal();
                continuaLaco = false;
            }//Fim try 
            catch(InputMismatchException inputMismatchException){
                System.out.println("Valor inserido não compativel, digite novamente.");
            }//Fim catch
        }while(continuaLaco);

        do{
            try{//Inicio try
                continuaLaco = true;
                System.out.print("Digite o segundo número: ");
                num2 = leReal();
                continuaLaco = false;
            }//Fim try 
            catch(InputMismatchException inputMismatchException){
                System.out.println("Valor inserido não compativel, digite novamente.");
            }//Fim catch 
        }while(continuaLaco);
        System.out.println("Soma = ");
        imprimeValor(soma(num1, num2));
    }//Fim main 

    public static double leReal() throws InputMismatchException
    {//Inicio leReal
        Scanner ler = new Scanner(System.in);
        double real = ler.nextDouble();
        return real;
    }//Fim leReal

    public static double soma(double num1, double num2){
        return num1 + num2;
    }

    public static void imprimeValor(double num){
        System.out.print(num);
    }
}//Inicio classe Exer01 