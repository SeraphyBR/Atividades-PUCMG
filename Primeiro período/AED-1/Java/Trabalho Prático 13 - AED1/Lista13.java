
import java.util.Scanner;

public class Lista13
{//Inicio classe Exer01
    public static void main(String[]args)
    {//Inicio main
        Triangulo[] tri = new Triangulo[100];
        menu(tri);
    }//Fim main

    public static void menu(Triangulo[] tri)
    {//Inicio menu
        Scanner leia = new Scanner(System.in);
        boolean executando = true;
        while(executando)
        {//Inicio while executando
            System.out.printf(
                "\n\t MENU DOS TRIANGULOS\n" +
                "0 - Sair do programa\n"   +
                "1 - Criar um triângulo\n" +
                "2 - Listar Triângulos\n"  +
                "3 - Triângulos Iguais\n"  +
                "4 - Listar os triângulos de um determinado tipo\n" +
                "5 - Verificar inconsistências\n" +
                "\n=> "
            );
            int opcao = leia.nextInt(); 
            switch(opcao)
            {//Inicio switch
                case 0:
                    executando = false;
                    break;
                case 1: 
                    criaTriangulo(tri);
                    break;
                case 2:
                    listaTriangulos(tri);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    break;                        

            }//Fim switch
        }//Fim while executando
    }//Fim menu

    public static void criaTriangulo(Triangulo[] tri)
    {//Inicio criaTriangulo
        int i = Triangulo.instancias;
        if(i < tri.length){
            tri[i] = new Triangulo();
            tri[i].leLados();
        }
        else System.out.println("Erro! Limite alcançado");
    }//Fim criaTriangulo

    public static void listaTriangulos(Triangulo[] tri)
    {//Inicio listaTriangulos
        int i = Triangulo.instancias;
        for(int cont = 0; cont < i; cont++)
        {//Inicio for
            System.out.println(
                "Triangulo " + cont + ":" +
                "\n\tLado A: " + tri[cont].getA() + 
                "\n\tLado B: " + tri[cont].getB() +
                "\n\tLado C: " + tri[cont].getC() +
                "\n\tPerimetro: " + tri[cont].perimetro() + "\n"
            );
        }//Fim for
    }//Inicio listaTriangulos

}//Fim classe Exer01 

class Triangulo
{//Inicio classe Triangulo
    //Lados do Triangulo
    private double ladoA;
    private double ladoB;
    private double ladoC;

    public static int instancias = 0;

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
        Scanner ler = new Scanner(System.in);
        double lado1, lado2, lado3;

        System.out.print("Digite o lado A: ");
        lado1 = ler.nextDouble();

        System.out.print("Digite o lado B: ");
        lado2 = ler.nextDouble();
            
        System.out.print("Digite o lado C: ");
        lado3 = ler.nextDouble();

        setA(lado1);
        setB(lado2);
        setC(lado3);
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