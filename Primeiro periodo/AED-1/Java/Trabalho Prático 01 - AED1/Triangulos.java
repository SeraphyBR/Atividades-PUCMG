// Autor: Luiz Junio <luisjuniorbr@gmail.com>

import java.util.Scanner;

class Triangulos { 
    public static void main (String [] args)
    {
        Scanner s = new Scanner (System.in);
        System.out.print("Digite o primeiro lado do triângulo: ");
        double ladoA = s.nextDouble();
        System.out.print("Digite o segundo lado do triângulo: ");
        double ladoB = s.nextDouble();
        System.out.print("Digite o terceiro lado do triângulo: ");
        double ladoC = s.nextDouble();

        boolean caso1, caso2, caso3, valido;

        /* Para construir um triângulo é necessário que a medida de qualquer um dos lados seja 
           menor que a soma das medidas dos outros dois e maior que o valor absoluto da diferença
           entre essas medidas.
           1 - | b - c | < a < b + c
           2 - | a - c | < b < a + c
           3 - | a - b | < c < a + b 
           */

        if ( ladoA < ( ladoB + ladoC)){
            if ( Math.abs(ladoB-ladoC) < ladoA){
                caso1 = true;
            }
            else 
                caso1 = false;
        }
        else 
            caso1 = false;

        if ( ladoB < ( ladoA + ladoC)){
            if ( Math.abs(ladoA-ladoC) < ladoB){
                caso2 = true;
            }
            else 
                caso2 = false;
        }
        else 
            caso2 = false;   

        if ( ladoC < ( ladoA + ladoB)){
            if ( Math.abs(ladoA-ladoB) < ladoC){
                caso3 = true;
            }
            else 
                caso3 = false;
        }
        else 
            caso3 = false;   


        if ( caso1 && caso2 && caso3 ){
            System.out.println("Os valores condizem com um triângulo válido. ");
            valido = true;
            if ( (ladoA != ladoB) && (ladoA != ladoC) && (ladoB != ladoC)){
                System.out.print("O triângulo é escanelo.");
            }
            else if ((ladoA == ladoB) && (ladoA == ladoC) && (ladoB == ladoC)){
                System.out.print("O triângulo é equilátero. ");
            }
            else if ((ladoA == ladoB) || (ladoA == ladoC) || (ladoB == ladoC)){
                System.out.print("O triângulo é isoscéles. ");
            }
        }
        else 
            System.out.print("Os valores condizem com um triângulo inválido ");
        valido = false;

    }        
}       
