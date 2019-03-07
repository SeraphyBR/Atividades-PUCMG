package aed3;
import java.io.IOException;

public interface Entidade {
    public int getId();
    public void setId(int id);
    public byte[] toByteArray() throws IOException;
    public void fromByteArray(byte[] b) throws IOException;   
}
