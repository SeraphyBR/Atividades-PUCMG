
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * @author Luiz Junio Veloso Dos Santos
 * @version 1.2
 */            
public class questao04
{//Inicio classe questao01
    public static void main(String[] args)
    {//Inicio main
        long tempoInicial = 0;
        long tempoFinal = 0;
        try
        {//Inicio try
            int[] linha = new int[1000];
            int i = 0;

            //Inicio parte 1
            do{
                linha[i] = MyIO.readInt();
            }while(linha[i++] != 0);

            i--; //Desconsiderar ultima linha contendo 0

            String[] registro = leArquivo("/tmp/censo.dat");

            ArvoreBicolor arv = new ArvoreBicolor();

            for(int cont = 0; cont < i; cont++){
                try{
                    arv.inserir(new Instituicao(registro[linha[cont]]));
                }
                catch(Exception exception){}
            }

            //Inicio Parte 2
            String sigla;
            boolean ehFIM = false;
            tempoInicial = System.currentTimeMillis();
            do{
                sigla = MyIO.readLine();
                if(sigla.equals("FIM"))
                    ehFIM = true;
                else{
                    MyIO.print(sigla + " ");
                    imprimeBool(arv.pesquisar(sigla));
                }
            }while(!ehFIM);
            tempoFinal = System.currentTimeMillis();
        }//Fim try
        catch(Exception exception){
            System.err.println(exception);
        }

        Arq.openWrite("624037_arvoreBinaria.txt");//Abrindo arquivo de Log para escrita
        Arq.print("624037" + "\t" + (tempoFinal - tempoInicial) + "\t" + Conta.getNumComparacoes());
        Arq.close();
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

    public static void imprimeBool(boolean bool)
    {//Inicio booleanToString
        MyIO.println(bool ? "SIM" : "NÃO");
    }//Fim booleanToString
}//Fim classe questao01

/**
 * Descreve uma Instituicao de Ensino Superior (IES)
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
    }//Fim construtor 2

    /**
     * Metodo construtor
     * @param dados Uma string contendo dados de uma IES separadas por Tabs
     */
    public Instituicao(String dados)
    {//Inicio construtor 3 String
        //Separa em varias strings, cortando os Tabs da String dados
        String[] valor = dados.split("\\t", 24);
        this.setCodigo(Integer.parseInt(valor[0]));
        this.setNome(valor[1]);
        this.setSigla(valor[2]);
        this.setCodigoMantenedora(Integer.parseInt(valor[3]));
        this.setMantenedora(valor[4]);
        this.setCategoria(Integer.parseInt(valor[5]));
        this.setOrganizacao(Integer.parseInt(valor[6]));
        this.setCodigoMunicipio(Integer.parseInt(valor[7]));
        this.setMunicipio(valor[8]);
        this.setUF(valor[9]);
        this.setRegiao(valor[10]);
        this.setTecnico(Integer.parseInt(valor[11]));
        this.setPeriodico(Integer.parseInt(valor[12]));
        this.setLivro(Integer.parseInt(valor[13]));
        this.setReceita(Double.parseDouble(valor[14]));
        this.setTransferencia(Double.parseDouble(valor[15]));
        this.setOutraReceita(Double.parseDouble(valor[16]));
        this.setDespesaDocente(Double.parseDouble(valor[17]));
        this.setDespesaTecnico(Double.parseDouble(valor[18]));
        this.setDespesaEncargo(Double.parseDouble(valor[19]));
        this.setDespesaCusteio(Double.parseDouble(valor[20]));
        this.setDespesaInvestimento(Double.parseDouble(valor[21]));
        this.setDespesaPesquisa(Double.parseDouble(valor[22]));
        this.setDespesaOutras(Double.parseDouble(valor[23])); 
    }//Fim construtor 3 String

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
     * Imprime os dados de uma Instituicao de Ensino Superior
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
     * Metodo para obter o Codigo unico de identificacao da IES
     * @return O codigo unico de identificacao da IES
     */
    public int getCodigo(){
        return this.codigo;
    }
    /**
     * Atribue o codigo unico de identificacao da IES
     */
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    /**
     * Metodo para obter o Nome da IES
     * @return O nome da instituicao
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Atribue um nome da IES
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Metodo para obter a sigla da IES
     * @return A sigla da instituicao
     */
    public String getSigla(){
        return this.sigla;
    }

