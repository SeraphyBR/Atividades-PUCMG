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

    public boolean ehAnoBissexto(){
        boolean bissexto = false;
        int ano = this.getAno();
        if ((ano%4 == 0)&&((ano%100 !=0)||(ano%400 == 0))) bissexto = true;
        return bissexto;
    }
        
    public String mesExtenso()
    {//Inicio mesExtenso
        int mes = this.getMes() - 1;
        String[] meses = {"Janeiro", "Fevereiro" , "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        try{
            return meses[mes];
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            return "";
        }     
    }//Fim mesExtenso

    public boolean ehValido()
    {//Inicio ehValido
        boolean valido = true;
        int ano = this.getAno();
        int mes = this.getMes();
        int dia = this.getDia();
        boolean ehAnoBissexto = this.ehAnoBissexto();

        if(ano < 1) valido = false;
        else if(mes > 12 || mes < 1) valido = false;
            else if(dia < 1) valido = false;
                else if(mes == 1 && dia > 31) valido = false;
                else if(mes == 2 && !ehAnoBissexto && dia > 28) valido = false;
                else if(mes == 2 && ehAnoBissexto && dia > 29) valido = false;
                else if(mes == 3 && dia > 31) valido = false;
                else if(mes == 4 && dia > 30) valido = false;
                else if(mes == 5 && dia > 31) valido = false;
                else if(mes == 6 && dia > 30) valido = false;
                else if(mes == 7 && dia > 31) valido = false;
                else if(mes == 8 && dia > 31) valido = false;
                else if(mes == 9 && dia > 30) valido = false;
                else if(mes == 10 && dia > 31) valido = false;
                else if(mes == 11 && dia > 30) valido = false;
                else if(mes == 12 && dia > 31) valido = false;
        return valido;
    }//Fim ehValido

    public boolean ehMaisRecente(Data data)
    {//Inicio ehMaisRecente
        boolean ehRecente = false;
        if(this.getAno() >= data.getAno()){
            if(this.getMes() >= data.getMes()){
                if(this.getDia() > data.getDia()) ehRecente = true;
            }
        }
        return ehRecente;
    }//Fim ehMaisRecente

}//Fim classe Data