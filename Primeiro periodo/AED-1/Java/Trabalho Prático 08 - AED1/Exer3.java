
import java.util.Scanner; 

public class Exer3 
{//Inicio classe Exer3
    public static void main(String[] args)
    {
        int[] A = {6, 5, 4, 3, 2, 1};
        int[] B = {3, 1, 6, 4, 2, 5};
        int[] C = new int[6];
        leArranjo(C);  // Preenche todo o arranjo com valores lidos
        deslocaMaiorFinal(A);   // Desloca o maior valor do arranjo para a última posição
        deslocaMaiorFinal(B);
        deslocaMaiorFinal(C);
        escreveArranjo(A);   // Escreve na tela todo o arranjo
        escreveArranjo(B);
        escreveArranjo(C);
    } 

    public static void leArranjo(int[] arranjo)
    {//Inicio leArranjo
        Scanner ler = new Scanner(System.in);
        for (int cont = 0; cont < arranjo.length; cont ++)
        {
            System.out.print("Digite o " + (cont + 1) + "º valor do arranjo C: ");
            arranjo[cont] = ler.nextInt();
        }
    }//Fim leArranjo

    public static void deslocaMaiorFinal(int[] arranjo)
    {//Inicio deslocaMaiorFinal
        int tmp;
        int posicaoMaior = posicaoDoMaior(arranjo);
        tmp = arranjo[arranjo.length - 1];
        arranjo[arranjo.length - 1] = arranjo[posicaoMaior];
        arranjo[posicaoMaior] = tmp;
    }//Fim deslocaMaiorFinal

    public static int posicaoDoMaior(int[] arranjo)
    {//Inicio posicaoDoMaior
        int maiorPosi = 0;
        for (int cont = 1; cont < arranjo.length; cont++)
        {
            if (arranjo[cont] > arranjo[maiorPosi]) maiorPosi = cont;
        }
        return maiorPosi;
    }//Fim posicaoDoMaior

    public static void escreveArranjo(int[] arranjo)
    {//Inicio imprimeArranjo
        for (int cont = 0; cont < arranjo.length; cont++)
        {
            System.out.print(arranjo[cont] + ", ");
        }
        System.out.println("");
    }//Fim imprimeArranjo

}//Fim classe Exer3
