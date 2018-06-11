import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculadora
{//Inicio Calculadora
    public static void main(String[]args)
    {//Inicio main
        boolean continuaLaco = true; 
        do{
            try{
            operacoes(menu());
            }
            catch(InputMismatchException inputMismatchException){
                System.out.println("Valor inserido é Inválido!");
                System.out.println("Faça novamente: \n");
            } 
            catch(ArithmeticException arithmeticException){
                System.out.println("Erro! Divisão por zero!\n");
            }
            catch(OpcaoNaoDefinida opcaoNaoDefinida){
                System.out.println("Essa operação não existe!");
            }   
        }while(continuaLaco);
    }//Fim main 

    public static int menu()
    {//Fim menu
        Scanner ler = new Scanner(System.in);
        System.out.print(
            "\n\tMenu Calculadora" +
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

    public static void operacoes(int op) throws OpcaoNaoDefinida
    {//Inicio operacoes
        System.out.print("Digite o primeiro operando: ");
        double num1 = leReal();
        System.out.print("Digite o segundo operando: ");
        double num2 = leReal();
        switch (op)
        {//Inicio switch
            case 0:
                break;
            case 1:
                imprimeSoma(num1,num2);
                break;
            case 2:
                imprimeSubtracao(num1,num2);
                break;
            case 3:
                imprimeMultiplicacao(num1, num2);
                break;
            case 4:   
                imprimeDivisao(num1, num2);  
                break;
            default:
                throw new OpcaoNaoDefinida();
        }//Fim switch
    }//Fim operacoes


    public static double leReal() throws InputMismatchException
    {//Inicio leReal
        Scanner ler = new Scanner(System.in);
        double real = ler.nextDouble();
        return real;
    }//Fim leReal

    public static double soma(double num1, double num2){
        return num1 + num2;
    }//Fim soma 

    public static void imprimeSoma(double num1, double num2){
        System.out.printf("%.2f + %.2f = %.2f\n", num1, num2, soma(num1,num2));
    }//Fim imprimeSoma 

    public static double subtrai(double num1, double num2){
        return num1 - num2;
    }//Fim subtrai

    public static void imprimeSubtracao(double num1, double num2){
        System.out.printf("%.2f - %.2f = %.2f\n", num1, num2, subtrai(num1,num2));
    }//Fim imprimeSubtracao

    public static double multiplica(double num1, double num2){
        return num1 * num2;
    }//Fim multiplica

    public static void imprimeMultiplicacao(double num1, double num2){
        System.out.printf("%.2f x %.2f = %.2f\n", num1, num2, multiplica(num1,num2));
    }//Fim imprimeMultiplicacao 

    public static double divide(double num1, double num2) throws ArithmeticException{
        if(num2 == 0) throw new ArithmeticException();
        return num1 / num2;
    }//Fim divide

    public static void imprimeDivisao(double num1, double num2){
        System.out.printf("%.2f / %.2f = %.2f\n", num1, num2, divide(num1,num2));
    }//Fim imprimeDivisao
}//Fim classe Calculadora 

class OpcaoNaoDefinida extends Exception {
    @Override
    public String getMessage(){
        return "Opção inexistente!";
    }
}