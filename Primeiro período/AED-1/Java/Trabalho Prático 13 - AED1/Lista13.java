//Autor: Luiz Junio <luisjuniorbr@gmail.com>
//Data:  30-05-2018
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
                    triangulosIguais(tri);
                    break;
                case 4:
                    listaTriangulos(tri, escolheTipo());
                    break;
                case 5:
                    listaTriangulosInvalidos(tri);
                    break;
                default:
                    break;

            }//Fim switch
        }//Fim while executando
        leia.close();
    }//Fim menu

    public static int escolheTipo()
    {//Inicio escolheTipo
        int tipo;
        boolean erro;
        Scanner ler = new Scanner(System.in);
        System.out.println("Qual o tipo de Triangulo a ser listado?");
        System.out.println("1=Equilátero; 2=Isóscele; 3=Escaleno");
        System.out.print("\n=> ");
        do{
            tipo = ler.nextInt();
            erro = tipo < 1 || tipo > 3;
            if(erro) System.out.print("Tipo não existente!\n=> ");
        }while(erro);

        return tipo;
    }//Fim escolheTipo

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
                    "Triangulo " + (cont + 1) + ":" +
                    "\n\tLado A: " + tri[cont].getA() +
                    "\n\tLado B: " + tri[cont].getB() +
                    "\n\tLado C: " + tri[cont].getC() +
                    "\n\tPerimetro: " + tri[cont].perimetro() + "\n"
                    );
        }//Fim for
    }//FIm listaTriangulos

    public static void listaTriangulos(Triangulo[] tri, int tipo)
    {//Inicio listaTriangulos tipo
        int i = Triangulo.instancias;

        for(int cont = 0; cont < i; cont++)
        {//Inicio for
            if(tri[cont].tipo() == tipo){
                System.out.println(
                        "Triangulo " + (cont + 1) + ":" +
                        "\n\tLado A: " + tri[cont].getA() +
                        "\n\tLado B: " + tri[cont].getB() +
                        "\n\tLado C: " + tri[cont].getC() +
                        "\n\tPerimetro: " + tri[cont].perimetro() + "\n"
                        );//Fim println
            }//Fim if
        }//Fim for
    }//Fim listaTriangulos tipo

    public static void listaTriangulosInvalidos(Triangulo[] tri)
    {//Inicio listaTriangulosInvalidos
        int i = Triangulo.instancias;
        double A, B, C;
        int invalidos = 0;
        for(int cont = 0; cont < i; cont++)
        {//Inicio for
            A = tri[cont].getA();
            B = tri[cont].getB();
            C = tri[cont].getC();
            if(!Triangulo.ehTrianguloValido(A, B, C))
            {//Inicio if
                System.out.printf("O triângulo %d é inválido!\n", cont + 1);
                invalidos++;
            }//Fim if

        }//Fim for
        if(invalidos == 0) System.out.println("Não há casos de inválidez!");
    }//Fim listaTriangulosInvalidos

    public static void triangulosIguais(Triangulo[] tri)
    {//Inicio triangulosIguais
        int iguais = 0;
        int i = Triangulo.instancias;
        Scanner ler = new Scanner(System.in);

        System.out.printf("Deseja comparar com base em qual triângulo? [1..%d]: ",i);
        int op1 = ler.nextInt() - 1;
        for(int cont = 0; cont < i; cont++){
            if(op1 != cont  && tri[op1].ehIgual(tri[cont])) iguais++;
        }
        if(iguais == 0) System.out.println("\nNão há triângulos iguais a este!");
        else if(iguais == 1) System.out.printf("\nTem um Triangulo igual a este!\n");
        else System.out.printf("\nHá %d Triangulos iguais a este!\n",iguais);
    }//Fim triangulosIguais

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

    public double perimetro()
    {//Calcula perimetro do Triangulo
        double perimetro = getA() + getB() + getC();
        return perimetro;
    }//Fim perimetro

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
