import java.util.Scanner;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

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
        
    public static String mesExtenso(int mes)
    {//Inicio mesExtenso
        String extenso = " ";
        switch(mes)
        {//Inicio switch 
            case 1:
                extenso = "Janeiro";
                break;
            case 2:
                extenso = "Fevereiro";
                break;
            case 3:
                extenso = "Março";
                break; 
            case 4:
                extenso = "Abril";
                break;  
            case 5:
                extenso = "Maio";
                break; 
            case 6:
                extenso = "Junho";
                break;  
            case 7:
                extenso = "Julho";
                break; 
            case 8:
                extenso = "Agosto";
                break;
            case 9:
                extenso = "Setembro";
                break;
            case 10:
                extenso = "Outubro";
                break;
            case 11:
                extenso = "Novembro";
                break;
            case 12:
                extenso = "Dezembro";
                break; 
            default:
                break;    
        }//Fim switch
        return extenso; 
    }//Fim mesExtenso

}//Fim classe Data