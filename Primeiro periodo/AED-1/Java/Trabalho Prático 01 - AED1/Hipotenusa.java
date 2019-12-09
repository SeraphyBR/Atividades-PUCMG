// Autor: Luiz Junio <luisjuniorbr@gmail.com>

import java.util.Scanner;

class Hipotenusa {
    public static void main (String [] args)
    {
        Scanner s = new Scanner (System.in);
        System.out.println("O seguinte programa calcula a hipotenusa de um triângulo retângulo.");
        System.out.print("Digite o primeiro cateto: ");
        double cateto_a = s.nextDouble();
        System.out.print("Digite o segundo cateto: ");
        double cateto_b = s.nextDouble();
        double hipotenusa = Math.sqrt((Math.pow(cateto_a,2) + Math.pow(cateto_b,2)));
        System.out.print("O valor da hipotenusa é: " + hipotenusa);
    }
}
