// Autor: Luiz Junio <luisjuniorbr@gmail.com>

import java.util.Scanner;

class Bissexto {
    public static void main (String [] args)
    {
        Scanner s = new Scanner (System.in);
        System.out.print("Digite um ano: ");
        int ano = s.nextInt();

        if ((ano%4 == 0)&&((ano%100 !=0)||(ano%400 == 0))){
            System.out.printf("O ano %d é bissexto.\n",ano);
        }
        else
            System.out.printf("O ano %d não é bissexto.\n",ano);
    }
}
