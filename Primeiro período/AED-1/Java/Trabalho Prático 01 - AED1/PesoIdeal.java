// Autor: Luiz Junio <luisjuniorbr@gmail.com>

import java.util.Scanner; 

public class PesoIdeal    
{
    public static void main(String[] args) 
    {   
        Scanner leia = new Scanner(System.in);
        System.out.print("Digite a sua altura em metros: "); 
        double  altura = leia.nextDouble(); 
        System.out.println("Insira o seu sexo.");
        System.out.print("Digite 1 para masculino e 2 para feminino: ");
        int sexo = leia.nextInt();


        if (sexo == 1){ 
            double  peso = (72.7 * altura) - 58 ;
            System.out.printf("Seu o peso ideal é: %.2fkg ", peso);
        }
        if ( sexo == 2 ){ 
            double  peso = (61.1 * altura) - 44.7 ;
            System.out.printf("Seu o peso ideal é: %.2fkg ", peso);
        }
    } 
} 