    /**
     * Atribue uma Sigla de uma IES
     */
    public void setSigla(String sigla){
        this.sigla = sigla;
    }

    /**
     * Metodo para obter o codigo unico de identificacao da mantenedora
     * @return O codigo da mantenedora da instituicao
     */
    public int getCodigoMantenedora(){
        return this.codigoMantenedora;
    }

    /**
     * Atribue o Codigo unico de identificacao da mantenedora
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
     * Metodo para obter o codigo da categoria administrativa da IES
     * @return A categoria da instituicao
     */
    public int getCategoria(){
        return this.categoria;
    }

    /**
     * Atribue o codigo da categoria administrativa da IES
     */
    public void setCategoria(int categoria){
        this.categoria = categoria;
    }

    /**
     * Metodo para obter o codigo da organizacao academica 
     * @return O codigo da organizacao academica
     */
    public int getOrganizacao(){
        return this.organizacao;
    }

    /**
     * Atribue o codigo da organizacao academica
     */
    public void setOrganizacao(int organizacao){
        this.organizacao = organizacao;
    }

    /**
     * Metodo para obter o codigo do municipio da IES (reitoria/sede)
     * @return O codigo do municipio
     */
    public int getCodigoMunicipio(){
        return this.codigoMunicio;
    }

    /**
     * Atribue o codigo do municipio da IES (reitoria/sede)
     */
    public void setCodigoMunicipio(int codigoMunicio){
        this.codigoMunicio = codigoMunicio;
    }

    /**
     * Metodo para obter o nome do municipio da IES (reitoria/sede)
     * @return O nome do municipio
     */
    public String getMunicipio(){
        return this.municipio;
    }

    /**
     * Atribue o nome do municipio da IES (reitoria/sede)
     */
    public void setMunicipio(String municipio){
        this.municipio = municipio;
    }

    /**
     * Metodo para obter a sigla da Unidade federativa do municipio da IES
     * @return A unidade federativa
     */
    public String getUF(){
        return this.uf;
    }

    /**
     * Atribue a sigla da Unidade federativa do municipio da IES
     */
    public void setUF(String UF){
        this.uf = UF;
    }

    /**
     * Metodo para obter a Regiao brasileira
     * @return A regiao do Brasil em que esta o municipio da IES
     */
    public String getRegiao(){
        return this.regiao;
    }

    /**
     * Atribue a Regiao brasileira em que esta localizada a IES
     */
    public void setRegiao(String regiao){
        this.regiao = regiao;
    }

    /**
     * Metodo para obter o numero de funcionarios tecnico-administrativos
     * @return O numero de funcionarios tecnico-administrativos da IES
     */
    public int getTecnico(){
        return this.tecnico;
    }

    /**
     * Atribue o numero de funcionarios tecnico-administrativos
     */
    public void setTecnico(int tecnico){
        this.tecnico = tecnico;
    }

    /**
     * Metodo para obter a Quantidade de titulos de periodicos eletronicos
     * adquiridos pela biblioteca da IES por meio de compra, doação ou permuta.
     * @return A quantidade de titulos de periodicos eletronicos adquiridos pela IES
     */
    public int getPeriodico(){
        return this.periodico;
    }

    /**
     * Atribue a Quantidade de titulos de periódicos eletronicos adquiridos
     * pela biblioteca da IES por meio de compra, doacao ou permuta. 
     */
    public void setPeriodico(int periodico){
        this.periodico = periodico;
    }

    /**
     * Metodo para obter a Quantidade de titulos de livros eletronicos
     * disponibilizados pela biblioteca convertidos ao formato digital 
     * ou originalmente produzidos nesse formato para serem lidos em computador
     * ou outros dispositivos.
     * @return A quantidade de titulos de livros eletronicos digitais da IES
     */
    public int getLivro(){
        return this.livro;
    }

    /**
     * Atribue a Quantidade de títulos de livros eletrônicos
     * disponibilizados pela biblioteca convertidos ao formato digital
     * ou originalmente produzidos nesse formato para serem lidos em computador
     * ou outros dispositivos.
     */
    public void setLivro(int livro){
        this.livro = livro;
    }

