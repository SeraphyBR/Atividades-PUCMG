
//Construa um método que troque o primeiro elemento do arranjo com o último.
//Argumento: um arranjo de inteiros.
//Teste o método criado a partir de main()

public class Exer1 
{//Inicio classe Exer1
    public static void main(String[]args)
    {//Inicio main 
        int[] arranjo = {1,2,3,4,5,6,7,8,9};
        for (int cont = 0; cont < arranjo.length; cont ++)
        {
            System.out.print(arranjo[cont] + ", ");
        }
        System.out.println("");
        trocaPrimeiroUltimo(arranjo);
        for (int cont = 0; cont < arranjo.length; cont ++)
        {
            System.out.print(arranjo[cont] + ", ");
        } 
        System.out.println("");
    }//Fim main 

    public static void trocaPrimeiroUltimo(int[] arranjo)
    {//Inicio trocaPrimeiroUltimo
        int tmp;
        tmp = arranjo[0];
        arranjo[0] = arranjo[arranjo.length - 1];
        arranjo[arranjo.length - 1] = tmp;
    }//Fim trocaPrimeiroUltimo


}//Fim classe Exer1