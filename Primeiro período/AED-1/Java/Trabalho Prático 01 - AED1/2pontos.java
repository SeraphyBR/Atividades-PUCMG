// Autor: Luiz Junio <luisjuniorbr@gmail.com>

import java.util.Scanner;

class Pontos { 
   public static void main (String [] args)
   {  
      Scanner s = new Scanner (System.in);
      System.out.print("Digite a coordenada X do ponto A: ");
      double xa = s.nextDouble();
      System.out.print("Digite a coordenada Y do ponto A: ");
      double ya = s.nextDuble();
      System.out.print("Digite a coordenada X do ponto B: ");
      double xb = s.nextDouble();
      System.out.print("Digite a coordenada Y do ponto B: ");
      double dist = Math.sqrt(Math.pow((xa - xb),2) + Math.pow((yb - ya),2));
      System.out.print("A distancia entre o ponto A e B é: " + dist);
   }
}  