    /**
     * Metodo para obter o valor das receitas proprias auferidas 
     * pela Mantenedora ou pela IES no ano de referencia
     * @return O valor das receitas proprias auferidas pela mantenedora ou IES
     */
    public double getReceita(){
        return this.receita;
    }

    /**
     * Atribue o valor das receitas proprias auferidas
     * pela Mantenedora ou pela IES no ano de referencia
     */
    public void setReceita(double receita){
        this.receita = receita;
    }

    /**
     * Metodo para obter o valor de transferencias auferidas
     * pela Mantenedora ou pela IES no ano de referencia
     * @return O valor de transferenciaas auferidas
     */
    public double getTransferencia(){
        return this.transferencia;
    }

    /**
     * Atribue o valor de transferências auferidas
     * pela Mantenedora ou pela IES no ano de referência
     */
    public void setTransferencia(double transferencia){
        this.transferencia = transferencia;
    }

    /**
     * Metodo para obter o valor de outras receitas auferidas
     * pela Mantenedora ou pela IES no ano de referencia.
     * @return O valor de outras receitas auferidas
     */
    public double getOutraReceita(){
        return this.outraReceita;
    }

    /**
     * Atribue o valor de outras receitas auferidas
     * pela Mantenedora ou pela IES no ano de referencia.
     *
     */
    public void setOutraReceita(double outraReceita){
        this.outraReceita = outraReceita;
    }

    /**
     * Metodo para obter as despesas com remuneracao de pessoal - docentes
     * ativos da IES ou da mantenedora.
     * @return As despesas com remuneracao de docentes
     */
    public double getDespesaDocente(){
        return this.despesaDocente;
    }

    /**
     * Atribue o valor das despesas com remuneracao de pessoal - docentes
     * ativos da IES ou da mantenedora.
     */
    public void setDespesaDocente(double despesaDocente){
        this.despesaDocente = despesaDocente;
    }

    /**
     * Metodo para obter as despesas com remuneração de pessoal
     * tecnico-administrativo/pedagogicos da IES ou da mantenedora.
     * @return As despesas com remuneracao de pessoal tecnico-administrativo/pedagogicos 
     */
    public double getDespesaTecnico(){
        return this.despesaTecnico;
    }

    /**
     * Atribue o valor das despesas com remuneração de pessoal
     * tecnico-administrativo/pedagogicos da IES ou da mantenedora.
     */
    public void setDespesaTecnico(double despesaTecnico){
        this.despesaTecnico = despesaTecnico;
    }

    /**
     * Metodo para obter as despesas com beneficios e encargos sociais
     * de todo o pessoal da IES ou da mantenedora.
     * @return As despesas com beneficios e engargos sociais
     */
    public double getDespesaEncargo(){
        return this.despesaEncargo;
    }

    /**
     * Atribue o valor das despesas com beneficios e encargos sociais
     * de todo o pessoal da IES ou da mantenedora.
     */
    public void setDespesaEncargo(double despesaEncargo){
        this.despesaEncargo = despesaEncargo;
    }

    /**
     * Metodo para obter as despesas para a manutencao 
     * e custeio da IES ou da mantenedora
     * (Não inclui  despesas com pessoal.)
     * @return As despesas para manutencao
     */
    public double getDespesaCusteio(){
        return this.despesaCusteio;
    }

    /**
     * Atribue o valor das despesas para a manutencao
     * e custeio da IES ou da mantenedora
     * (Não inclui  despesas com pessoal.)
     */
    public void setDespesaCusteio(double despesaCusteio){
        this.despesaCusteio = despesaCusteio;
    }

    /**
     * Metodo para obter as despesas de investimentos (despesas de capital)
     * realizadas nas IES ou na mantenedora.
     * @return As despesas de investimentos 
     */
    public double getDespesaInvestimento(){
        return this.despesaInvestimento;
    }

    /**
     * Atribue o valor das despesas de investimentos (despesas de capital)
     * realizadas nas IES ou na mantenedora.
     */
    public void setDespesaInvestimento(double despesaInvestimento){
        this.despesaInvestimento = despesaInvestimento;
    }

    /**
     * Metodo para obter as despesas com Pesquisa e Desenvolvimento
     * da IES ou da mantenedora.
     * @return As despesas com pesquisa e investimento
     */
    public double getDespesaPesquisa(){
        return this.despesaPesquisa;
    }

