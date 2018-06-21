import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.InputMismatchException;

public class Lista16
{//Inicio classe Lista16
    public static void main(String[]args)
    {//Inicio main
        boolean sairDoPrograma = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int quantidade = 0;

        System.out.print("Para começar a usar o Sistema,\nDigite a quantidade máxima de Funcionarios: ");
        try{
            quantidade = Integer.parseInt(br.readLine());
        }
        catch(NumberFormatException numberFormatException){
            System.out.print("Valor inserido é inválido!");
        }
        catch(IOException ioException){
            System.out.print("Erro de leitura!");
        }

        Funcionario[] funcionario = new Funcionario[quantidade];    

        do{
            try{
                if(acoes(menu(), funcionario) == 0 ) sairDoPrograma = true;
            }
            catch(IOException ioException){
                System.out.println("Erro ao ler o teclado!");
            }
            catch(NumberFormatException numberFormatException){
                System.out.println("\nO valor digitado é inválido!");
                System.out.println("Tente novamente:\n");
            }
            catch(InputMismatchException inputMismatchException){
                System.out.println("Valor inserido é Inválido!");
                System.out.println("Faça novamente: ");
            } 
            catch(OpcaoNaoDefinida opcaoNaoDefinida){
                System.out.println("Essa operação não existe!");
            }   
        }while(!sairDoPrograma);
    }//Fim main 

    public static int menu() throws NumberFormatException, IOException
    {//Fim menu
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int op = 0;
        System.out.print(
            "\n\n\tSistema de Gestão de Funcionários" +
            "\nDigite uma opção seguinte: " +
            "\n0 - Sair" +
            "\n1 - Adicionar um novo Funcionário" +
            "\n2 - Buscar Funcionario por Nome" +
            "\n3 - Buscar Funcionario pelo CPF" +
            "\n4 - Salvar todos os funcionários em arquivo" +
            "\n5 - Ler os Funcionarios do arquivo" +
            "\n=> "
        );//Fim println
        op = Integer.parseInt(br.readLine());
        return op;
    }//Fim menu 

    public static int acoes(int op, Funcionario[] funcionario) throws OpcaoNaoDefinida, IOException
    {//Inicio acoes
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int retorno = op;
        if(op == 0) retorno = 0;
        else
        {//Inicio else 
            switch (op)
            {//Inicio switch
                case 1:
                    if(Funcionario.quantidade < funcionario.length){ 
                        funcionario[Funcionario.quantidade] = new Funcionario();
                        funcionario[Funcionario.quantidade - 1].leFuncionario();
                        System.out.println("Adicionado novo funcionario com sucesso!");
                    }
                    else System.out.println("Número máximo de funcionários atingido!");    
                    break;
                case 2:
                    System.out.print("Digite o nome a ser buscado: ");
                    String nome = br.readLine();
                    Funcionario.buscaNome(nome, funcionario);
                    break;
                case 3:
                    System.out.print("Digite o CPF do funcionário a ser buscado: ");
                    long cpf = Long.parseLong(br.readLine());
                    try{
                    funcionario[Funcionario.buscaCPF(cpf, funcionario)].imprimeFuncionario();
                    }catch(NullPointerException nullPointerException){
                        System.out.print("Não encontrado!");
                    }
                    break;
                case 4:   
                    Funcionario.gravaArquivo(funcionario);
                    break;
                case 5:
                    Funcionario.leArquivo(funcionario); 
                    break;   
                default:
                    throw new OpcaoNaoDefinida();
            }//Fim switch
        }//Fim else 
        return retorno;
    }//Fim acoes

}//FIm classe Lista16

class Data implements Serializable
{//Inicio classe Data

    private int dia;
    private int mes;
    private int ano;

    Data(int dd, int mm, int aa){
        this.setAno(aa);
        this.setMes(mm);
        this.setDia(dd);
    }

    Data(){
        this.setAno(0);
        this.setMes(0);
        this.setDia(0);
    }

    public int getDia(){
        return this.dia;
    }

    public int getMes(){
        return this.mes;
    }

    public int getAno(){
        return this.ano;
    }

    public void setDia(int dia){
        this.dia = dia;
    }

