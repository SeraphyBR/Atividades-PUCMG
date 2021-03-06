/*
 *  Autor: Luiz Junio <luisjuniobr@gmail.com>
 *  Enunciador:
 *  Leitura de Pagina HTTP - Leia duas strings sendo que a primeira e o nome de uma pagina
 *  web e a segunda, seu endereco. Por exemplo, “Pontificia Universidade Catolica de Minas Gerais”
 *  e “www.pucminas.br”. Em seguida, mostre na tela o numero de vogais (sem e com acento), con-
 *  soantes e dos padroes “< br >” e “< table >” que aparecem no codigo dessa pagina. A entrada
 *  padrao e composta por varias linhas. Cada uma contem varias strings sendo que a primeira
 *  e um endereco web e as demais o nome dessa pagina web. A ultima linha da entrada padrao
 *  contem a palavra “FIM”. A saida padrao contem varias linhas sendo que cada uma apresenta
 *  o numero de ocorrencia (valor xi entre parenteses) de cada caractere ou string solicitado. Cada
 *  linha de saida sera da seguinte forma: a(x1) e(x2) i(x3) o(x4) u(x5) á(x6) é(x7) í(x8) ó(x9) ú(x10)
 *  à(x11) è(x12) ì(x13) ò(x14) ù(x15) ã(x16) õ(x17) â(x19) ê(x19) î(x20) ô(x21) û(x22) consoante(x23)
 *  < br >(x24) < table >(x25) nomepagina.
*/

import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.InputStreamReader;

public class PaginaWeb
{//Inicio classe PaginaWeb
    public static void main (String[] args)
    {//Inicio main
        String[] palavra = new String[1000];
        String[] codigoFonte = new String[500];
        MyIO.setCharset("UTF-8");//Saida em UTF-8
        int numEntrada = 0, numLinks = 0;

        //leitura da entrada padrao 
        do{
            palavra[numEntrada] = MyIO.readLine();
        }while(!ehIgual(palavra[numEntrada++], "FIM"));

        numEntrada--;//Desconsiderando a String "FIM"

        //Armazena os codigos html de cada Link de Entrada
        for(int i = 0; i < numEntrada / 2; i++){
            codigoFonte[i] = capturaHTML(palavra[1 + i * 2]);
            numLinks++;
        }

        //Variaveis inteiras para armazenar a quantidade de cada caractere
        int a1, a2, a3, a4, a5, e1, e2, e3, e4, i1, i2, i3, i4;
        int o1, o2, o3, o4, o5, u1, u2, u3, u4, cs, br, tb;

        String nomePagina;

        //Saida do programa
        for(int i = 0; i < numLinks; i++)
        {//Inicio for
            br = contaTermo("<br>", codigoFonte[i]);
            tb = contaTermo("<table>", codigoFonte[i]); 
            a1 = contaCaractere('a', codigoFonte[i]) - 1 * tb;//Desconsiderando table
            a2 = contaCaractere('á', codigoFonte[i]);
            a3 = contaCaractere('à', codigoFonte[i]);
            a4 = contaCaractere('ã', codigoFonte[i]);
            a5 = contaCaractere('â', codigoFonte[i]);
            e1 = contaCaractere('e', codigoFonte[i]) - 1 * tb;//Desconsiderando table
            e2 = contaCaractere('é', codigoFonte[i]);
            e3 = contaCaractere('è', codigoFonte[i]);
            e4 = contaCaractere('ê', codigoFonte[i]);
            i1 = contaCaractere('i', codigoFonte[i]);  
            i2 = contaCaractere('í', codigoFonte[i]);
            i3 = contaCaractere('ì', codigoFonte[i]);
            i4 = contaCaractere('î', codigoFonte[i]);
            o1 = contaCaractere('o', codigoFonte[i]);
            o2 = contaCaractere('ó', codigoFonte[i]);
            o3 = contaCaractere('ò', codigoFonte[i]);
            o4 = contaCaractere('õ', codigoFonte[i]);
            o5 = contaCaractere('ô', codigoFonte[i]);
            u1 = contaCaractere('u', codigoFonte[i]);
            u2 = contaCaractere('ú', codigoFonte[i]);
            u3 = contaCaractere('ù', codigoFonte[i]);
            u4 = contaCaractere('û', codigoFonte[i]);
            cs = contaConsoantes(codigoFonte[i]) - (3 * tb) - (2 * br);//Desconsiderando table e br
            nomePagina = palavra[i * 2];
            MyIO.println
            (//Inicio println
                    "a(" + a1 + ") " + "e(" + e1 + ") " + "i(" + i1 + ") " + "o(" + o1 + ") " + "u(" + u1 + ") " +
                    "á(" + a2 + ") " + "é(" + e2 + ") " + "í(" + i2 + ") " + "ó(" + o2 + ") " + "ú(" + u2 + ") " +
                    "à(" + a3 + ") " + "è(" + e3 + ") " + "ì(" + i3 + ") " + "ò(" + o3 + ") " + "ù(" + u3 + ") " +
                    "ã(" + a4 + ") "                                       + "õ(" + o4 + ") "                    +
                    "â(" + a5 + ") " + "ê(" + e4 + ") " + "î(" + i4 + ") " + "ô(" + o5 + ") " + "û(" + u4 + ") " +
                    "consoante(" + cs + ") " + "<br>(" + br + ") " + "<table>(" + tb + ") " + nomePagina
            );//Fim println
        }//Fim for
    }//Fim main 

