
/*Questão 01 - Matriz com relações de amizade.

  O programa deverá implementar as seguintes funcionalidades:

  Um menu para o usuário com as seguintes opções:
  0 –Sair
  1 –Cadastrar as relações de amizades
  2 –Pesquisar quais as relações de amizade de uma pessoa
  3 –Pesquisar o número de relações de amizade de uma pessoa
  4 –Verificar se há a seguinte anomalia: uma relação de amizade de uma pessoa com ela mesma

  -A matriz deverá permitir gerenciar, no máximo, cem pessoas. Entretanto, o usuário deverá cadastrar o 
  número de pessoas que precisar.
  -Documentação do código é obrigatória.
  -A endentação do código é obrigatória.
  -Postar apenas o arquivo com o código fonte.

*/
import java.util.Scanner;

public class RelacoesDeAmizades
{//Inicio classe RelacoesDeAmizades

    public static void main(String[]args)
    {//Inicio main
        /***************************************************************
         * Nome do método: main 
         * Data da elaboração: 06/05/2018
         * Data da última alteração: 06/05/2018
         * Autor: Luiz Junio <luisjuniorbr@gmail.com>
         * Contexto de ação: Dar inicio ao programa.
         * Argumentos: Nulo
         * Valor gerado: Nulo
         ****************************************************************
         */
        int[][] matriz = new int[2][2]; 
        String[] pessoas = new String[2];
        boolean cadastroFeito = false;
        boolean naoSair = true;

        do{
            switch(menu())
            {//Inicio switch
                case 0: naoSair = false;
                        break;
                case 1: pessoas = cadastraPessoas();
                        matriz = cadastraRelacoes(pessoas);
                        cadastroFeito = true;
                        break;
                case 2: if(cadastroFeito) buscaRelacoes(pessoas, matriz);
                            else System.out.println("Faça o cadastro primeiro!\n");
                            break;
                case 3: if(cadastroFeito) quantidadeAmigos(pessoas, matriz);
                            else System.out.println("Faça o cadastro primeiro!\n");
                            break;
                case 4: if(temAnomalia(matriz)) System.out.println("Há caso de anomalia nas relações, situação foi corrigida!");
                            else System.out.println("Não há anomalia nas relações.");
                            break;
                default: break;       

            }//Fim switch
        }while(naoSair);
        System.out.println("Até logo!");
    }//Fim main

    public static int menu()
    {//Inicio menu
        /***************************************************************
         * Nome do método: menu
         * Data da elaboração: 06/05/2018
         * Data da última alteração: 06/05/2018
         * Autor: Luiz Junio <luisjuniorbr@gmail.com>
         * Contexto de ação: Mostrar menu de opções e obter a opção desejada.
         * Argumentos: Nulo.
         * Valor gerado: Número inteiro relativo a opção desejada.
         ****************************************************************
         */
        int opcao;
        boolean erro;
        Scanner ler = new Scanner(System.in);
        System.out.println();
        System.out.printf(
                "MENU DAS RELAÇÕES DE AMIZADE:\n"
                + "Opções:\n"
                + "0 - Sair;\n"
                + "1 - Cadastrar pessoas;\n"
                + "2 - Pesquisar quais as relações de amizade de uma pessoa;\n"
                + "3 - Pesquisar o número de relações de amizade de uma pessoa;\n"
                + "4 - Verificar anomalias: uma relações de amizade de uma pessoa com ela;\n"
                + "\nDigite a opção desejada:\n=> "
                );
        do{
            opcao = ler.nextInt();
            erro = opcao > 4 || opcao < 0;
            if(erro) System.out.print("Opção Inválida!\n=> ");
        }while(erro);
        return opcao;  
    }//Fim menu

