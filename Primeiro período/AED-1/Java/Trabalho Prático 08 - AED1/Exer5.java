/*
Construa um programa que calcule e escreva o número de alunos em uma turma com idade superior à idade média da turma.
A leitura das idades deverá se repetir até que uma idade igual a zero seja lida (flag).
Rejeitar a leitura de idades inválidas. Considere o domínio: 0..150
Um método deverá ficar encarregado de ler uma idade.
Um método deverá ficar encarregado de calcular a idade média da turma (este deve chamar a soma).
Um método deverá ficar encarregado de calcular o número de alunos com idade acima da média das idades da turma (este deve chamar o método que calcula a média).
Fique à vontade para projetar outros métodos auxiliares.
*/
import java.util.Scanner;

public class Exer5 
{//Inicio Exer5
    public static void main(String[]args)
    {//Inicio main
        int[] idade = new int[100];
        int cont = 0, tmp;
        tmp = leIdade();
        while(cont < 100 && tmp != 0)
        {
            idade[cont] = tmp;
            tmp = leIdade();
            cont++;
        }
        System.out.println("O numero de alunos com idade maior que a idade média da turma: " + alunosIdadeAcimaDaMedia(idade,cont));
    }//Fim main 

    public static int leIdade()
    {//Inicio leIdade
        Scanner ler = new Scanner(System.in);
        boolean erro;
        int idade;
        do{
            System.out.print("Digite uma idade: ");
            idade = ler.nextInt();
            erro = idade < 0 || idade > 150;
            if(erro) System.out.println("Valor inválido!");
        }while(erro);
        return idade;
    }//Fim leIdade
    
    public static double idadeMediaTurma(int[] arranjo, int alunos)
    {//Inicio idadeMediaTurma
        double media;
        int soma = somaIdade(arranjo);
        media = (double) soma / (double) alunos;
        return media;
    }//Fim idadeMediaTurma

    public static int alunosIdadeAcimaDaMedia(int[] arranjo, int alunos)
    {//Inicio alunosIdadeAcimaDaMedia
        double idadeMedia = idadeMediaTurma(arranjo,alunos);
        int alunosAcima = 0;
        for(int cont = 0; cont < arranjo.length; cont++ )
        {
            if (arranjo[cont] > idadeMedia ) alunosAcima++; 
        }
        return alunosAcima;
    }//Fim alunosIdadeAcimaDaMedia

    public static int somaIdade(int[] arranjo)
    {//Inicio somaIdade
        int soma = 0;
        for(int cont = 0; cont < arranjo.length; cont++)
        {
            soma += arranjo[cont];
        }
        return soma;
    }//Fim somaIdade

}//Fim Exer5