    public static int contaCaractere(char alvo, String palavra)
    {//Inicio contaCaractere
     /***************************************************************
      * Nome do método: contaCaractere
      * Data da elaboração: 16/08/2018
      * Data da última alteração: 16/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Contar o numero de ocorrencias de um caractere na String.
      * Valor gerado: A quantidade de um Char que aparece na String.
      ****************************************************************
      */        
        int quantidade = 0;
        for(int i = 0; i < palavra.length(); i++){
            if(palavra.charAt(i) == alvo)
                quantidade++;
        }
        return quantidade;
    }//Fim contaCaractere


    public static int contaConsoantes(String palavra)
    {//Inicio contaConsoantes
     /***************************************************************
      * Nome do método: contaConsoantes
      * Data da elaboração: 16/08/2018
      * Data da última alteração: 18/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Contar o numero de consoantes de uma String.
      * Valor gerado: O numero de consoantes.
      * Observação: As letras maiusculas não foram consideradas na conta
      ****************************************************************
      */        
        int quantidade = 0;
        char c;
        for(int i = 0; i < palavra.length(); i++)
        {//Inicio for
            c = palavra.charAt(i);
            if(c > 'a' && c <= 'z'){
                if(c != 'e' && c != 'i' && c != 'o' && c != 'u')
                    quantidade++;
            }    
        }//Fim for
        return quantidade;
    }//Fim contaConsoantes

    public static int contaTermo(String alvo, String frase)
    {//Inicio contaPalavras
     /***************************************************************
      * Nome do método: contaTermo
      * Data da elaboração: 16/08/2018
      * Data da última alteração: 17/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Encontrar uma palavra dentro de uma String.
      * Valor gerado: A quantidade de vezes que a palavra aparece.
      ****************************************************************
      */        
        int quantidade = 0, i = 0;
        int p = 0;// p = posição na frase;
        boolean ehAlvo;
        while(p < frase.length())
        {//Inicio while
            ehAlvo = true;
            if(frase.charAt(p) == ' '){ //Se tiver um espaço, avança a posição.
                p++;
                ehAlvo = false;
            }
            else
            {//Inicio else
                i = 0;
                while(i < alvo.length() && ehAlvo)
                {//Inicio while
                    if(frase.charAt(p + i) != alvo.charAt(i))
                        ehAlvo = false;
                    i++;
                }//Fim while
                p++;
            }//Fim else
            if(ehAlvo) quantidade++;
        }//Fim while
        return quantidade;
    }//Fim contaPalavras

    public static String capturaHTML(String url)
    {//Inicio capturaHTML
     /***************************************************************
      * Nome do método: capturaHTML
      * Data da elaboração: 16/08/2018
      * Data da última alteração: 17/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Obter o codigo html de uma URL.
      * Valor gerado: Uma String contendo todo o codigo html.
      ****************************************************************
      */        
        String codigo = ""; 
        try
        {//Inicio try
            //pega a url informada
            URL u = new URL(url);
            //conecta com o servidor da pagina
            URLConnection uc = u.openConnection();
            //retorna a leitura da pagina
            InputStreamReader isr = new InputStreamReader(uc.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            String linha;
            //lê todas as linhas da pagina e armazena tudo na variavel codigo
            while((linha = br.readLine()) != null){
                codigo += (linha + "\n");
            }
            br.close();//Fecha instancia de BufferedReader
            isr.close();//Fecha instancia de InputStreamReader
        }//Fim try 
        catch (IOException ioException){
            ioException.printStackTrace();
        }

        return codigo;
    }//Fim capturaHTML

    public static boolean ehIgual(String p1, String p2)
    {//Inicio ehIgual
     /***************************************************************
      * Nome do método: ehIgual
      * Data da elaboração: 08/08/2018
      * Data da última alteração: 08/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Verifica se uma String é igual a outra.
      * Valor gerado: verdadeiro se forem iguais, falso caso contrário.
      ****************************************************************
      */ 
        boolean igual = true;
        int i = 0;
        if(p1.length() != p2.length()) igual = false;
        else while(i < p1.length() && igual){
                if(p1.charAt(i) != p2.charAt(i))//Comparacao caractere por caractere
                    igual = false;
                i++;
        }//Fim while
        return igual;
    }//Fim ehIgual
}//Fim classe PaginaWeb
