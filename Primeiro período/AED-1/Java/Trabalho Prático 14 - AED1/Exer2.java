//Autor: Luiz Junio <luisjuniorbr@gmail.com>
//Data:  04-06-2018
import java.util.Scanner;

public class Exer2
{//Inicio classe Exer2 
    public static void main(String[]args)
    {//Inicio main 

    }//Fim main 
}//Fim classe Exer2 

class Produto
{//Inicio classe Produto
    private int numero;
    private double preco;

    public int getNumero(){
        return this.numero;
    }

    public double getPreco(){
        return this.preco;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public double desconto(){
        double valor = 0;
        if(this.getPreco() > 100) valor = this.getPreco() * 0.15;
        else valor = this.getPreco() * 0.05;
        return valor;
    }

}//Fim classe Produto

class Cliente
{//Inicio classe Cliente 
    private int numero;
    private String nome;
    private char genero;

    public int getNumero(){
        return this.numero;
    }

    public String getNome(){
        return this.nome;
    }
    
    public char getGenero(){
        return this.genero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setGenero(char genero){
        this.genero = genero;
    }

    public double descontoAdicional(){

    }

}//Fim classe Cliente 

class Compra
{//Inicio classe Compra

}//Fim classe Compra