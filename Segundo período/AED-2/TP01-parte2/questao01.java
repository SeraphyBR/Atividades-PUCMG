/*
 * Autor: Luiz Junio <luisjuniorbr@gmail.com>
 * Criado em: 20/08/2018
 * Enunciado:   
 */

public class questao01
{//Inicio classe questao01
    public static void main(String[] args)
    {//Inicio main


    }//Fim main

}//Fim classe questao01

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

    Instituicao()
    {//Inicio construtor vazio
        this.setCodigo(0);

    }//Fim construtor vazio

    Instituicao(int codigo)
    {//Inicio construtor 2
        this.setCodigo(codigo);
    }//Fim cosntrutor 2

    public int getCodigo(){
        return this.codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
     
    public String getNome(){
        return this.nome;
    }

    public void setName(String nome){
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