    public static String[] cadastraPessoas()
    {//Inicio cadastraPessoas
        /***************************************************************
         * Nome do método: cadastraPessoas
         * Data da elaboração: 06/05/2018
         * Data da última alteração: 06/05/2018
         * Autor: Luiz Junio <luisjuniorbr@gmail.com>
         * Contexto de ação: Realizar o cadastro de pessoas em um array de String.
         * Argumentos: Nulo.
         * Valor gerado: Array de string contendo os nomes das pessoas.
         ****************************************************************
         */
        Scanner ler = new Scanner(System.in);   
        int valor; 
        boolean erro;  
        System.out.printf("Deseja cadastrar quantas pessoas?[Max. 100]\n=> ");
        do{
            valor = ler.nextInt();
            erro = valor <= 0 || valor > 100;
            if(erro) System.out.print("Valor inválido!\n=> ");
        }while(erro);

        String[] individuo = new String[valor];

        for(int i = 0; i < valor; i++)
        {//Inicio for i
            System.out.printf("Digite o nome da %dª pessoa: ", i + 1);
            individuo[i] = ler.next();
            System.out.println();
        }//Fim for i
        return individuo;
    }//Fim cadastraPessoas

    public static int[][] cadastraRelacoes(String[] individuo)
    {//Inicio cadastraRelacoes
        /***************************************************************
         * Nome do método: cadastraRelacoes
         * Data da elaboração: 06/05/2018
         * Data da última alteração: 06/05/2018
         * Autor: Luiz Junio <luisjuniorbr@gmail.com>
         * Contexto de ação: Registrar as relações de amizade entre as pessoas cadastradas.
         * Argumentos: Array contendo os nomes das pessoas.
         * Valor gerado: Matriz de inteiros contendo número 1 - quando forem amigos, e 0 - Sem relação.
         ****************************************************************
         */
        int quantidadeP = individuo.length;
        int coluna;
        char resposta;
        Scanner ler = new Scanner(System.in);
        int[][] matriz = new int[quantidadeP][quantidadeP];

        System.out.println("Digite a sequir as relações de amizades: \n");
        for(int p = 0; p < quantidadeP; p++)
        {//Inicio for p 
            System.out.println("Digite as relações de " + individuo[p] + ":" );
            for(coluna = 0; coluna < quantidadeP; coluna++)
            {//Inicio for coluna 
                //if (coluna != p){
                System.out.print("Eh amigo de " + individuo[coluna] + " ?[S/N]: ");
                resposta = Character.toUpperCase(ler.next().charAt(0));
                if (resposta == 'S') matriz[p][coluna] = 1;
                else matriz[p][coluna] = 0;
                //}
            }//Fim for coluna 
        }//Fim for p 
        return matriz;
    }//Fim cadastraRelacoes

    public static void buscaRelacoes(String[] pessoa, int[][] matriz)
    {//Inicio buscaRelacoes
        /***************************************************************
         * Nome do método: buscaRelacoes
         * Data da elaboração: 06/05/2018
         * Data da última alteração: 06/05/2018
         * Autor: Luiz Junio <luisjuniorbr@gmail.com>
         * Contexto de ação: Imprimir os amigos de uma pessoa cadastrada.
         * Argumentos: Array contendo os nomes das pessoas e a matriz de inteiro contendo as relações.
         * Valor gerado: Nulo.
         ****************************************************************
         */
        int opcao;
        boolean erro;
        Scanner ler = new Scanner(System.in);
        System.out.println("Deseja buscar as relações de quem?\nResponda com o número:\n");
        imprimeListaNomes(pessoa);
        System.out.print("\n=> ");
        do{
            opcao = ler.nextInt() - 1;
            erro = opcao < 0 || opcao >= pessoa.length;
            if(erro) System.out.println("Valor inválido!");
        }while(erro);      
        if(calculaAmigos(opcao, matriz) > 0)
        {//Inicio if 
            System.out.println("Os amigos de " + pessoa[opcao] + " são: ");
            for(int coluna = 0; coluna < matriz[0].length; coluna++){
                if(matriz[opcao][coluna] == 1) System.out.println(pessoa[coluna] + "; ");
            }
        }//Fim if
        else System.out.println(pessoa[opcao] + " não tem amigos!");      
        System.out.println();
    }//Fim buscaRelacoes

