
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Luiz Junio Veloso Dos Santos
 * @version 1.0
 */
public class questao01
{//Inicio classe questao01
    public static void main(String[] args)
    {//Inicio main
        int[] linha = new int[1000];
        int i = 0;

        do{
            linha[i] = MyIO.readInt();
        }while(linha[i++] != 0);

        i--; //Desconsiderar ultima linha contendo 0

        String[] registro = leArquivo("/tmp/censo.dat");

        Instituicao[] instituicao = new Instituicao[i];

        for(int cont = 0; cont < i; cont++){
            //Ignorando primeira linha do arquivo
            instituicao[cont] = Instituicao.leDados(registro[linha[cont]]);
            instituicao[cont].imprime();
        }
    }//Fim main

    public static String[] leArquivo(String arquivo)
    {//Inicio ler
        String[] linha = new String[3000]; 
        try{
            RandomAccessFile file = new RandomAccessFile(arquivo, "r");
        
            String temp;
            int numEntrada = 0;
            while((temp = file.readLine()) != null)
            {//Inicio while
                linha[numEntrada++] = temp;
            }//Fim while
            file.close();
        }
        catch(FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
        return linha;
    }//Fim ler

}//Fim classe questao01

/**
 * Descreve uma instituição
 * @author Luiz Junio Veloso Dos Santos
 * @version 1.0
 */
class Instituicao
{//Inicio classe Instituicao
    private int codigo;
    private String nome;
    private String sigla;
    private int codigoMantenedora;
    private String mantenedora;
    private int categoria;
    private int organizacao;
    private int codigoMunicio;
    private String municipio;
    private String uf;
    private String regiao;
    private int tecnico;
    private int periodico;
    private int livro;
    private double receita;
    private double transferencia;
    private double outraReceita;
    private double despesaDocente;
    private double despesaTecnico;
    private double despesaEncargo;
    private double despesaCusteio;
    private double despesaInvestimento;
    private double despesaPesquisa;
    private double despesaOutras;

    /**
     * Método construtor
     * 
     */
    public Instituicao()
    {//Inicio construtor vazio
        this(0, "", "");
    }//Fim construtor vazio

    /**
     * Método construtor
     * @param codigo Codigo da Instituição
     * @param nome Nome da Instituição
     * @param sigla Sigla da Instituição
     */
    public Instituicao(int codigo, String nome, String sigla)
    {//Inicio construtor 2
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setSigla(sigla);
        this.setCodigoMantenedora(0);
        this.setMantenedora("");
        this.setCategoria(0);
        this.setOrganizacao(0);
        this.setCodigoMunicipio(0);
        this.setMunicipio("");
        this.setUF("");
        this.setRegiao("");
        this.setTecnico(0);
        this.setPeriodico(0);
        this.setLivro(0);
        this.setReceita(0.0);
        this.setTransferencia(0.0);
        this.setOutraReceita(0.0);
        this.setDespesaDocente(0.0);
        this.setDespesaTecnico(0.0);
        this.setDespesaEncargo(0.0);
        this.setDespesaCusteio(0.0);
        this.setDespesaInvestimento(0.0);
        this.setDespesaPesquisa(0.0);
        this.setDespesaOutras(0.0); 
    }//Fim cosntrutor 2

