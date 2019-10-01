// Autor: Luiz Junio <luisjuniorbr@gmail.com>
import java.util.Scanner;

public class Amplitude {
    public static void main(String []args){
        Scanner read = new Scanner(System.in);
        int maior = 0,menor = 10000,amplitude,leitura, exec;
        char decisao;
        boolean not_zero;

        do{
            System.out.println("Esse programa irá ler um conjunto de valores inteiros e positivos,");
            System.out.println("e irá imprimir a sua amplitude.");
            do{

                do{
                    System.out.print("Digite um número: ");
                    leitura = read.nextInt();
                    if(leitura < 0) System.out.println("Valor inválido!");
                }while( leitura < 0 );

                not_zero = leitura != 0;
                if (leitura >= maior && not_zero) maior = leitura;
                if( leitura <= menor && not_zero) menor = leitura;

            }while( not_zero );

            if ( maior > 0){
                amplitude = maior - menor;
                System.out.println("O maior valor lido é: " + maior);
                System.out.println("O menor valor lido é: " + menor);
                System.out.println("A amplitude é: " + amplitude);
            }
            else System.out.println("Nenhum valor informado!");

            do{
                exec = 0;
                System.out.print("Deseja repetir o programa? [s/n]: ");
                decisao =  Character.toLowerCase(read.next().charAt(0));
                if ( decisao == 's' ) exec = 1;
                if ( decisao == 'n' ) exec = 2;
            }while(exec == 0);

        }while(exec == 1);
    }  
}   
