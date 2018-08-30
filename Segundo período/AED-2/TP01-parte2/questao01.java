
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

    /**
     * Metodo que le o conteudo de um arquivo.
     * @param arquivo Nome do Arquivo
     * @return Arranjo de String contendo as linhas do arquivo
     */
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
 * Descreve uma instituicao
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
     * Metodo construtor
     */
    public Instituicao()
    {//Inicio construtor vazio
        this(0, "", "");
    }//Fim construtor vazio

    /**
     * Método construtor
     * @param codigo Codigo da Instituicao
     * @param nome Nome da Instituicao
     * @param sigla Sigla da Instituicao
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
     * Metodo construtor para clonar objeto de Instituicao
     * @param instituicao Objeto de Instituicao
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
     * Metodo clone
     * @return Um clone de Instituicao
     */  
    public Instituicao getClone()
    {//Inicio clone
        return new Instituicao(this);
    }//Fim clone 
    
    /**
     * Imprime o conteudo de uma Instituicao
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
     * Le uma String com as informacoes para descrever uma Instituicao
     * @param dados Uma string contendo informacoes da Instituicao
     * @return Uma instituicao
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

    /**
     * Metodo para obter o codigo de uma instituicao
     * @return O codigo da instituicao
     */
    public int getCodigo(){
        return this.codigo;
    }
    /**
     * Atribue um codigo de uma Instituicao
     */
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    /**
     * Metodo para obter o codigo de uma instituicao
     * @return O nome da instituicao
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Atribue um nome de uma instituicao
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Metodo para obter a sigla da instituicao
     * @return A sigla da instituicao
     */
    public String getSigla(){
        return this.sigla;
    }

    /**
     * Atribue uma Sigla de uma Instituicao
     */
    public void setSigla(String sigla){
        this.sigla = sigla;
    }

    /**
     * Metodo para obter o codigo da mantenedora
     * @return O codigo da mantenedora da instituicao
     */
    public int getCodigoMantenedora(){
        return this.codigoMantenedora;
    }

    /**
     * Atribue o Codigo de uma Mantenedora a instituicao
     */
    public void setCodigoMantenedora(int codigoMantenedora){
        this.codigoMantenedora = codigoMantenedora;
    }

    /**
     * Metodo para obter o nome da mantenedora
     * @return O nome da mantenedora
     */
    public String getMantenedora(){
        return this.mantenedora;
    }

    /**
     * Atribue o nome da mantenedora
     */
    public void setMantenedora(String mantenedora){
        this.mantenedora = mantenedora;
    }

    /**
     * Metodo para obter a categoria da instituicao
     * @return A categoria da instituicao
     */
    public int getCategoria(){
        return this.categoria;
    }

    /**
     * Atribue a categoria da instituicao
     */
    public void setCategoria(int categoria){
        this.categoria = categoria;
    }

    /**
     * Metodo para obter o numero da organizacao 
     * @return O numero da organizacao a que a instituicao pertence
     */
    public int getOrganizacao(){
        return this.organizacao;
    }

    /**
     * Atribue o numero da organizacao
     */
    public void setOrganizacao(int organizacao){
        this.organizacao = organizacao;
    }

    /**
     * Metodo para obter o codigo do municipio da instituicao
     * @return O codigo do municipio
     */
    public int getCodigoMunicipio(){
        return this.codigoMunicio;
    }

    /**
     * Atribue o codigo do municipio da instituicao
     */
    public void setCodigoMunicipio(int codigoMunicio){
        this.codigoMunicio = codigoMunicio;
    }

    /**
     * Metodo para obter o nome do municipio
     * @return O nome do municipio
     */
    public String getMunicipio(){
        return this.municipio;
    }

    /**
     * Atribue o nome do municipio da instituicao
     */
    public void setMunicipio(String municipio){
        this.municipio = municipio;
    }

    /**
     * Metodo para obter o Estado do municipio da instituicao
     * @return A unidade federativa
     */
    public String getUF(){
        return this.uf;
    }

    /**
     * Atribue o nome do Estado do municipio da instituicao
     */
    public void setUF(String UF){
        this.uf = UF;
    }

    /**
     * Metodo para obter a Regiao brasileira
     * @return A regiao do Brasil em que esta o Estado do municipio da instituicao
     */
    public String getRegiao(){
        return this.regiao;
    }

    /**
     * Atribue a Regiao brasileira em que esta localizada a instuicao
     */
    public void setRegiao(String regiao){
        this.regiao = regiao;
    }

    /**
     * Metodo para obter o nivel tecnico da instituicao
     * @return Nivel tecnico
     */
    public int getTecnico(){
        return this.tecnico;
    }

    /**
     * Atribue o valor do nivel tecnico
     */
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
