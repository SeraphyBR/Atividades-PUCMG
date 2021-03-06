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

    public double descontoAdicional(Produto p1)
    {//Inicio descontoAdicional
        double adicional = 0;
        if(Character.toUpperCase(this.getGenero()) == 'F') adicional = p1.getPreco() * 0.05; 
        return adicional;
    }//Fim descontoAdicional

}//Fim classe Cliente 

class Compra
{//Inicio classe Compra
    private int numeroProduto;
    private int numeroCliente;
    private int quantidade;
    private double valorTotal;


    public void setNumeroProduto(int produto){
        this.numeroProduto = produto;
    }

    public void setNumeroCliente(int cliente){
        this.numeroCliente = cliente;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public void setValorTotal(int total){
        this.valorTotal = total;
    }

    public int getNumeroProduto(){
        return this.numeroProduto;
    }

    public int getNumeroCliente(){
        return this.numeroCliente;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public double getValorTotal(){
        return this.valorTotal;
    }

    public double calcValorTotal(Produto p1, Cliente c1, int quantidade){
        
    }
}//Fim classe Compra