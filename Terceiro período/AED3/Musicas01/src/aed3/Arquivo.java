package aed3;
import java.io.*;
import java.lang.reflect.Constructor;

public class Arquivo<T extends Entidade> {
    
    private RandomAccessFile arquivo;
    private String nomeArquivo;
    private Constructor<T> construtor;
    
    public Arquivo(Constructor<T> c, String nome) throws IOException {
        this.nomeArquivo = nome;
        this.construtor = c;
        arquivo = new RandomAccessFile(this.nomeArquivo, "rw");
        if(arquivo.length()<4)
            arquivo.writeInt(0);
    }
    
    public int incluir(T obj) throws IOException {
        
        int ultimoID;
        arquivo.seek(0);
        ultimoID = arquivo.readInt();
        arquivo.seek(0);
        arquivo.writeInt(ultimoID+1);
        obj.setId(ultimoID+1);
        
        arquivo.seek(arquivo.length());
        byte[] b;
        b = obj.toByteArray();
        arquivo.writeByte(' ');
        arquivo.writeShort(b.length);
        arquivo.write(b);
        return obj.getId();
    }
    
    public T ler(int id) throws Exception {
        T obj = construtor.newInstance();
        short tamanho;
        byte[] b;
        byte lapide;

        arquivo.seek(4);
        while(arquivo.getFilePointer() < arquivo.length()) {
            lapide = arquivo.readByte();
            tamanho = arquivo.readShort();
            b = new byte[tamanho];
            arquivo.read(b);
            obj.fromByteArray(b);
            if(lapide==' ' && obj.getId() == id) {
                return obj;
            }
        }
        return null;
    }
    
    public boolean excluir(int id) throws Exception {
        T obj = construtor.newInstance();
        short tamanho;
        byte[] b;
        byte lapide;
        long endereco;

        arquivo.seek(4);
        while(arquivo.getFilePointer() < arquivo.length()) {
            endereco = arquivo.getFilePointer();
            lapide = arquivo.readByte();
            tamanho = arquivo.readShort();
            b = new byte[tamanho];
            arquivo.read(b);
            obj.fromByteArray(b);
            if(lapide==' ' && obj.getId() == id) {
                arquivo.seek(endereco);
                arquivo.writeByte('*');
                return true;
            }
        }
        return false;
    }
    
    public void listar() throws Exception {
        T obj = construtor.newInstance();
        short tamanho;
        byte[] b;
        byte lapide;

        arquivo.seek(4);
        while(arquivo.getFilePointer() < arquivo.length()) {
            lapide = arquivo.readByte();
            tamanho = arquivo.readShort();
            b = new byte[tamanho];
            arquivo.read(b);
            obj.fromByteArray(b);
            if(lapide==' ')
                System.out.println(obj);
        }
    }
    
}
