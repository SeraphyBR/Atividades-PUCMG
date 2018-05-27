/*Construa um método que troque dois elementos quaisquer de um arranjo.
Argumentos: Um arranjo de inteiros e dois valores inteiros relativos às duas posições a serem trocadas.
Teste o método criado a partir de main().
*/
import java.util.Scanner; 

public class Exer2 
{//Inicio classe Exer2
    public static void main(String[]args)
    {//Inicio main
        Scanner ler = new Scanner(System.in); 
        int[] arranjo = {1,2,3,4,5,6,7,8,9};
        int p1,p2;
        System.out.print("Arranjo: ");
        imprimeArranjo(arranjo); 
        System.out.println("\nDigite as duas posições do arranjo acima que deseja trocar: ");
        System.out.print("Obs: a primeira posição é o 0.\n=> ");
        p1 = ler.nextInt();
        p2 = ler.nextInt();
        trocaElementosArranjo(arranjo,p1,p2);
        System.out.print("Resultado: ");
        imprimeArranjo(arranjo);
        System.out.println("");
    }//Fim main 

    public static void trocaElementosArranjo(int[] arranjo, int p1, int p2)
    {//Inicio trocaPrimeiroUltimo
        int tmp;
        tmp = arranjo[p1];
        arranjo[p1] = arranjo[p2];
        arranjo[p2] = tmp;
    }//Fim trocaPrimeiroUltimo

    public static void imprimeArranjo(int[] arranjo)
    {//Inicio imprimeArranjo
        for (int cont = 0; cont < arranjo.length; cont ++)
        {
            System.out.print(arranjo[cont] + ", ");
        }
    }//Fim imprimeArranjo

}//Fim classe Exer2