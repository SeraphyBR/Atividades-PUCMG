import java.util.Scanner;
import java.util.InputMismatchException;

public class Soma01
{//Inicio classe Exer01
    public static void main(String[]args)
    {//Inicio main 
        double num1 = 0, num2 = 0;
        Scanner ler = new Scanner(System.in);
        boolean continuaLaco = true;
        System.out.println("O programa calcula a soma de dois Números reais.\n");
        do{
            try
            {//Inicio try
                System.out.print("Digite o primeiro número: ");
                num1 = ler.nextDouble();
                continuaLaco = false;
            }//Fim try 
            catch(InputMismatchException inputMismatchException){
                System.out.println("Valor inserido não compativel, digite novamente.");
                ler.nextLine();
            }//Fim catch
        }while(continuaLaco);
        do{
            try{//Inicio try
                continuaLaco = true;
                System.out.print("Digite o segundo número: ");
                num2 = ler.nextDouble();
                continuaLaco = false;
            }//Fim try 
            catch(InputMismatchException inputMismatchException){
                System.out.println("Valor inserido não compativel, digite novamente.");
                ler.nextLine();//Limpar Buffer
            }//Fim catch 
        }while(continuaLaco);
        
        System.out.printf("\nA soma eh: %.2f \n",num1 + num2);
    }//Fim main 

}//Inicio classe Exer01 