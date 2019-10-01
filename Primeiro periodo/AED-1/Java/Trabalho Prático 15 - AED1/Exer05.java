
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exer05
{//Inicio classe Exer01
    public static void main(String[]args)
    {
        Triangulo[] tri = new Triangulo[5];
        Scanner ler = new Scanner(System.in);
       try{//Inicio try 
            for(int i = 0; i < tri.length; i++)
            {//Inicio for
                tri[i] = new Triangulo();
                System.out.printf("\nValores do Triangulo %d:\n", i + 1);
                tri[i].leLados();
                System.out.println("Tipo do triângulo: " + tri[i].tipo());
            }//Fim for 

            System.out.println("Deseja comparar quais triângulos? [1..5]:");
            int op1 = ler.nextInt();
            int op2 = ler.nextInt();
            if(tri[op1 - 1].ehIgual(tri[op2 - 1])) System.out.println("Os dois Triangulos são iguais!");
            else System.out.println("Não são iguais!");
        }//Fim try 
        catch(InputMismatchException inputMismatchException){
            System.out.println("Digito incompativel!");
        }
        catch(NullPointerException nullPointerException){
            System.out.println("Não existe esse triangulo!");
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println("Posição inexistente do Array!");
        }
    }

}//Fim classe Exer01 

class Triangulo
{//Inicio classe Triangulo
    //Lados do Triangulo
    private double ladoA;
    private double ladoB;
    private double ladoC;

    //Instancia de Scanner para leitura de valores do teclado.
    private static Scanner ler = new Scanner(System.in);

    private void setA(double ladoA){
        this.ladoA = ladoA;
    }//Fim setA

    private void setB(double ladoB){
        this.ladoB = ladoB;
    }//Fim setB
    
    private void setC(double ladoC){
        this.ladoC = ladoC;
    }//Fim setC

    public double getA(){
        return this.ladoA;
    }//Fim getA

    public double getB(){
        return this.ladoB;
    }//Fim getB

    public double getC(){
        return this.ladoC;
    }//Fim getC

    public double perimetro(){//Calcula perimetro do Triangulo
        double perimetro = getA() + getB() + getC();
        return perimetro;
    }//FIm perimetro

    public int tipo()
    {//Inicio tipo 
        int tipo = 0;

        if(getA() == getB() && getB() == getC()){//Todos os lados iguais 
            tipo = 1;
        }    
        else if(getA() == getB() || getA() == getC() || getB() == getC()){//Dois dados iguais 
            tipo = 2;
        }
        else tipo = 3;

        return tipo;// 1=Equilátero; 2=Isóscele; 3=Escaleno
    }//Fim tipo 

    public void leLados() throws InputMismatchException
    {//Inicio leLados
        double lado1, lado2, lado3;
        boolean ehErro = true;

        while(ehErro)
        {//Inicio while
            System.out.print("Digite o lado A: ");
            do{
                lado1 = ler.nextDouble();
            }while(lado1 <= 0);

            System.out.print("Digite o lado B: ");
            do{
                lado2 = ler.nextDouble();
            }while(lado2 <= 0);

            System.out.print("Digite o lado C: ");
            do{
                lado3 = ler.nextDouble();
            }while(lado3 <= 0);

            if(ehTrianguloValido(lado1, lado2, lado3))
            {//Inicio if 
                setA(lado1);
                setB(lado2);
                setC(lado3);
                ehErro = false;
            }//Fim if 
            else System.out.println("Os valores inseridos não correspondem a um triângulo!");
        }//Fim while         
    }//Fim leLados

    public static boolean ehTrianguloValido(double A, double B, double C)
    {//Inicio ehTrianguloValido
        /*
        Para construir um triângulo é necessário que a medida de 
        qualquer um dos lados seja menor que a soma das medidas 
        dos outros dois e maior que o valor absoluto da diferença 
        entre essas medidas.
        */
        boolean caso1 = Math.abs(B - C) < A && A < (B + C);
        boolean caso2 = Math.abs(A - C) < B && B < (A + C);
        boolean caso3 = Math.abs(A - B) < C && C < (A + B);

        return (caso1 && caso2 && caso3);
    }//Fim ehTrianguloValid

    public boolean ehIgual(Triangulo outro)
    {//Inicio ehIgual
        boolean caso1 = this.ladoA == outro.ladoA;
        boolean caso2 = this.ladoB == outro.ladoB;
        boolean caso3 = this.ladoC == outro.ladoC;

        return (caso1 && caso2 && caso3);
    }//Fim ehIgual
}//Fim classe Triangulo