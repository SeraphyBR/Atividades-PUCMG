//Autor: Luiz Junio <luisjuniorbr@gmail.com>
//Data:  04-06-2018
import java.util.Scanner;

public class Exer1
{//Inicio classe Exer1 
    public static void main(String[]args)
    {//Inicio main 
        Carro[] carro = new Carro[5];
        String placa;
        int ano, anoAtual;
        double imposto;
        Scanner ler = new Scanner(System.in);

        for(int cont = 0; cont < carro.length; cont++)
        {//Inicio for 
            carro[cont] = new Carro();
            System.out.printf("\nCarro %d: ", cont + 1);
            System.out.printf("\nDigite a placa: ");
            placa = ler.next();
            carro[cont].setPlaca(placa);
            System.out.printf("Digite o ano de fabricação: ");
            ano = ler.nextInt();
            carro[cont].setAno(ano);    
        }//Fim for

        System.out.print("\nDigite o ano atual para calculo do imposto: ");
        anoAtual = ler.nextInt();

        for(int cont = 0; cont < carro.length; cont++)
        {//Inicio for 2
            imposto = carro[cont].calculaImposto(anoAtual);
            System.out.printf("\nO imposto do carro %d eh: R$%.2f",cont + 1, imposto);
        }//Fim for 2

        System.out.printf("\nO total de imposto eh: R$%.2f", Carro.somaImposto(carro, anoAtual));
        System.out.printf("\nO número de carros que não pagam imposto eh: %d", Carro.qntdSemImposto(carro, anoAtual)); 
    }//Fim main 
}//Fim classe Exer1

class Carro
{//Inicio classe Carro 
    private String placa;
    private int ano;
    public static int quantidade = 0;

    Carro()
    {//Inicio construtor vazio
        this.setPlaca(" ");
        this.setAno(0);
        quantidade++;
    }//Fim construtor vazio;

    Carro(String placa, int ano)
    {//Inicio construtor cheio
        this.setPlaca(placa);
        this.setAno(ano);
        quantidade++;
    }//Fim construtor cheio

    public String getPlaca(){
        return this.placa;
    }

    public int getAno(){
        return this.ano;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public double calculaImposto(int anoAtual)
    {//Inicio calculaImposto;
        double imposto = 500.00;
        int tempoUsado = anoAtual - this.getAno() + 1;
        if(this.getAno() != anoAtual)
        {//Inicio if 1
            if(tempoUsado < 10)
            {//Inicio if 2 
                imposto -= tempoUsado * 100.00;
                if(imposto < 100) imposto = 100.00;
            }//Fim if 2
            else imposto = 0.00;
        }//Fim if 1 
        return imposto;
    }//Fim calculaImposto;

    public static double somaImposto(Carro[] carro, int anoAtual)
    {//Inicio somaImposto
        double soma = 0;
        for(int cont = 0; cont < Carro.quantidade; cont++){
            soma += carro[cont].calculaImposto(anoAtual);
        }
        return soma;
    }//Fim somaImposto

    public static int qntdSemImposto(Carro[] carro, int anoAtual)
    {//Inicio semImposto
        int quantidade = 0;
        for(int cont = 0; cont < Carro.quantidade; cont++){
            if(carro[cont].calculaImposto(anoAtual) == 0) quantidade++;
        }
        return quantidade;
    }//Fim semImposto
}//Fim classe Carro 