    /**
     * Atribue o valor das despesas com Pesquisa e Desenvolvimento
     * da IES ou da mantenedora.
     */
    public void setDespesaPesquisa(double despesaPesquisa){
        this.despesaPesquisa = despesaPesquisa;
    }

    /**
     * Metodo para obter o valor de dispendios 
     * nao contemplados nos demais campos relativos a despesa
     * @return O valor de dispendios nao contemplados nos demais campos
     */
    public double getDespesaOutras(){
        return this.despesaOutras;
    }

    /**
     * Atribue o valor de dispendios
     * nao contemplados nos demais campos relativos a despesa
     */
    public void setDespesaOutras(double despesaOutras){
        this.despesaOutras = despesaOutras;
    }

}//Fim classe Instituicao

/**
 * No colorido binario de Instituicao
 * @author Luiz Junio Veloso Dos Santos
 */
class No
{//Inicio classe No Instituicao

    public boolean cor;
    public Instituicao elemento; // Counteudo do No
    public No esq, dir;

    /**
     *  Construtor da classe.
     *  @param elemento Conteudo do No.
     */
    public No(Instituicao elemento){
        this(elemento, null, null, false);
    }

    /**
     * Construtor da classe.
     * @param elemento Conteudo do No.
     * @param cor Cor do No
     */
    public No(Instituicao elemento, boolean cor){
        this(elemento, null, null, cor);
    }

    /**
     *  Construtor da classe. 
     *  @param elemento Conteudo do No. 
     *  @param esq No da esquerda.
     *  @param dir No da direita.
     *  @param cor A cor do No.
     */
    public No(Instituicao elemento, No esq, No dir, boolean cor){
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.cor = cor;
    }

}//Fim classe No Instituicao

/**
 * Arvore colorida binaria de pesquisa 
 * @author Luiz Junio Veloso Dos Santos 
 */
class ArvoreBicolor
{//Inicio classe ArvoreBinaria

    // Cores da arvore:
    private final static boolean preto = true;
    private final static boolean branco = false;

    // Raiz da arvore
    private No raiz;

    /**
     * Construtor da classe
     */
    public ArvoreBicolor(){
        raiz = null;
    }

    /**
     * Metodo publico iterativo para pesquisar elemento.
     * @param sigla Sigla da Instituicao que sera procurado.
     * @return <code>true</code> Se o elemento existir,
     * <code>false</code> em caso contrario.
     */
    public boolean pesquisar(String sigla){
        MyIO.print("raiz ");
        return this.pesquisar(sigla, raiz);
    }
    
    /**
     * Metodo privado recursivo para pesquisar elemento. 
     * @param sigla Sigla da Instituicao que sera procurado.
     * @param atual No em analise.
     * @return <code>true</code> se o elemento existir,
     * <code>
     */
    private boolean pesquisar(String sigla, No atual)
    {//Inicio pesquisar 
        boolean resultado;
        if(atual == null){
            resultado = false;
        }
        else if(sigla.compareTo(atual.elemento.getSigla()) == 0){
            resultado = true;
            Conta.somaComparacoes();
        }
        else if(sigla.compareTo(atual.elemento.getSigla()) < 0){
            MyIO.print("esq ");
            resultado = pesquisar(sigla, atual.esq);
            Conta.somaComparacoes();
        }
        else {
            MyIO.print("dir ");
            resultado = pesquisar(sigla, atual.dir);
        }
        return resultado;
    }//Fim pesquisar

    /**
     *  Metodo publico iterativo para exibir elementos.
     */
    public void mostrarCentral(){
        System.out.print("[ ");
        this.mostrarCentral(raiz);
        System.out.println("]");
    }

    /**
     *  Metodo privado recursivo para exibir elementos.
     *  @param i No em analise.
     */
    private void mostrarCentral(No i){
        if(i != null){
            this.mostrarCentral(i.esq); // Elementos da esquerda
            i.elemento.imprime();       // Conteudo do no
            this.mostrarCentral(i.dir); // Elementos da direita
        }
    }

