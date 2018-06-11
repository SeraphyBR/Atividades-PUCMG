import java.util.Scanner;
import java.util.InputMismatchException;

public class Exer01
{//Inicio classe Exer01
    public static void main(String[]args)
    {//Inicio main 

        double num1, num2;
        Scanner ler = new Scanner(System.in);
        boolean erro = true;
        do{
            try{
                System.out.println("O programa calcula a soma de dois Números reais.\n");
                System.out.print("Digite o primeiro número: ");
                num1 = ler.nextDouble();
                System.out.print("Digite o segundo número: ");
                num2 = ler.nextDouble();
                System.out.printf("\nA soma eh: %f \n",num1 + num2);
                erro = false;
            }
            catch(InputMismatchException inputMismatchException)
            {
                System.out.println("Valor inserido não compativel");
            }
        }while(erro);

    }//Fim main 

}//Inicio classe Exer01 