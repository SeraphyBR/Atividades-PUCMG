package aed3;
import java.io.*;

public class Musicas00 {

    public static void main(String[] args) {
        
        ArquivoMusica arqMusica;
        File f;
    
        try {
            f = new File("musicas.db");
            f.delete();
            
            arqMusica = new ArquivoMusica("musicas.db");
            
            int id;
            id = arqMusica.incluir( new Musica("Bird of Paradise", "Snowy White", (short)282) );
            System.out.println("Música incluída com ID "+id);
            id = arqMusica.incluir( new Musica("Better Man", "Paolo Nutini", (short)329) );
            System.out.println("Música incluída com ID "+id);
            id = arqMusica.incluir( new Musica("Time After Time", "Iron & Wine", (short)170) );
            System.out.println("Música incluída com ID "+id);
            System.out.println();
            
            System.out.println("\n\nBusca ID=2: \n" + arqMusica.ler(2));            

            System.out.println("\n\nListagem: ");
            arqMusica.listar();

            System.out.println("\n\nExclusão ID=1. ");
            arqMusica.excluir(1);            
            arqMusica.listar();
            
        } catch(Exception e){
            e.printStackTrace();
        }

    }
    
}
