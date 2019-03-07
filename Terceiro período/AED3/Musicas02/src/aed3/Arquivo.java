package aed3;
import java.io.*;
import java.lang.reflect.Constructor;

public class Arquivo<T extends Entidade> {
    
    private RandomAccessFile arquivo;
    private String nomeArquivo;
    private String nomeIndice;
    private Constructor<T> construtor;
    private Indice indice;
    
    public Arquivo(Constructor<T> c, String nomeArq, String nomeIdx) throws IOException {
        this.nomeArquivo = nomeArq;
        this.nomeIndice = nomeIdx;
        this.construtor = c;
        arquivo = new RandomAccessFile(this.nomeArquivo, "rw");
        indice = new Indice(20, this.nomeIndice);
        if(arquivo.length()<4) {
            arquivo.writeInt(0);
            indice.apagar();
        }
    }
    
    public int incluir(T obj) throws IOException {
        
        int ultimoID;
        arquivo.seek(0);
        ultimoID = arquivo.readInt();
        arquivo.seek(0);
        arquivo.writeInt(ultimoID+1);
        obj.setId(ultimoID+1);
        
        arquivo.seek(arquivo.length());
        long endereco = arquivo.getFilePointer();
        byte[] b;
        b = obj.toByteArray();
        arquivo.writeByte(' ');
        arquivo.writeShort(b.length);
        arquivo.write(b);
        indice.inserir(obj.getId(), endereco);
        return obj.getId();
    }
    
    public T ler(int id) throws Exception {
        T obj = construtor.newInstance();
        short tamanho;
        byte[] b;
        byte lapide;

        long endereco = indice.buscar(id);
        arquivo.seek(endereco);
        lapide = arquivo.readByte();
        tamanho = arquivo.readShort();
        b = new byte[tamanho];
        arquivo.read(b);
        if(lapide==' ' && obj.getId() == id) {
            return obj;
        }
        return null;
    }
    
    public boolean excluir(int id) throws Exception {
        T obj = construtor.newInstance();
        short tamanho;
        byte[] b;
        byte lapide;
        long endereco;

        endereco = indice.buscar(id);
        arquivo.seek(endereco);
        lapide = arquivo.readByte();
        tamanho = arquivo.readShort();
        b = new byte[tamanho];
        arquivo.read(b);
        obj.fromByteArray(b);
        if(lapide==' ' && obj.getId() == id) {
            arquivo.seek(endereco);
            arquivo.writeByte('*');
            indice.excluir(id);
            return true;
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