    /**
     *  Metodo publico iterativo para exibir elementos.
     */
    public void mostrarPre(){
        System.out.print("[ ");
        this.mostrarPre(raiz);
        System.out.println("]");
    }

    /**
     *  Metodo privado recursivo para exibir elementos.
     */
    private void mostrarPre(No i){
        if(i != null){
            i.elemento.imprime();   // Conteudo do no
            this.mostrarPre(i.esq); // Elementos da esquerda 
            this.mostrarPre(i.dir); // Elementos da direita 
        }
    }

    /**
     *  Metodo publico iterativo para exibir Instituicoes.
     */
    public void mostrarPos(){
        System.out.print("[ ");
        this.mostrarPos(raiz);
        System.out.println("]");
    }

    /**
     *  Metodo privado recursivo para exibir Instituicoes.
     *  @param i No em analise.
     */
    private void mostrarPos(No i){
        if(i != null){
            this.mostrarPos(i.esq);
            this.mostrarPos(i.dir);
            i.elemento.imprime();
        }
    }


    /**
     *  Metodo publico iterativo para inserir Instituicao.
     *  @param inst Instituicao a ser inserido.
     */
    public void inserir(Instituicao elemento)
    {//Inicio inserir iterativo

        // Se a arvore estiver vazia
        if(raiz == null) raiz = new No(elemento, branco);

        // Senao, se a arvore tiver um elemento
        else if(raiz.esq == null && raiz.dir == null)
        {//Inicio else if 1
            if(raiz.elemento.getSigla().compareTo(elemento.getSigla()) > 0){
                raiz.esq = new No(elemento, preto);
            }
            else raiz.dir = new No(elemento, preto);
        }//Fim else if 1

        // Senao, se a arvore tiver dois elementos (raiz e dir)
        else if(raiz.esq == null)
        {//Inicio else if 2 (raiz e dir)

            if(raiz.elemento.getSigla().compareTo(elemento.getSigla()) > 0){
                raiz.esq = new No(elemento);
            }
            else if(raiz.dir.elemento.getSigla().compareTo(elemento.getSigla()) > 0){
                raiz.esq = new No(raiz.elemento);
                raiz.elemento = elemento;
            }
            else{
                raiz.esq= new No(raiz.elemento);
                raiz.elemento = raiz.dir.elemento;
                raiz.dir.elemento = elemento;
            }
            raiz.esq.cor = raiz.dir.cor = preto;

        }//Fim else if 2 (raiz e dir)

        // Senao, se a arvore tiver dois elementos (raiz e esq)
        else if (raiz.dir == null)
        {//Inicio else if 2 (raiz e esq) 

            if(raiz.elemento.getSigla().compareTo(elemento.getSigla()) < 0){
                raiz.dir = new No(elemento);
            }
            else if(raiz.esq.elemento.getSigla().compareTo(elemento.getSigla()) < 0){
                raiz.dir = new No(raiz.elemento);
                raiz.elemento = elemento;
            }
            else{
                raiz.dir = new No(raiz.elemento);
                raiz.elemento = raiz.esq.elemento;
                raiz.esq.elemento = elemento;
            }
            raiz.esq.cor = raiz.dir.cor = preto;

        }//Fim else if 2 (raiz e esq)

        // Senao, a arvore tem tres ou mais elementos
        else this.inserir(elemento, null, null, null, raiz);

        raiz.cor = branco;

    }//Fim inserir iterativo

    /**
     * Metodo privado recursivo para inserir elemento.
     * @param elemento Instituicao a ser inserida.
     * @param bisavo No em analise.
     * @param avo No em analise.
     * @param pai No em analise.
     * @param i No em analise.
     */
    private void inserir(Instituicao elemento, No bisavo, No avo, No pai, No i)
    {//Inicio inserir recursivo

        if(i == null){
            if(elemento.getSigla().compareTo(pai.elemento.getSigla()) < 0){
                i = pai.esq = new No(elemento, preto);
            }
            else i = pai.dir = new No(elemento, preto);

            if(pai.cor == preto) this.balancear(bisavo, avo, pai, i);
        }
        else{
            // Achou um 4-no: eh preciso fragmenta-lo e reequilibrar a arvore
            if(i.esq != null && i.dir != null && i.esq.cor == preto && i.dir.cor == preto){
                i.cor = preto;
                i.esq.cor = i.dir.cor = branco;

                if(i == raiz) i.cor = branco;
                else if (pai.cor == preto) this.balancear(bisavo, avo, pai, i);

            }
            if(elemento.getSigla().compareTo(i.elemento.getSigla()) < 0){
                this.inserir(elemento, avo, pai, i, i.esq);
            }
            else if(elemento.getSigla().compareTo(i.elemento.getSigla()) > 0){
                this.inserir(elemento, avo, pai, i, i.dir);
            }
        }
    }//Fim inserir recursivo

