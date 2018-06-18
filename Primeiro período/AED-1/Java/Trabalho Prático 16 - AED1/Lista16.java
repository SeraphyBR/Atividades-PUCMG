import java.util.Scanner;

public class Lista16
{//Inicio classe Lista16
    public static void main(String[]args)
    {//Inicio main 

    }//Fim main 
}//Fim classe Lista16

class Data
{//Inicio classe Data

    private int dia;
    private int mes;
    private int ano;

    public int getDia(){
        return this.dia;
    }

    public int getMes(){
        return this.mes;
    }

    public int getAno(){
        return this.ano;
    }

    public void setDia(int dia){
        this.dia = dia;
    }

    public void setMes(int mes){
        this.mes = mes;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public static boolean ehBissexto(int ano){
        boolean bissexto = false;
        if ((ano%4 == 0)&&((ano%100 !=0)||(ano%400 == 0))) bissexto = true;
        return bissexto;
    }
        

}//Fim classe Data