    public void setMes(int mes){
        this.mes = mes;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public boolean ehAnoBissexto(){
        boolean bissexto = false;
        int ano = this.getAno();
        if ((ano%4 == 0)&&((ano%100 !=0)||(ano%400 == 0))) bissexto = true;
        return bissexto;
    }
        
    public String mesExtenso()
    {//Inicio mesExtenso
        int mes = this.getMes() - 1;
        String[] meses = {"Janeiro", "Fevereiro" , "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        try{
            return meses[mes];
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            return "";
        }     
    }//Fim mesExtenso

    public boolean ehValido()
    {//Inicio ehValido
        boolean valido = true;
        int ano = this.getAno();
        int mes = this.getMes();
        int dia = this.getDia();
        boolean ehAnoBissexto = this.ehAnoBissexto();

        if(ano < 1) valido = false;
        else if(mes > 12 || mes < 1) valido = false;
            else if(dia < 1) valido = false;
                else if(mes == 1 && dia > 31) valido = false;
                else if(mes == 2 && !ehAnoBissexto && dia > 28) valido = false;
                else if(mes == 2 && ehAnoBissexto && dia > 29) valido = false;
                else if(mes == 3 && dia > 31) valido = false;
                else if(mes == 4 && dia > 30) valido = false;
                else if(mes == 5 && dia > 31) valido = false;
                else if(mes == 6 && dia > 30) valido = false;
                else if(mes == 7 && dia > 31) valido = false;
                else if(mes == 8 && dia > 31) valido = false;
                else if(mes == 9 && dia > 30) valido = false;
                else if(mes == 10 && dia > 31) valido = false;
                else if(mes == 11 && dia > 30) valido = false;
                else if(mes == 12 && dia > 31) valido = false;
        return valido;
    }//Fim ehValido

    public boolean ehMaisRecente(Data data)
    {//Inicio ehMaisRecente
        boolean ehRecente = false;
        if(this.getAno() >= data.getAno()){
            if(this.getMes() >= data.getMes()){
                if(this.getDia() > data.getDia()) ehRecente = true;
            }
        }
        return ehRecente;
    }//Fim ehMaisRecente

    public void leData()
    {//Inicio leData
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dia = 1, mes = 1, ano = 2000;
        try{
            System.out.print("\nDia: ");
            dia = Integer.parseInt(br.readLine());
            System.out.print("Mês: ");
            mes = Integer.parseInt(br.readLine());
            System.out.print("Ano: ");
            ano = Integer.parseInt(br.readLine());
        }
        catch(Exception exception){
            System.out.print("Erro!");
        }
        this.setDia(dia);
        this.setMes(mes);
        this.setAno(ano);
    }//Fim leData

    public void imprimeData(){
        System.out.printf("%02d/%02d/%d\n", this.getDia(), this.getMes(), this.getAno());
    }

}//Fim classe Data

class Funcionario implements Serializable
{//Inicio classe Funcionario
    private String nome;
    private long cpf;
    private Data nascimento;
    private Data admissao;
    private double salario;
    public static int quantidade = 0;

    Funcionario()
    {//Construtor Vazio Funcionario 
        this.setNome("");
        this.setCPF(0);
        this.setNascimento(new Data());
        this.setAdmissao(new Data());
        this.setSalario(0);
        quantidade++;
    }//Fim Construtor

    Funcionario(String nome, long cpf, Data nascimento, Data admissao, double salario)
    {//Construtor Funcionario com parametros
        this.setNome(nome);
        this.setCPF(cpf);
        this.setNascimento(nascimento);
        this.setAdmissao(admissao);
        this.setSalario(salario);
        quantidade++;
    }//Fim Construtor 

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCPF(long cpf){
        this.cpf = cpf;
    }

    public void setNascimento(Data nascimento){
        this.nascimento = nascimento;
    }

    public void setAdmissao(Data admissao){
        this.admissao = admissao;
    }

    public void setSalario(double salario){
        this.salario = salario;
    }

    public String getNome(){
        return this.nome;
    }

    public long getCPF(){
        return this.cpf;
    }

    public Data getNascimento(){
        return this.nascimento;
    }    

    public Data getAdmissao(){
        return this.admissao;
    }

    public double getSalario(){
        return this.salario;
    }

    public void leFuncionario()
    {//Inicio leFuncionario
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nome = "";
        long cpf = 0;
        double salario = 0;
        Data nascimento = new Data(), admissao = new Data();
        boolean continuaLaco = true;
        do{ 
            try{
                System.out.print("\nDigite o nome do Funcionario: ");
                nome = br.readLine();
                System.out.print("Digite o CPF: ");
                cpf = Long.parseLong(br.readLine());
                System.out.print("Digite a data de Nascimento: ");
                nascimento.leData();
                System.out.print("Digite a data de admissão: ");
                admissao.leData();
                System.out.print("Digite o salario do Funcionario: ");
                salario = Double.parseDouble(br.readLine());
                continuaLaco = false;
            }//Fim try 
            catch(IOException ioException){
                System.out.println("\nErro de leitura do teclado!");
                System.out.println("Tente Novamente:\n");
            }
            catch(NullPointerException nullPointerException){
                System.out.println("\nVocê não digitou todos os dados!");
                System.out.println("Por favor, tente novamente:\n");
            }
            catch(NumberFormatException numberFormatException){
                System.out.println("\nO valor digitado é inválido!");
                System.out.println("Tente novamente:\n");
            }
        }while(continuaLaco);
        this.setNome(nome);
        this.setCPF(cpf);
        this.setNascimento(nascimento);
        this.setAdmissao(admissao);
        this.setSalario(salario);   
    }//Fim leFuncionario

