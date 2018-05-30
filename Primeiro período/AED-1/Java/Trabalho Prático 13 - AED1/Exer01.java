
import java.util.Scanner;

public class Exer01
{//Inicio classe Exer01
    public static void main(String[]args)
    {//Inicio main
        Triangulo[] tri = new Triangulo[100];
        Scanner ler = new Scanner(System.in);
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
    }//Fim main

    public static void menu()
    {//Inicio menu
        System.out.printf(
            "\t MENU DOS TRIANGULOS\n" +
            "0 - Sair do programa\n" +
            "1 - Criar um triângulo\n" +
            "2 - Listar Triângulos\n" +
            "3 - Triângulos Iguais\n" +
            "4 - Listar os triângulos de um determinado tipo\n" +
            "5 - Verificar inconsistências"
        );


    }//Fim menu

}//Fim classe Exer01 

class Triangulo
{//Inicio classe Triangulo
    //Lados do Triangulo
    private double ladoA;
    private double ladoB;
    private double ladoC;

    public static int instancias = 0;

    //Instancia de Scanner para leitura de valores do teclado.
    private static Scanner ler = new Scanner(System.in);
    
    Triangulo()
    {//Construdor Vazio
        setA(0);
        setB(0);
        setC(0);
        instancias++;
    }//Fim construtor
    
    Triangulo(double ladoA, double ladoB, double ladoC)
    {//Contrutor 3 lados
        setA(ladoA);
        setB(ladoB);
        setC(ladoC); 
        instancias++;
    }//Fim construtor

    public void setA(double ladoA){
        if(ladoA < 0) this.ladoA = 0;
        else this.ladoA = ladoA;
    }//Fim setA

    public void setB(double ladoB){
        if(ladoB < 0) this.ladoB = 0;
        else this.ladoB = ladoB;
    }//Fim setB
    
    public void setC(double ladoC){
        if(ladoA < 0) this.ladoC = 0;
        else this.ladoC = ladoC;
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

    public void leLados()
    {//Inicio leLados
        double lado1, lado2, lado3;
        boolean ehErro = true;

        while(ehErro)
        {//Inicio while
            System.out.print("Digite o lado A: ");
            lado1 = ler.nextDouble();

            System.out.print("Digite o lado B: ");
            lado2 = ler.nextDouble();
            
            System.out.print("Digite o lado C: ");
            lado3 = ler.nextDouble();

            setA(lado1);
            setB(lado2);
            setC(lado3);
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