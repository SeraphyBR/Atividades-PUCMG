//Autor: Luiz Junio <luisjuniorbr@gmail.com>
import java.util.Scanner;
import java.util.InputMismatchException;

public class Soma03
{//Inicio classe Exer01
    public static void main(String[]args)
    {//Inicio main 
        double num1 = 0, num2 = 0;
        System.out.println("O programa calcula a soma de dois Números reais.\n");
        System.out.print("Digite o primeiro número: ");
        num1 = leReal();
        System.out.print("Digite o segundo número: ");
        num2 = leReal();
        System.out.println("Resultado: ");
        imprimeSoma(num1, num2);
    }//Fim main 

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

    public static void imprimeSoma(double num1, double num2){
        System.out.printf("%.2f + %.2f = %.2f", num1, num2, soma(num1,num2));
    }//Fim imprimeSoma 
    
}//Inicio classe Exer01 