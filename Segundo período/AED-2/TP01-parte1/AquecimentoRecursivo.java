/*
 * Autor: Luiz Junio <luisjuniorbr@gmail.com>
 * Criado em: 21/08/2018 
 * Ultima alteração: 23/08/2018
 */

public class AquecimentoRecursivo
{//Inicio classe AquecimentoRecursivo
    public static void main(String[] args)
    {//Inicio main
      String[] entrada = new String[1000];
      int numEntrada = 0;

      //Leitura da entrada padrao
      do{
         entrada[numEntrada] = MyIO.readLine();
      }while(!ehIgual(entrada[numEntrada++], "FIM"));
      numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM

      for(int i = 0; i < numEntrada; i++){
          MyIO.println(contaLetrasMaiusculas(entrada[i]));
      }

    }//Fim main

    public static int contaLetrasMaiusculas(String palavra){
        return contaLetrasMaiusculas(palavra, 0);
    }

    private static int contaLetrasMaiusculas(String palavra, int i)
    {//Inicio contaLetrasMaisculas
        char c;
        int retorno = 0;
        if(i >= palavra.length())
            retorno = 0;
        else{
            c = palavra.charAt(i);
            if(c >= 'A' && c <= 'Z')
                retorno = 1 + contaLetrasMaiusculas(palavra, i + 1);
            else 
                retorno = 0 + contaLetrasMaiusculas(palavra, i + 1);
        }
        return retorno;  
    }//Fim contaLetras Maisculas

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

}//Fim classe Aquecimento

