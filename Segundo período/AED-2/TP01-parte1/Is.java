/*
 *  Autor: Luiz Junio <luisjuniorbr@gmail.com>
 *  Enunciado:
 *   Is - Crie um metodo iterativo que recebe uma string e retorna true se a mesma e composta
 *   somente por vogais. Crie outro metodo iterativo que recebe uma string e retorna true se a
 *   mesma e composta somente por consoantes. Crie um terceiro metodo iterativo que recebe uma
 *   string e retorna true se a mesma corresponde a um numero inteiro. Crie um quarto metodo
 *   iterativo que recebe uma string e retorna true se a mesma corresponde a um numero real. Na
 *   saida padrao, para cada linha de entrada, escreva outra de saida da seguinte forma X1 X2 X3
 *   X4 onde cada Xi e um booleano indicando se a entrada e: composta somente por vogais (X1);
 *   composta somente somente por consoantes (X2); um numero inteiro (X3); um numero real (X4).
 *   Se Xi for verdadeiro, seu valor sera SIM, caso contrario, NAO.
*/

public class Is
{//Inicio classe Is
    public static void main(String[] args)
    {//Inicio main
     /***************************************************************
      * Nome do método: main
      * Data da elaboração: 12/08/2018
      * Data da última alteração: 13/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Metodo Principal
      * Valor gerado: Nenhum.
      ****************************************************************
      */  
        String[] palavra = new String[1000];
        int numEntrada = 0;

        do{//Leitura da entrada padrao
            palavra[numEntrada] = MyIO.readLine();
        }while (!ehIgual(palavra[numEntrada++],"FIM"));

        numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

        for(int i = 0; i < numEntrada; i++)
        {//Inicio for
            if(ehApenasVogais(palavra[i])) MyIO.print("SIM ");
            else MyIO.print("NAO ");
            if(ehApenasConsoantes(palavra[i])) MyIO.print("SIM ");
            else MyIO.print("NAO ");
            if(ehNumInteiro(palavra[i])) MyIO.print("SIM ");
            else MyIO.print("NAO ");
            if(ehNumReal(palavra[i])) MyIO.println("SIM");
            else MyIO.println("NAO");
        }//Fim for
    }//Fim main

    public static boolean ehApenasVogais(String palavra)
    {//Inicio ehApenasVogais
     /***************************************************************
      * Nome do método: ehApenasVogais
      * Data da elaboração: 12/08/2018
      * Data da última alteração: 13/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Verifica se uma String possue apenas vogais.
      * Valor gerado: Verdadeiro se tiver apenas vogais, falso caso contrário.
      ****************************************************************
      */ 
        int tam = palavra.length(), i = 0;
        char c;
        boolean soVogal = true;
        while( i < tam && soVogal)
        {//Inicio while
            c = paraMaiusculo(palavra.charAt(i++));
            if(c < 'A' || c > 'Z') soVogal = false;
            else if(c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U')
                    soVogal = false;
        }//Fim while
        return soVogal;
    }//Fim ehApenasVogais

    public static boolean ehApenasConsoantes(String palavra)
    {//Inicio ehApenasConsoantes 
     /***************************************************************
      * Nome do método: ehApenasConsoantes
      * Data da elaboração: 12/08/2018
      * Data da última alteração: 13/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Verifica se uma String possue apenas consoantes.
      * Valor gerado: Verdadeiro se tiver apenas consoantes, falso caso contrário.
      ****************************************************************
      */    
        int tam = palavra.length(), i = 0;
        char c;
        boolean soConsoante = true;
        while(i < tam && soConsoante)
        {//Inicio while
            c = paraMaiusculo(palavra.charAt(i++));
            if(c < 'A' || c > 'Z') soConsoante = false;
            else if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                    soConsoante = false;
        }//Fim while
        return soConsoante; 
    }//Fim ehApenasConsoantes

    public static boolean ehNumInteiro(String palavra)
    {//Inicio ehNumInteiro
     /***************************************************************
      * Nome do método: ehNumInteiro
      * Data da elaboração: 13/08/2018
      * Data da última alteração: 13/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Verifica se uma String compoe um numero inteiro.
      * Valor gerado: Verdadeiro se for um numero inteiro, falso caso contrário.
      ****************************************************************
      */ 
        int tam = palavra.length(), i = 0;
        char c;
        boolean soNumInteiro = true;
        while(i < tam && soNumInteiro)
        {//Inicio while
            c = palavra.charAt(i++);
            if(c < '0' || c > '9')
                soNumInteiro = false;
        }//Fim while
        return soNumInteiro;
    }//Fim ehNumInteiro

    public static boolean ehNumReal(String palavra)
    {//Inicio ehNumReal
     /***************************************************************
      * Nome do método: ehNumReal
      * Data da elaboração: 13/08/2018
      * Data da última alteração: 13/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Verifica a string compoe um numero real.
      * Valor gerado: Verdadeiro se for um numero real, falso caso contrário.
      ****************************************************************
      */ 
        int tam = palavra.length();
        int i = 0, cont = 0;
        char c;
        boolean soNumReal = true;
        while(i < tam && soNumReal)
        {//Inicio while
            c = palavra.charAt(i++);
            if(c != ',' && c != '.' && (c < '0' || c > '9'))
                soNumReal = false;
            else if (c == ',' || c == '.') cont++;
        }//Fim while
        if(soNumReal && cont >= 2) soNumReal = false;
        return soNumReal;
    }//Fim ehNumReal

    public static char paraMaiusculo(char letra)
    {//Inicio paraMaisculo
     /***************************************************************
      * Nome do método: paraMaisculo
      * Data da elaboração: 13/08/2018
      * Data da última alteração: 13/08/2018
      * Autor: Luiz Junio <luisjuniorbr@gmail.com>
      * Contexto de ação: Converter uma letra Minuscula em maiscula.
      * Valor gerado: Se for uma letra, irá retornar o respectivo maisculo.
      *               Senão, irá retornar o proprio char de entrada.
      ****************************************************************
      */ 
        char modificado = ' ';
        if(letra <= 'z' && letra >= 'a') modificado = (char) ((int) letra - 32); //Tabela ASCII
        else modificado = letra;
        return modificado;
    }//Fim paraMaiusculo

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

}//Fim classe Is
