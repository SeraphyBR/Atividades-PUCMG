   
/*
 *  Autor: Luiz Junio <luisjuniorbr@gmail.com>
 *  Enunciado:
 *   Alteracao Aleatoria - Crie um metodo *Recursivo que recebe uma string, sorteia duas letras
 *   minusculas aleatorias (codigo ASCII ≥ ’a’ e ≤ ’z’), substitui todas as ocorrencias da primeira
 *   letra na string pela segunda e retorna a string com as alteracoes efetuadas. Na saıda padrao,
 *   para cada linha de entrada, execute o metodo desenvolvido nesta questao e mostre a string
 *   retornada como uma linha de saida.
 *
 *   A classe Random do Java gera numeros (ou letras) aleatorios. 
 *   Em especial, destacamos que: 
 *   i) seed e a semente para geracao de numeros aleatorios; 
 *   ii) nesta questao, por causa da correcao automatica, a seed sera quatro;
 *   iii) a disciplina de Estatıstica e Probabilidade faz uma discussao sobre “aleatorio”.
 */

import java.util.Random;

public class AlteracaoRecursivo
{//Inicio classe AlteracaoRecursivo
    public static void main(String[] args)
    {//Inicio main
        String[] palavra = new String[1000];
        Random gerador = new Random(); //Inicia uma instancia de Random
        int numEntrada = 0;
        gerador.setSeed(4);  //Define a seed de geracao

        do{//Leitura da entrada padrao
            palavra[numEntrada] = MyIO.readLine();
        }while (!ehIgual(palavra[numEntrada++],"FIM"));

        numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

        for(int i = 0; i < numEntrada; i++)
            MyIO.println(trocaLetrasRandom(palavra[i], gerador));
    }//Fim main 

    public static String trocaLetrasRandom(String palavra, Random gerador)
    {//Inicio trocaLetrasRandom 
        char letra1 = (char) ( 'a' + (Math.abs(gerador.nextInt() % 26)));//Gera um caractere minusculo aleatorio
        char letra2 = (char) ( 'a' + (Math.abs(gerador.nextInt() % 26)));//Gera um caractere minusculo aleatorio
        return trocaLetrasRandom(palavra,gerador, 0, letra1, letra2);
    }//Fim trocaLetrasRandom

    private static String trocaLetrasRandom(String palavra, Random gerador, int i, char letra1, char letra2)
    {//Inicio trocaLetrasRandom Private
     /***************************************************************
      * Nome do método: trocaLetrasRandom
      * Data da elaboração: 10/08/2018
      * Data da última alteração: 24/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Receber uma String, gerar duas letras aleatorias e
      * trocar as ocorrencias da primeira letra na String pela segunda letra
      * Valor gerado: A string com as alteracoes feitas.
      ****************************************************************
      */   
        String modificado = "";
        if(i < palavra.length())
        {//Inicio if
            if(palavra.charAt(i) == letra1){
                //Se o caractere da String for igual ao primeiro gerado, irá colocar o segundo no lugar. 
                modificado += letra2; 
            }
            else modificado += palavra.charAt(i);
            
            modificado += trocaLetrasRandom(palavra,gerador, i + 1, letra1, letra2);
        }//Fim if

        return modificado; 
    }//Fim trocaLetrasRandom Private

    public static boolean ehIgual(String p1, String p2)
    {//Inicio ehIgual
     /***************************************************************
      * Nome do método: ehIgual
      * Data da elaboração: 23/08/2018
      * Data da última alteração: 23/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Verifica se uma String é igual a outra.
      * Valor gerado: Se tiverem tamanho diferente, retorna falso.
      * Caso contrário, chama o metodo recursivo com o contador em 0.
      ****************************************************************
      */  
        boolean resp = true;
        if(p1.length() != p2.length())
            resp = false;
        else
            resp = ehIgual(p1,p2,0);
        return resp;
    }//Fim ehIgual

    private static boolean ehIgual(String p1, String p2, int i)
    {//Inicio ehIgual Private
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
    }//Fim ehIgual Private
         
}//Fim classe AlteracaoRecursivo

