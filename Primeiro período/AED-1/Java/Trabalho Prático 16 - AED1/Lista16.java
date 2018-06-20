import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lista16
{//Inicio classe Lista16
    public static void main(String[]args)
    {//Inicio main 
        Data nascimento = new Data();
        nascimento.leData();
        nascimento.imprimeData();

    }//Fim main 
}//Fim classe Lista16

class Data
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
            System.out.print("Digite o dia: ");
            dia = Integer.parseInt(br.readLine());
            System.out.print("Digite o mês: ");
            mes = Integer.parseInt(br.readLine());
            System.out.print("Digite o ano: ");
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

class Funcionario
{//Inicio classe Funcionario
    private String nome;
    private long cpf;
    private Data nascimento;
    private Data admissao;
    private double salario;

    Funcionario()
    {//Construtor Vazio Funcionario 
        this.setNome("");
        this.setCPF(0);
        this.setNascimento(new Data());
        this.setAdmissao(new Data());
        this.setSalario(0);
    }//Fim Construtor

    Funcionario(String nome, long cpf, Data nascimento, Data admissao, double salario)
    {//Construtor Funcionario com parametros
        this.setNome(nome);
        this.setCPF(cpf);
        this.setNascimento(nascimento);
        this.setAdmissao(admissao);
        this.setSalario(salario);
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
        try{
            System.out.print("\nDigite o nome do Funcionario: ");
            nome = br.readLine();
            System.out.print("\nDigite o CPF: ");
            cpf = Long.parseLong(br.readLine());
            System.out.print("\nDigite a data de Nascimento: ");
            nascimento.leData();
            System.out.print("\nDigite a data de admissão: ");
            admissao.leData();
            System.out.print("\nDigite o salario do Funcionario: ");
            salario = Double.parseDouble(br.readLine());
        }
        catch(IOException ioException){

        }
        catch(NullPointerException nullPointerException){

        }
        catch(NumberFormatException numberFormatException){

        }
        this.setNome(nome);
        this.setCPF(cpf);
        this.setNascimento(nascimento);
        this.setAdmissao(admissao);
        this.setSalario(salario);   
    }//Fim leFuncionario

    public void imprimeFuncionario(){
        System.out.println("\nFuncionario: ");
        System.out.print("\n\tNome: " + this.getNome());
        System.out.printf("\n\tCPF: %011d ", this.getCPF());
        System.out.print("\nData de nascimento: ");
        this.getNascimento().imprimeData();
        System.out.print("\nData de admissão: ");
        this.getAdmissao().imprimeData();
        System.out.printf("\nSalario: R$%.2f ", this.getSalario());
    }
}//Fim classe Funcionario