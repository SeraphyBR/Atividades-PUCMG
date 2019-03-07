package aed3;
import java.io.*;

public class Musica implements Entidade {
    
    protected int id;
    protected String nome;
    protected String artista;
    protected short duracao; // em segundos
    
    public Musica(String nome, String artista, short duracao) {
        this.id = -1;
        this.nome = nome;
        this.artista = artista;
        this.duracao = duracao;
    }
    
    public Musica() {
        this.id = -1;
        this.nome = "";
        this.artista = "";
        this.duracao = 0;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String toString() {
        return "Id: " + this.id +
               "\nNome: " + this.nome +
               "\nArtista: " + this.artista +
               "\nDuração: " + this.duracao + " segundos.\n";
    }
    
    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream dados = new ByteArrayOutputStream();
        DataOutputStream saida = new DataOutputStream(dados);
        saida.writeInt(this.id);
        saida.writeUTF(this.nome);
        saida.writeUTF(this.artista);
        saida.writeShort(this.duracao);
        return dados.toByteArray();
    }
    
    public void fromByteArray(byte[] b) throws IOException {
        ByteArrayInputStream dados = new ByteArrayInputStream(b);
        DataInputStream entrada = new DataInputStream(dados);
        this.id = entrada.readInt();
        this.nome = entrada.readUTF();
        this.artista = entrada.readUTF();
        this.duracao = entrada.readShort();        
    }
    
}
