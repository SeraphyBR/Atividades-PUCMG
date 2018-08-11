
public class Aquecimento
{//Inicio Classe Aquecimento
    public static void main(String[] args)
    {//Inicio main
        //String palavra = MyIO.readString();
        MyIO.println(numMaiusculo("LuiZ"));

    }//Fim main 

    public static int numMaiusculo(String palavra)
    {//Inicio numMaiusculo
        int palavra_ascci = 0;
        int cont = 0;
        for(int i = 0; i < palavra.length(); i++){
            palavra_ascci = (int) palavra.charAt(i);
            if(palavra_ascci >= 65 && palavra_ascci <= 90) cont++;
        
        }
        return cont;
    }//Fim numMaiusculo


}//Fim Classe Aquecimento
