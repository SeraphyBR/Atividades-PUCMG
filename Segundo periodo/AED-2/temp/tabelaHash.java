/*
 * Autor: Luiz Junio <luisjuniorbr@gmail.com>
 * Criado em: 22/10/2018
 * Modificado em: 29/10/2018
 */

public class tabelaHash
{//Inicio classe tabelaHash
    public static void main(String[] args)
    {//Inicio main
        TabelaHash table = new TabelaHash(240);
        for(int i = 0; i < 256; i++){
            try{
                table.inserir(256 - i);
            }
            catch(Exception ex){
                System.err.println(ex);
            }
        }
        table.mostrar();
    }//Fim main
}//Fim classe tabelaHash

class TabelaHash
{//Inicio tabela hash

    private static final int NULO = -1;
    private int tamanho;
    private int tamanhoReserva;
    private int numElementosReserva;
    private int[] hash;

    public TabelaHash(){
        this(7);
    }

    public TabelaHash(int tamanho){
        this(tamanho, tamanho / 2);
    }

    public TabelaHash(int tamanho, int tamanhoReserva){
        this.tamanho = tamanho;
        this.tamanhoReserva = tamanhoReserva;
        this.numElementosReserva = 0;
        this.hash = new int[tamanho + tamanhoReserva];
        for(int i = 0; i < hash.length; i++){
            this.hash[i] = NULO;
        }
    }

    public int getTamanho(){
        return this.tamanho;
    }

    public int getTamanhoReserva(){
        return this.tamanhoReserva;
    }

    public int posHash(int x){
        return x % this.tamanho;
    }

    private boolean reservaCheia(){
        return numElementosReserva == tamanhoReserva;
    }

    public void inserir(int num) throws Exception
    {//Inicio inserir 
        int posIns = this.posHash(num);
        if(this.hash[posIns] == NULO){
            this.hash[posIns] = num;
        }
        else{
            if(!reservaCheia()){
                this.hash[tamanho + numElementosReserva] = num;
                this.numElementosReserva++;
            }
            else throw new Exception("Nao foi possivel inserir!");
        }
    }//Fim inserir

    public void remover(int num) throws Exception
    {//Inicio remover 
        int posRem = this.posHash(num);
        if(this.hash[posRem] != NULO){
            if(this.hash[posRem] != num){
                throw new Exception("Erro, elemento nao encontrado!");
            }
            else this.hash[posRem] = NULO;
        }
        else throw new Exception("Erro, elemento nao esta presente!");
    }//Fim remover

    public int pesquisar(int num)
    {//Inicio pesquisar 
        int posHash = posHash(num);
        int resp = NULO;

        if(this.hash[posHash] == num){
            resp = posHash;
        }
        else if(this.hash[posHash] != NULO){
            for(int i = 0; i < this.tamanhoReserva; i++){
                if(this.hash[tamanho + i] == num){
                    resp = tamanho + i;
                    i = tamanhoReserva;
                }
            }
        }
        return resp;
    }//Fim pesquisar

    public void mostrar()
    {//Inicio mostrar
        System.out.println("Tabela Hash: ");
        int tmp;
        for(int i = 0; i < tamanho; i++){
            tmp = this.hash[i];
            if(tmp == -1) System.out.println("Vazio");
            else System.out.println(tmp);
        }
        System.out.println("Area reserva: ");
        for(int j = 0; j < numElementosReserva; j++){
            System.out.println(this.hash[tamanho + j]);
        }
    }//Fim mostrar

}//Fim tabela Hash

