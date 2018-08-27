/*
    Autor: Luiz Junio <luisjuniorbr@gmail.com>
    Enunciado: 
    Algebra Booleana - Crie um metodo iterativo que recebe uma string contendo uma expressao
    booleana e o valor de suas entradas e retorna um booleano indicando se a expressao e verdadeira
    ou falsa. Cada string de entrada e composta por um numero inteiro n indicando o numero de
    entradas da expressao booleana corrente. Em seguida, a string contem n valores binarios (um
    para cada entrada) e a expressao booleana. Na saida padrao, para cada linha de entrada, escreva
    uma linha de saida com SIM / NAO indicando se a expressao corrente e verdadeira ou falsa.

    Exemplo de entrada:
        2 0 1 and(not(A) , not(B))
    Exemplo de saida:
        0

*/
public class Algebra
{//Inicio classe Algebra
    public static void main(String[] args)
    {//Inicio main 
        String[] palavra = new String[1000];
        int numEntrada = 0;

        do{//Leitura da entrada padrao  
            palavra[numEntrada] = MyIO.readLine();
        }while (!ehIgual(palavra[numEntrada++],"0"));

        numEntrada--;   //Desconsiderar ultima linha contendo a palavra "0"
 
    }//Fim main 

    public static boolean expressaoBool(String expressao)
    {//Inicio expressaoBool
        boolean resultado = true;
        int[] entrada = new int[3];
        char operacaoEx;
        int p = 0;

        int numEntradas = expressao.charAt(p) - 48;
        for(int i = 0; i < numEntradas; i++)
        {//Inicio for
            p = 2 + (2 * i);//Posicao das entradas, considerando espacos
            entrada[i] = expressao.charAt(p) - 48;
        }//Fim for
        p += 2; //Avanca para a operacao principal, mais externa
        do{
            if(expressao.charAt(p) == 'a'){
                operacaoEx = 'a';//and
                p += 4;
            }
            else if(expressao.charAt(p) == 'o'){
                operacaoEx = 'o';//or
                p += 3;
            }
            else if(expressao.charAt(p) == 'n'){
                operacaoEx = 'n';//not
                p += 4;
            }
        }while(p < expressao.length());
        return resultado;
    }//Fim expressaoBool
     
    public static String trocaLetrasRandom(String palavra, char letraI, char letraF)
    {//Inicio trocaLetrasRandom
     /***************************************************************
      * Nome do método: trocaLetrasRandom
      * Data da elaboração: 10/08/2018
      * Data da última alteração: 11/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Receber uma String, gerar duas letras aleatorias e
      * trocar as ocorrencias da primeira letra na String pela segunda letra
      * Valor gerado: A string com as alteracoes feitas.
      ****************************************************************
      */   
        String modificado = "";
        for(int i = 0; i < palavra.length(); i++)
        {//Inicio for
            if(palavra.charAt(i) == letraI)
                modificado += letraF;//Se o caractere da String for igual ao primeiro gerado, irá colocar o segundo no lugar.
            else modificado += palavra.charAt(i);
        }//Fim for

        return modificado; 
    }//Fim trocaLetrasRandom
                    
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

}//Fim classe Algebra
