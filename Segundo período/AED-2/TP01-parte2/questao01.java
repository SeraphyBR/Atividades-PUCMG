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



}//Fim classe Instituicao
