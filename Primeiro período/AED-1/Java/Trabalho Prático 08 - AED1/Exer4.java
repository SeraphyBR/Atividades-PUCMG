
import java.util.Scanner; 

public class Exer4 
{//Inicio classe Exer4
    public static void main(String[] args) {
    int[] A = {6, 5, 4, 3, 2, 1};
    int[] B = {3, 1, 6, 4, 2, 5};
    int[] C = new int[6];
    leArranjo(C);  // Preenche todo o arranjo com valores lidos
    ordena(A);   // Desloca o maior valor do arranjo para a última posição, n vezes, até ordenar
    ordena(B);
    ordena(C);
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

    public static void ordena(int[] arranjo)
    {//Inicio ordena  
        int cont1, cont2, tmp;  
        for(cont1 = 0; cont1 < arranjo.length; cont1++)
        {  
            for(cont2 = cont1 + 1; cont2 < arranjo.length; cont2++)
            {  
               if(arranjo[cont1] > arranjo[cont2])
               {  
                    tmp = arranjo[cont2];  
                    arranjo[cont2] = arranjo[cont1];  
                    arranjo[cont1] = tmp;  
                }  
            }  
        }              
   }//Fim ordena      

    

    public static void escreveArranjo(int[] arranjo)
    {//Inicio imprimeArranjo
        for (int cont = 0; cont < arranjo.length; cont++)
        {
            System.out.print(arranjo[cont] + ", ");
        }
        System.out.println("");
    }//Fim imprimeArranjo

}//Fim classe Exer4