    /**
     * Metodo privado iterativo para balancear a arvore.
     * @param bisavo No em analise.
     * @param avo No em analise.
     * @param pai No em analise. 
     * @param i No em analise.
     */
    private void balancear(No bisavo, No avo, No pai, No i)
    {//Inicio balancear

        // Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
        if(pai.cor == preto)
        {//Inicio if pai eh preto

            // 4 tipos de reequilibrios e acoplamento
            if(pai.elemento.getSigla().compareTo(avo.elemento.getSigla()) > 0)
            {//Rotacao a esquerda ou direita-esquerda
                avo = (i.elemento.getSigla().compareTo(pai.elemento.getSigla()) > 0) ? rotacaoEsq(avo) : rotacaoDirEsq(avo);
            }//Rotacao a esquerda ou direita-esquerda
            else
            {//Rotacao a direita ou esquerda-direita
                avo = (i.elemento.getSigla().compareTo(pai.elemento.getSigla()) < 0) ? rotacaoDir(avo) : rotacaoEsqDir(avo);
            }//Rotacao a direita ou esquerda-direita

            if(bisavo == null) raiz = avo;
            else{
                if(avo.elemento.getSigla().compareTo(bisavo.elemento.getSigla()) < 0){
                    bisavo.esq = avo;
                }
                else bisavo.dir = avo;
            }

            // Reestabelecer as cores apos a rotacao 
            avo.cor = branco;
            avo.esq.cor = avo.dir.cor = preto;
        }//Fim if pai eh preto

    }//Fim balancear
                      
    private No rotacaoDir(No no)
    {//Inicio rotacaoDir
        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        return noEsq;
    }//Fim rotacaoDir 

    private No rotacaoEsq(No no)
    {//Inicio rotacaoEsq
        No noDir = no.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;

        return noDir;
    }//Fim rotacaoEsq
 
    private No rotacaoDirEsq(No no){
        no.dir = rotacaoDir(no.dir);
        return rotacaoEsq(no);
    }

    private No rotacaoEsqDir(No no){
        no.esq = rotacaoEsq(no.esq);
        return rotacaoDir(no);
    } 


}//Fim classe ArvoreBinaria

 
/**
 * @author Luiz Junio Veloso Dos Santos
 * @version 1.0
 */
class Conta
{//Inicio classe Conta
    private static int numComparacoes;
    private static int numMovimentacoes;

    /**
     * Metodo para zerar o numero de comparacoes
     * e movimentacoes.
     */
    public static void zerar(){
        numComparacoes = 0;
        numMovimentacoes = 0;
    }
    
    /**
     * Metodo para obter o numero de comparacoes.
     * @return Numero de comparacoes.
     */
    public static int getNumComparacoes(){
        return numComparacoes;
    }

    /**
     * Metodo para obter o numero de movimentacoes.
     * @return Numero de comparacoes.
     */
    public static int getNumMovimentacoes(){
        return numMovimentacoes;
    }
    
    /**
     * Atribue um valor a ser somado ao numero de comparacoes.
     * @param quantidade Valor a ser somado.
     */
    public static void somaComparacoes(int quantidade){
        numComparacoes += quantidade;
    }

    /**
     * Soma mais 1 ao numero de comparacoes.
     */
    public static void somaComparacoes(){
        numComparacoes++;
    }
    
    /**
     * Atribue um valor a ser somado ao numero de movimentacoes.
     * @param quantidade Valor a ser somado.
     */
    public static void somaMovimentacoes(int quantidade){
        numMovimentacoes += quantidade;
    }

    /**
     * Soma mais 1 ao numero de movimentacoes.
     */
    public static void somaMovimentacoes(){
        numMovimentacoes++;
    }
}//Fim classe conta
 

