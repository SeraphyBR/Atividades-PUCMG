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
 *  o numero de ocorrencia (valor xientre parenteses) de cada caractere ou string solicitado. Cada
 *  linha de saida sera da seguinte forma: a(x1) e(x2) i(x3) o(x4) u(x5) á(x6) é(x7) í(x8) ó(x9) ú(x10)
 *  à(x11) è(x12) ì(x13) ò(x14) ù(x15) ã(x16) õ(x17) â(x19) ê(x19) î(x20) ô(x21) û(x22) consoante(x23)
 *  < br >(x24) < table >(x25) nomepagina(x26).
*/

import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class PaginaWeb
{//Inicio classe PaginaWeb
    public static void main (String[] args)
    {//Inicio main
        String[] palavra = new String[100];
        String[] codigoFonte = new String[50];
        int numEntrada = 0;

        //leitura da entrada padrao 
        do{
            palavra[numEntrada] = MyIO.readLine();
        }while(!ehIgual(palavra[numEntrada++], "FIM"));

        numEntrada--;

        //Armazena os codigos html de cada Link de Entrada
        for(int i = 0; i < numEntrada / 2; i++){
            codigoFonte[i] = capturaHTML(palavra[1 + i * 2]);
        }


    }//Fim main 

     public static String capturaHTML(String url)
     {//Inicio capturaHTML
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
        catch (IOException ioException) {
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

    public static void print(String x)
    {//Inicio print
        try {
            PrintStream out = new PrintStream(System.out, true, "UTF-8");
            out.print(x);
        }catch(UnsupportedEncodingException e){ System.out.println("Erro: charset invalido"); }
    }//Fim print

}//Fim classe PaginaWeb