    public static void quantidadeAmigos(String[] pessoa, int[][] matriz)
    {//Inicio quantidadeAmigos
        /***************************************************************
         * Nome do método: quantidadeAmigos
         * Data da elaboração: 06/05/2018
         * Data da última alteração: 06/05/2018
         * Autor: Luiz Junio <luisjuniorbr@gmail.com>
         * Contexto de ação: Imprimir a quantidade de amigos cadastrados para uma pessoa.
         * Argumentos: Array de nomes e matriz de inteiros contendo as relações de amizade.
         * Valor gerado: Nulo.
         ****************************************************************
         */
        int opcao;
        boolean erro;
        Scanner ler = new Scanner(System.in);
        System.out.println("Deseja calcular a quantidade de amigos de quem?\nResponda com o número:\n");
        imprimeListaNomes(pessoa);
        System.out.print("\n=> ");
        do{
            opcao = ler.nextInt() - 1;
            erro = opcao < 0 || opcao >= pessoa.length;
            if(erro) System.out.println("Valor inválido!");
        }while(erro);      
        System.out.println(pessoa[opcao] + " tem " + calculaAmigos(opcao, matriz) + " amigo(s).");
    }//Fim quantidadeAmigos

    public static int calculaAmigos(int pessoa, int[][] matriz)
    {//inicio calculaAmigos
        /***************************************************************
         * Nome do método: calculaAmigos
         * Data da elaboração: 06/05/2018
         * Data da última alteração: 06/05/2018
         * Autor: Luiz Junio <luisjuniorbr@gmail.com>
         * Contexto de ação: Calcular o número de amigos de uma pessoa cadastrada.
         * Argumentos: Valor inteiro correspondente a pessoa e matriz de inteiros contendo as relações.
         * Valor gerado: Número de amigos.
         ****************************************************************
         */
        int quantidade = 0;   
        for(int coluna = 0; coluna < matriz[0].length; coluna++){
            if(matriz[pessoa][coluna] == 1) quantidade++;
        }
        return quantidade;
    }//Fim calculaAmigos

    public static boolean temAnomalia(int[][] matriz)
    {//Inicio verificaAnomalia
        /***************************************************************
         * Nome do método: verificaAnomalia
         * Data da elaboração: 06/05/2018
         * Data da última alteração: 06/05/2018
         * Autor: Luiz Junio <luisjuniorbr@gmail.com>
         * Contexto de ação: Verifica se há a seguinte anomalia: uma pessoa amiga dela mesma, e corrige.
         * Argumentos: A matriz contendo as relações de amizade.
         * Valor gerado: Verdadeiro se tiver uma anomalia, falso caso contrário.
         ****************************************************************
         */
        int coluna, linha;
        boolean ehAnomalia = false;

        for(coluna = 0; coluna < matriz[0].length; coluna++)
        {//Inicio for
            linha = coluna;
            if(matriz[linha][coluna] == 1)
            {//Inicio if 
                ehAnomalia = true;
                matriz[linha][coluna] = 0;
            }//Fim if 
        }//Fim for 
        return ehAnomalia;
    }//Fim verificaAnomalia

    public static void imprimeListaNomes(String[] nome)
    {//Inicio imprimeListaNomes
        /***************************************************************
         * Nome do método: imprimeListaNomes
         * Data da elaboração: 06/05/2018
         * Data da última alteração: 06/05/2018
         * Autor: Luiz Junio <luisjuniorbr@gmail.com>
         * Contexto de ação: Imprimir uma lista de nomes.
         * Argumentos: Array de string contendo os nomes.
         * Valor gerado: Nulo.
         ****************************************************************
         */
        for(int i = 0; i < nome.length; i++){
            System.out.println( (i+1) + " - " + nome[i] + "; ");
        }
    }//Fim imprimeListaNomes

}//Fim classe RelacoesDeAmizades
