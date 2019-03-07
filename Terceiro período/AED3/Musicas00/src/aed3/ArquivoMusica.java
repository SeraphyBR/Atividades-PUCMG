package aed3;
import java.io.*;

public class ArquivoMusica {
    
    private final int TAMANHO_CABECALHO = 4;
    private RandomAccessFile arquivo;
    private String nomeArquivo;
    
    public ArquivoMusica(String nome) throws IOException {
        this.nomeArquivo = nome;
        arquivo = new RandomAccessFile(this.nomeArquivo, "rw");
        if(arquivo.length()<4)
            arquivo.writeInt(0); // último ID usado
    }
    
    public int incluir(Musica m) throws IOException {
        
        int ultimoID;
        arquivo.seek(0);
        ultimoID = arquivo.readInt();
        arquivo.seek(0);
        arquivo.writeInt(ultimoID+1);
        m.id = ultimoID+1;
        
        arquivo.seek(arquivo.length());
        byte[] b;
        b = m.toByteArray();
        arquivo.writeByte(' ');
        arquivo.writeShort(b.length);
        arquivo.write(b);
        return m.id;
    }
    
    public Musica ler(int id) throws IOException {
        Musica m = new Musica();
        short tamanho;
        byte[] b;
        byte lapide;

        arquivo.seek(TAMANHO_CABECALHO);  // salto o cabeçalho
        while(arquivo.getFilePointer() < arquivo.length()) {
            lapide = arquivo.readByte();
            tamanho = arquivo.readShort();
            b = new byte[tamanho];
            arquivo.read(b);
            m.fromByteArray(b);
            if(lapide==' ' && m.id == id) {
                return m;
            }
        }
        return null;
    }
    
    public boolean excluir(int id) throws IOException {
        Musica m = new Musica();
        short tamanho;
        byte[] b;
        byte lapide;
        long endereco;

        arquivo.seek(TAMANHO_CABECALHO);
        while(arquivo.getFilePointer() < arquivo.length()) {
            endereco = arquivo.getFilePointer();
            lapide = arquivo.readByte();
            tamanho = arquivo.readShort();
            b = new byte[tamanho];
            arquivo.read(b);
            m.fromByteArray(b);
            if(lapide==' ' && m.id == id) {
                arquivo.seek(endereco);
                arquivo.writeByte('*');
                return true;
            }
        }
        return false;
    }
    
    public void listar() throws IOException {
        Musica m = new Musica();
        short tamanho;
        byte[] b;
        byte lapide;

        arquivo.seek(TAMANHO_CABECALHO);
        while(arquivo.getFilePointer() < arquivo.length()) {
            lapide = arquivo.readByte();
            tamanho = arquivo.readShort();
            b = new byte[tamanho];
            arquivo.read(b);
            m.fromByteArray(b);
            if(lapide==' ')
                System.out.println(m);
        }
    }
    
}
