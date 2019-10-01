// Aula 16/05/18
import java.util.Scanner;

public class Aula_160518
{//Inicio class Aula_160518
   public static void main(String[]args)
   {//Inicio main 
      Prova p1 = new Prova();      
      Prova p2 = new Prova();
      Prova p3 = new Prova();
      
      p1.setMatricula(1129054);
      p1.setNota(10);
      
      p2.setMatricula(1129055);
      p2.setNota(9.6);
      
      p3.leMatricula();
      p3.leNota();
      
      System.out.println();
      
      System.out.println("Matricula 01: " + p1.getMatricula());
      System.out.println("Nota: " + p1.getNota());
      
      System.out.println("Matricula 02: " + p2.getMatricula());
      System.out.println("Nota: " + p2.getNota());
   
      System.out.println("Matricula 03: " + p3.getMatricula());
      System.out.println("Nota: " + p3.getNota());
   
   }//Fim main   

}//Fim class Aula_160518

class Prova
{//Inicio class Prova

   private int matricula;
   private double nota;
   public static Scanner ler = new Scanner(System.in);
   
   public void leMatricula()
   {//Inicio leMatricula
     
      System.out.print("Digite o numero da matricula: ");
      int matricula = ler.nextInt();
      this.setMatricula(matricula);   
   }//Fim leMatricula
   
   public void leNota()
   {//Inicio leNota
      System.out.print("Digite a nota: ");
      this.nota = ler.nextDouble();
   }//Fim leNota
   
   public void setMatricula(int matricula)
   {//Inicio setMatricula
      this.matricula = matricula;
   }//Fim setMatricula
   
   public void setNota(double nota)
   {//Inicio setNota
      this.nota = nota;
   }//Fim setNota

   public int getMatricula()
   {//Inicio getMatricula
      return this.matricula;
   }//Fim getMatricula
   
   public double getNota()
   {//Inicio getNota
      return this.nota;
   }//Fim getNota
   
}//Fim class Prova