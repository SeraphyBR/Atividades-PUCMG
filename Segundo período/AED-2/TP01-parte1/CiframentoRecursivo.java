 /*
    Autor: Luiz Junio <luisjuniorbr@gmail.com>
    Criado em: 24/08/2018
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
  
public class CiframentoRecursivo
{//Inicio classe CiframentoRecursivo
    public static void main(String[] args)
    {//Inicio main
        String[] palavra = new String[1000];
        int numEntrada = 0;
     
        do{//Leitura da entrada padrao  
            palavra[numEntrada] = MyIO.readLine();
        }while (!ehIgual(palavra[numEntrada++],"FIM"));

        numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

        for(int i = 0; i < numEntrada; i++)
        {//Inicio for
            MyIO.println(Cesar.cripto(palavra[i], 3));
        }//Fim for
    }

    public static boolean ehIgual(String p1, String p2)
    {//Inicio ehIgual
        boolean resp = true;
        if(p1.length() != p2.length())
            resp = false;
        else
            resp = ehIgual(p1,p2,0);
        return resp;
    }//Fim ehIgual


    private static boolean ehIgual(String p1, String p2, int i)
    {//Inicio ehIgual
     /***************************************************************
      * Nome do método: ehIgual
      * Data da elaboração: 23/08/2018
      * Data da última alteração: 23/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Verifica se uma String é igual a outra.
      * Valor gerado: verdadeiro se forem iguais, falso caso contrário.
      ****************************************************************
      */ 
        boolean igual = true;
        if(i < p1.length()){
            if(p1.charAt(i) == p2.charAt(i))
                igual = true && ehIgual(p1,p2,i + 1);
            else
                igual = false;
        }
        return igual;
    }//Fim ehIgual

}//Fim classe CiframentoRecursivo

class Cesar
{//Inicio classe Cesar

    public static String descifre(String mensagem, int senha)
    {//Inicio descifre
        return descifre(mensagem, senha, 0);
    }//Fim descifre

    public static String cripto(String mensagem, int senha)
    {//Inicio cripto
        return cripto(mensagem, senha, 0);
    }//Fim cripto

    private static String descifre(String mensagem, int senha, int i)
    {//Inicio descifre Private 
        String resultado = "";
        if(i < mensagem.length())
        {//Inicio if
            resultado += (char) ((((int) mensagem.charAt(i)) - senha) % 256);
            resultado += descifre(mensagem, senha, i + 1);
        }//Fim if
        return resultado;
    }//Fim descifre Private

    private static String cripto(String mensagem, int senha, int i)
    {//Inicio cripto Private
        String resultado = "";
        if(i < mensagem.length())
        {//Inicio if
            resultado += (char) ((((int) mensagem.charAt(i)) + senha) % 256);
            resultado += cripto(mensagem, senha, i + 1);
        }//Fim if
        return resultado;
    }//Fim cripto Private

}//Fim classe Cesar