    public void imprimeFuncionario()
    {//Inicio imprimeFuncionario
        System.out.print("\nFuncionario: ");
        System.out.print("\n\tNome: " + this.getNome());
        System.out.printf("\n\tCPF: %011d ", this.getCPF());
        System.out.print("\n\tData de nascimento: ");
        this.getNascimento().imprimeData();
        System.out.print("\tData de admissão: ");
        this.getAdmissao().imprimeData();
        System.out.printf("\tSalario: R$%.2f ", this.getSalario());
    }//Fim imprimeFuncionario

    public boolean ehMaiorSalario(double salario)
    {//Inicio ehMaiorSalario
        boolean ehMaior = true;
        if(this.getSalario() < salario) ehMaior = false;
        return ehMaior;
    }//Fim ehMaiorSalario

    public static void buscaNome(String chave, Funcionario[] funcionario)
    {//Inicio buscaNome
        for(int cont = 0; cont < Funcionario.quantidade; cont++)
        {//Inicio for 
            if(chave.equalsIgnoreCase(funcionario[cont].getNome().substring(0, chave.length()))){
                funcionario[cont].imprimeFuncionario();
            }    
        }//Fim for 
    }//Fim buscaNome

    public static int buscaCPF(long chave, Funcionario[] funcionario)
    {//Inicio buscaCPF
        int inicio = 0, meio, fim = funcionario.length - 1;
        boolean continuaLaco = true;
        int posicao = -1;
        Funcionario.ordena(funcionario);
        while(inicio <= fim && continuaLaco){
            meio = (inicio + fim) / 2;
            if(funcionario[meio].getCPF() == chave){ 
                posicao = meio;
                continuaLaco = false;
            }    
            else if(funcionario[meio].getCPF() < chave) inicio = meio + 1;
            else if(funcionario[meio].getCPF() > chave) fim = meio - 1;
        }//Fim while
        return posicao;
    }//Fim buscaCPF

    public static void ordena(Funcionario[] funcionario)
    {//Inicio ordena
        Funcionario aux;
        for(int j = 0; j < funcionario.length; j++){
            for (int i = 0; i < funcionario.length - 1; i++) {
                if(funcionario[i].getCPF() > funcionario[i + 1].getCPF())
                {//Inicio If
                    aux = funcionario[i];
                    funcionario[i] = funcionario[i + 1];
                    funcionario[i + 1] = aux;
                }//Fim if 
            }//Fim for i 
        }//Fim for j
        //System.out.println("\nOs funcionários foram ordenados!"); 
    }//Fim ordena

    public static void gravaArquivo(Funcionario[] funcionario)
    {//Inicio gravaArquivo
        try{
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("backup.txt"));
            for(int i = 0; i < Funcionario.quantidade; i++){
                output.writeObject(funcionario[i]);
            }
            output.close();
        }
        catch(FileNotFoundException fileNotFoundException){
            System.out.print("Erro ao tentar criar o arquivo, verifique se não tem nenhuma pasta com mesmo nome!");
        }  
        catch(IOException ioException){
            System.out.print("Erro ao manipular arquivo!");
        }   
    }//Fim gravaArquivo

    public static void leArquivo(Funcionario[] funcionario){
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("backup.txt"))){
            int i = 0;
            while(true){
                funcionario[i] = (Funcionario) input.readObject();
                i++;
            }
        }
        catch(EOFException eofException){
            return;
        }
        catch(FileNotFoundException fileNotFoundException){
            System.out.print("Erro ao tentar ler o arquivo, verifique se o arquivo backup.sgf existe!");
        }
        catch(ClassNotFoundException classNotFoundException){
            System.out.print("Funcionario não encontrado!");
        }  
        catch(IOException ioException){
            System.out.print("Erro ao manipular arquivo!");
        }   
    }

}//Fim classe Funcionario

class OpcaoNaoDefinida extends Exception {
    @Override
    public String getMessage(){
        return "Opção inexistente!";
    }
}