    /**
     * Método construtor para clonar objeto de Instituição
     * @param instituicao Objeto de Instituição
     */  
    private Instituicao(Instituicao instituicao)
    {//Inicio construtor Clone
        this.setCodigo(              instituicao.getCodigo()                );
        this.setNome(                instituicao.getNome()                  );
        this.setSigla(               instituicao.getSigla()                 );
        this.setCodigoMantenedora(   instituicao.getCodigoMantenedora()     );
        this.setMantenedora(         instituicao.getMantenedora()           );
        this.setCategoria(           instituicao.getCategoria()             );
        this.setOrganizacao(         instituicao.getOrganizacao()           );
        this.setCodigoMunicipio(     instituicao.getCodigoMunicipio()       );
        this.setMunicipio(           instituicao.getMunicipio()             );
        this.setUF(                  instituicao.getUF()                    );
        this.setRegiao(              instituicao.getRegiao()                );
        this.setTecnico(             instituicao.getTecnico()               );
        this.setPeriodico(           instituicao.getPeriodico()             );
        this.setLivro(               instituicao.getLivro()                 );
        this.setReceita(             instituicao.getReceita()               );
        this.setTransferencia(       instituicao.getTransferencia()         );
        this.setOutraReceita(        instituicao.getOutraReceita()          );
        this.setDespesaDocente(      instituicao.getDespesaDocente()        );
        this.setDespesaTecnico(      instituicao.getDespesaTecnico()        );
        this.setDespesaEncargo(      instituicao.getDespesaEncargo()        );
        this.setDespesaCusteio(      instituicao.getDespesaCusteio()        );
        this.setDespesaInvestimento( instituicao.getDespesaInvestimento()   );
        this.setDespesaPesquisa(     instituicao.getDespesaPesquisa()       );
        this.setDespesaOutras(       instituicao.getDespesaOutras()         );
    }//Fim construtor Clone

    /**
     * Método clone
     * @return Um clone de Instituicao
     */  
    public Instituicao getClone()
    {//Inicio clone
        return new Instituicao(this);
    }//Fim clone 
    
    /**
     * Imprime o conteudo de uma Instituição
     */  
    public void imprime()
    {//Inicio imprime
        MyIO.println(
        //Inicio println
            this.getCodigo() + " " + this.getNome() + " " + this.getSigla() + " " +
            this.getCodigoMantenedora() + " " + this.getMantenedora() + " " +
            this.getCategoria() + " " + this.getOrganizacao() + " " + 
            this.getCodigoMunicipio() + " " + this.getMunicipio() + " " + this.getUF() + " " +
            this.getRegiao() + " " + this.getTecnico() + " " + this.getPeriodico() + " " +
            this.getLivro() + " " + this.getReceita() + " " + this.getTransferencia() + " " +
            this.getOutraReceita() + " " + this.getDespesaDocente() + " " +
            this.getDespesaTecnico() + " " + this.getDespesaEncargo() + " " +
            this.getDespesaCusteio() + " " + this.getDespesaInvestimento() + " " +
            this.getDespesaPesquisa() + " " + this.getDespesaOutras()
        );//Fim println
    }//Fim imprime

    /**
     * Lê uma String com as informações para descrever uma Instituição
     * @param dados Uma string contendo informações da Instituição
     * @return Uma instituição
     */
    public static Instituicao leDados(String dados)
    {//Inicio leDados
        Instituicao instituicao = new Instituicao();
        //Separa em varias strings, cortando os Tabs da String dados
        String[] valor = dados.split("\\t", 24);
        instituicao.setCodigo(Integer.parseInt(valor[0]));
        instituicao.setNome(valor[1]);
        instituicao.setSigla(valor[2]);
        instituicao.setCodigoMantenedora(Integer.parseInt(valor[3]));
        instituicao.setMantenedora(valor[4]);
        instituicao.setCategoria(Integer.parseInt(valor[5]));
        instituicao.setOrganizacao(Integer.parseInt(valor[6]));
        instituicao.setCodigoMunicipio(Integer.parseInt(valor[7]));
        instituicao.setMunicipio(valor[8]);
        instituicao.setUF(valor[9]);
        instituicao.setRegiao(valor[10]);
        instituicao.setTecnico(Integer.parseInt(valor[11]));
        instituicao.setPeriodico(Integer.parseInt(valor[12]));
        instituicao.setLivro(Integer.parseInt(valor[13]));
        instituicao.setReceita(Double.parseDouble(valor[14]));
        instituicao.setTransferencia(Double.parseDouble(valor[15]));
        instituicao.setOutraReceita(Double.parseDouble(valor[16]));
        instituicao.setDespesaDocente(Double.parseDouble(valor[17]));
        instituicao.setDespesaTecnico(Double.parseDouble(valor[18]));
        instituicao.setDespesaEncargo(Double.parseDouble(valor[19]));
        instituicao.setDespesaCusteio(Double.parseDouble(valor[20]));
        instituicao.setDespesaInvestimento(Double.parseDouble(valor[21]));
        instituicao.setDespesaPesquisa(Double.parseDouble(valor[22]));
        instituicao.setDespesaOutras(Double.parseDouble(valor[23])); 
        return instituicao;
    }//Fim leDados

