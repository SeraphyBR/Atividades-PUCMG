//Autor: Luiz Junio <luisjuniorbr@gmail.com>
//Data:  30-05-2018
import java.util.Scanner;

public class Exer1
{//Inicio classe Exer1 
    public static void main(String[]args)
    {//Inicio main 
        Carro[] carro = new Carro[5];
        String placa;
        int ano;
        int anoAtual;
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
        for(int cont = 0; cont < carro.length; cont++){
            double imposto = carro[cont].calculaImposto(anoAtual);
            System.out.printf("\nO imposto do carro %d eh: R$%.2f",cont + 1, imposto);
        } 
    }//Fim main 

}//Fim classe Exer1

class Carro
{//Inicio classe Carro 
    private String placa;
    private int ano;

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
}//Fim classe Carro 