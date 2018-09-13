
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.io.IOException;

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
 
/**
 * @author Luiz Junio Veloso Dos Santos
 * @version 1.2
 */            
public class questao12
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

            Lista listaInstituicao = new Lista(1000);

            for(int cont = 0; cont < i; cont++){
                listaInstituicao.inserirFim(new Instituicao(registro[linha[cont]]));
            }

            tempoInicial = System.currentTimeMillis();
            listaInstituicao.ordenarCodigo();//Ordena a lista com base no codigo das IES
            tempoFinal = System.currentTimeMillis();

            listaInstituicao.mostrar();
        }//Fim try
        catch(Exception exception){
            exception.printStackTrace();
        }

        Arq.openWrite("matrícula_selecao.txt");//Abrindo arquivo de Log para escrita
        Arq.println("624037" + "\t" + Conta.getNumComparacoes() + "\t" + Conta.getNumMovimentacoes() + "\t" + (tempoFinal - tempoInicial));
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

    /**
     * Metodo que pega um valor booleano e imprime SIM ou NAO
     * @param bool Um booleano
     */
    public static void imprimeBool(boolean bool)
    {//Inicio booleanToString
        if(bool)
            MyIO.println("SIM");
        else
            MyIO.println("NÃO");
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
 * Lista estatica de Instituicao
 * @author Luiz Junio Veloso Dos Santos
 * @version 1.5
 */

class Lista
{//Inicio classe Lista
    private Instituicao[] array;
    private int numElementos;

    /**
     * Construtor da classe
     */
    public Lista(){
        this(6);
    }

    /**
     * Construtor da classe
     * @param tamanho Tamanho da lista
     */
    public Lista(int tamanho){
        array = new Instituicao[tamanho];
        this.numElementos = 0;
    }
    /**
     * Metodo para obter o tamanho da lista 
     * @return tamanho da Lista
     */
    public int length(){
        return this.numElementos;
    }

    /**
     * Insere um elemento na primeira posicao da lista e move os demais
     * elementos para o fim da lista.
     * @param instituicao Elemento a ser inserido
     * @throws Exception Se a lista estiver cheia
     */
    public void inserirInicio(Instituicao instituicao) throws Exception
    {//Inicio inserirInicio
        //validar insercao
        if(numElementos >= array.length){
            throw new Exception("Erro ao inserir!");
        }

        //levar elementos para o fim do array
        for(int i = numElementos; i > 0; i--){
            this.array[i] = array[i - 1];
        }

        array[0] = instituicao;
        numElementos++;
    }//Fim inserirInicio

    /**
     * Insere um elemento na ultima posicao da lista
     * @param instituicao Elemento a ser inserido
     * @throws Exception Se a lista estiver cheia
     */
    public void inserirFim(Instituicao instituicao) throws Exception
    {//Inicio inserirFim
        //validar insercao
        if(numElementos >= array.length){
            throw new Exception("Erro ao inserir!");
        }

        array[numElementos] = instituicao;
        numElementos++;

    }//Fim inserirFim

    /**
     * Insere um elemento em uma posicao especifica e move os demais
     * elementos para o fim da lista
     * @param instituicao Elemento a ser inserido
     * @param posicao Posicao de insercao
     * @throws Exception Se a lista estiver cheia ou a posicao invalida
     */
    public void inserir(Instituicao instituicao, int posicao) throws Exception
    {//Inicio inserir
        //validar insercao
        if(numElementos >= array.length || posicao < 0 || posicao >= numElementos ){
            throw new Exception("Erro ao inserir!");
        }

        //levar elementos para o fim do array
        for(int i = numElementos; i > posicao; i--){
            array[i] = array[i-1];
        }

        array[posicao] = instituicao;
        numElementos++;
    }//Fim inserir

    /**
     * Remove um elemento da primeira posicao da lista e movimenta
     * os demais elementos para o inicio da mesma.
     * @return Elemento a ser removido
     * @throws Exception Se a lista estiver vazia
     */
    public Instituicao removerInicio() throws Exception
    {//Inicio removerInicio
        //validar remocao
        if(numElementos == 0){
            throw new Exception("Erro ao remover!");
        }

        Instituicao removido = array[0];
        numElementos--;

        for(int i = 0; i < numElementos; i++){
            array[i] = array[i+1];
        }

        return removido;
    }//Fim removerInicio

    /**
     * Remove um elemento da ultima posicao da lista.
     * @return Elemento a ser removido
     * @throws Exception Se a lista estiver vazia
     */
    public Instituicao removerFim() throws Exception
    {//Inicio removerFim
        //validar remocao
        if(numElementos == 0){
            throw new Exception("Erro ao remover!");
        }

        return array[--numElementos];
    }//Fim removerFim

    /**
     * Remove um elemento de uma posicao especifica da lista e
     * movimenta os demais elementos para o inicio da mesma.
     * @param posicao Posicao de remocao.
     * @return Elemento a ser removido.
     * @throws Exception Se a lista estiver vazia ou posicao for inválida.
     */
    public Instituicao remover(int posicao) throws Exception
    {//Inicio remover
        //validar remocao
        if(numElementos == 0 || posicao < 0 || posicao >= numElementos){
            throw new Exception("Erro ao remover!");
        }

        Instituicao removido = array[posicao];
        numElementos--;

        for(int i = posicao; i < numElementos; i++){
            array[i] = array[i+1];
        }

        return removido;
    }//Fim remover

    /**
     * Mostra os elementos da lista separados por espacos
     */
    public void mostrar()
    {//Inicio mostrar
        for(int i = 0; i < numElementos; i++){
            array[i].imprime();
        }
    }//Fim mostrar

    /**
     * Troca dois elementos de posicao na lista
     * @param posicao1 Posicao do elemento a ser trocado
     * @param posicao2 Posicao do outro elemento que sera trocado
     */
    public void swap(int posicao1, int posicao2) throws Exception
    {//Inicio swap
        if(posicao1 > numElementos || posicao2 > numElementos || posicao1 < 0 || posicao2 < 0){
            throw new Exception("Posicao invalida!");
        }
        Instituicao temp = array[posicao1].getClone();
        array[posicao1] = array[posicao2].getClone();
        array[posicao2] = temp;
        Conta.somaMovimentacoes(3);//Soma as 3 movimentacoes entre elementos do array do swap.
    }//Fim swap

    /**
     * Algoritmo de ordenacao Heapsort Invertido com base no codigo
     * do municipio.
     */
    public void ordenarCodigo() throws Exception
    {//Inicio ordenarCodigo 
        //Alterar o vetor ignorando a posicao zero
        Instituicao[] tmp = new Instituicao[numElementos + 1];
        for(int i = 0; i < numElementos; i++){
            tmp[i+1] = array[i];
        }
        array = tmp;

        //Construcao do heap
        for(int tamHeap = 2; tamHeap <= numElementos; tamHeap++){
            constroiHeap(tamHeap);
        }

        //Ordenacao propriamente dita
        int tamHeap = numElementos;
        while(tamHeap > 1){
            swap(1, tamHeap--);
            reconstroiHeap(tamHeap);
        }

        //Alterar o vetor para voltar a posicao zero
        tmp = array;
        array  = new Instituicao[numElementos];
        for(int i = 0; i < numElementos; i++){
            array[i] = tmp[i+1];
        }
    }//Fim ordenarCodigo

    /**
     * Constroi o formato de Heap Invertido
     * @param tamHeap Tamanho do Heap
     */
    private void constroiHeap(int tamHeap) throws Exception
    {//Inicio constroiHeap
        int i = tamHeap;
        boolean compare = i > 1 && array[i].getCodigoMunicipio() >= array[i/2].getCodigoMunicipio();
        compare = compare || (i > 1 && (array[i].getCodigoMunicipio() == array[i/2].getCodigoMunicipio() && (array[i].getSigla().compareTo(array[i/2].getSigla()) > 0)));
        while(compare){
            swap(i, i/2);
            i /= 2;
            compare = i > 1 && array[i].getCodigoMunicipio() >= array[i/2].getCodigoMunicipio();
            compare = compare || (i > 1 && (array[i].getCodigoMunicipio() == array[i/2].getCodigoMunicipio() && (array[i].getSigla().compareTo(array[i/2].getSigla()) > 0)));
        };
    }//Fim constroiHeap

    /**
     * Reconstroi o formato de Heap Invertido
     * @param tamHeap Tamanho do heap
     */
    private void reconstroiHeap(int tamHeap) throws Exception
    {//Inicio reconstroiHeap
        int i = 1, filho;
        boolean compare;
        while(i <= (tamHeap/2))
        {//Inicio while
            compare = array[2*i].getCodigoMunicipio() >= array[2*i+1].getCodigoMunicipio() || 2*i == tamHeap;;
            compare = compare || (array[2*i].getCodigoMunicipio() == array[2*i+1].getCodigoMunicipio() && (array[2*i].getSigla().compareTo(array[2*i+1].getSigla()) > 0 ));
            if(compare){
                filho = 2*i;
            }
            else filho = 2*i + 1;

            compare = array[i].getCodigoMunicipio() <= array[filho].getCodigoMunicipio();
            compare = compare || (array[i].getCodigoMunicipio() == array[filho].getCodigoMunicipio() && (array[i].getSigla().compareTo(array[filho].getSigla()) < 0));
            if(compare){
                swap(i, filho);
                i = filho;
            }
            else i = tamHeap;
        }//Fim while
    }//Fim reconstroiHeap

    /**
     * Pesquisa uma instituicao na Lista, por meio do codigo.
     * @param codigo Codigo da instituicao a ser buscada.
     * @return Verdadeiro se encontrar na lista, falso caso contrario.
     */
    public boolean pesquisa(int codigo)
    {//Inicio pesquisaBinaria
        int inicio = 0, meio, fim = numElementos - 1;
        boolean encontrei = false;
        int val;
        while(inicio <= fim && !encontrei)
        {//Inicio while
            meio = inicio + ((fim - inicio) / 2);
            val = array[meio].getCodigo();
            if(val == codigo)
                encontrei = true;
            else if(val < codigo) inicio = meio + 1;
            else if(val > codigo) fim = meio - 1;
        }//Fim while
        return encontrei;
    }//Fim pesquisaBinaria 
}//Fim classe Lista