    public int getCodigo(){
        return this.codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
     
    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSigla(){
        return this.sigla;
    }

    public void setSigla(String sigla){
        this.sigla = sigla;
    }

    public int getCodigoMantenedora(){
        return this.codigoMantenedora;
    }

    public void setCodigoMantenedora(int codigoMantenedora){
        this.codigoMantenedora = codigoMantenedora;
    }

    public String getMantenedora(){
        return this.mantenedora;
    }

    public void setMantenedora(String mantenedora){
        this.mantenedora = mantenedora;
    }

    public int getCategoria(){
        return this.categoria;
    }

    public void setCategoria(int categoria){
        this.categoria = categoria;
    }

    public int getOrganizacao(){
        return this.organizacao;
    }

    public void setOrganizacao(int organizacao){
        this.organizacao = organizacao;
    }

    public int getCodigoMunicipio(){
        return this.codigoMunicio;
    }

    public void setCodigoMunicipio(int codigoMunicio){
        this.codigoMunicio = codigoMunicio;
    }

    public String getMunicipio(){
        return this.municipio;
    }

    public void setMunicipio(String municipio){
        this.municipio = municipio;
    }

    public String getUF(){
        return this.uf;
    }

    public void setUF(String UF){
        this.uf = UF;
    }

    public String getRegiao(){
        return this.regiao;
    }

    public void setRegiao(String regiao){
        this.regiao = regiao;
    }

    public int getTecnico(){
        return this.tecnico;
    }

    public void setTecnico(int tecnico){
        this.tecnico = tecnico;
    }

    public int getPeriodico(){
        return this.periodico;
    }

    public void setPeriodico(int periodico){
        this.periodico = periodico;
    }

    public int getLivro(){
        return this.livro;
    }

    public void setLivro(int livro){
        this.livro = livro;
    }

    public double getReceita(){
        return this.receita;
    }

    public void setReceita(double receita){
        this.receita = receita;
    }

    public double getTransferencia(){
        return this.transferencia;
    }

    public void setTransferencia(double transferencia){
        this.transferencia = transferencia;
    }
     
    public double getOutraReceita(){
        return this.outraReceita;
    }

    public void setOutraReceita(double outraReceita){
        this.outraReceita = outraReceita;
    }

    public double getDespesaDocente(){
        return this.despesaDocente;
    }

    public void setDespesaDocente(double despesaDocente){
        this.despesaDocente = despesaDocente;
    }

    public double getDespesaTecnico(){
        return this.despesaTecnico;
    }

    public void setDespesaTecnico(double despesaTecnico){
        this.despesaTecnico = despesaTecnico;
    }

    public double getDespesaEncargo(){
        return this.despesaEncargo;
    }

    public void setDespesaEncargo(double despesaEncargo){
        this.despesaEncargo = despesaEncargo;
    }

    public double getDespesaCusteio(){
        return this.despesaCusteio;
    }

    public void setDespesaCusteio(double despesaCusteio){
        this.despesaCusteio = despesaCusteio;
    }

    public double getDespesaInvestimento(){
        return this.despesaInvestimento;
    }

    public void setDespesaInvestimento(double despesaInvestimento){
        this.despesaInvestimento = despesaInvestimento;
    }

    public double getDespesaPesquisa(){
        return this.despesaPesquisa;
    }

    public void setDespesaPesquisa(double despesaPesquisa){
        this.despesaPesquisa = despesaPesquisa;
    }

    public double getDespesaOutras(){
        return this.despesaOutras;
    }

    public void setDespesaOutras(double despesaOutras){
        this.despesaOutras = despesaOutras;
    }
     

}//Fim classe Instituicao
