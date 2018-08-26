/*
    Autor: Luiz Junio <luisjuniorbr@gmail.com>
    Enunciado:
    Ciframento de Cesar - O Imperador Julio Cesar foi um dos principais nomes do Imperio
    Romano. Entre suas contribuicoes, temos um algoritmo de criptografia chamado “Ciframento de
    Cesar”. Segundo os historiadores, Cesar utilizava esse algoritmo para criptografar as mensagens
    que enviava aos seus generais durante as batalhas. A ideia basica e um simples deslocamento
    de caracteres. Assim, por exemplo, se a chave utilizada para criptografar as mensagens for 3,
    todas as ocorrencias do caractere ’a’ sao substituıdas pelo caractere ’d’, as do ’b’ por ’e’, e assim
    sucessivamente. Crie um metodo iterativo que recebe uma string como parametro e retorna
    outra contendo a entrada de forma cifrada. Neste exercıcio, suponha a chave de ciframento tres.
    Na saida padrao, para cada linha de entrada, escreva uma linha com a mensagem criptografada.
*/

class Cesar
{//Inicio Cesar 
    public static String descifre(String mensagem, int senha)
    {//Inicio descifre
     /***************************************************************
      * Nome do método: descifre
      * Data da elaboração: 28/06/2018
      * Data da última alteração: 09/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Descriptografar uma String com base na senha,
      * usando o Ciframento de Cesar.
      * Valor gerado: Retorna a String descriptografada.
      ****************************************************************
      */      
        String resultado = "";
        for(int i = 0; i < mensagem.length(); i++){
            resultado += (char) ((((int) mensagem.charAt(i)) - senha) % 256 );
        }
        return resultado;
    }//Fim descifre 

    public static String cripto(String mensagem, int senha)
    {//Inicio cripto
     /***************************************************************
      * Nome do método: cripto
      * Data da elaboração: 28/06/2018
      * Data da última alteração: 09/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Criptografa uma String com base na senha,
      * usando o Ciframento de Cesar.
      * Valor gerado: Retorna a String criptografada.
      ****************************************************************
      */     
        String resultado = "";
        for(int i = 0; i < mensagem.length(); i++){
            resultado += (char) ((((int) mensagem.charAt(i)) + senha) % 256 );
        }
        return resultado;
    }//Fim cripto 
}//Fim Cesar

public class Ciframento
{//Inicio Ciframento
    public static void main(String[] args)
    {//Inicio main
        String[] palavra = new String[1000];
        int numEntrada = 0;
     
        do{//Leitura da entrada padrao  
            palavra[numEntrada] = MyIO.readLine();
        }while (ehIgual(palavra[numEntrada++],"FIM") == false);

        numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

        for(int i = 0; i < numEntrada; i++)
        {//Inicio for
            MyIO.println(Cesar.cripto(palavra[i], 3));
        }//Fim for

    }//Fim main

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
                if(p1.charAt(i) != p2.charAt(i))
                    igual = false;
                i++;
        }//Fim while
        return igual;
    }//Fim ehIgual
}//Fim Ciframento



