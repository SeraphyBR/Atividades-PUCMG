
import java.util.Scanner;

public class Lista05{
   public static void main(String []args){
      /********************************************
       * Nome do método: main
       * Data da elaboração: 21/03/18
       * Data da última alteração: 01/04/2018
       * Autor: Luiz Junio
       * Contexto de ação: Menu Principal   
       * Argumentos: nulo
       * Valor gerado: nulo
       ********************************************
      */
      Scanner s = new Scanner(System.in);
      double x, y;
      System.out.println("Qual método deseja executar?");
      System.out.println("1 - maior\n2 - soma\n3 - par\n4 - perimetroQuadrado");
      System.out.println("5 - areaQuadrado\n6 - bissexto\n7 - pesoIdeal");
      System.out.print("8 - fatorial\n9 - potenciacao\n10 - maiorConjunto\n=> ");
      int opcao = s.nextInt();
      switch (opcao){
         case 1:
            System.out.print("Digite um número real: ");
            x = s.nextDouble();
            System.out.print("Digite outro número real: ");
            y = s.nextDouble();
            System.out.print("O maior é : " + maior(x,y) );
            break;
         case 2: 
            System.out.print("Digite um número real: ");
            x = s.nextDouble();
            System.out.print("Digite outro número real: ");
            y = s.nextDouble();
            System.out.print("O resultado da soma é : " + soma(x,y) );
            break; 
         case 3: 
            System.out.print("Digite um número inteiro: ");
            par( s.nextInt() );
            break;
         case 4:
            System.out.println("Digite o valor do lado do quadrado: ");
            System.out.print("O perímetro é: " + perimetroQuadrado( s.nextDouble() ) );   
            break;
         case 5:
            System.out.println("Digite o valor do lado do quadrado: ");
            System.out.print("A área é: " + areaQuadrado( s.nextDouble() ) );   
            break; 
         case 6:
            System.out.println("Digite um ano: ");
            bissexto(s.nextInt());
            break;
         case 7:
            System.out.println("Digite o seu gênero: [M/F]");
            char genero = s.next().charAt(0);
            System.out.println("Digite a sua altura em metros: ");
            System.out.printf("O seu peso ideal é: %.2fKg ", pesoIdeal(genero,s.nextDouble()));
            break;
         case 8: 
            System.out.println("Digite um número: ");
            System.out.println("O fatorial é: " + fatorial(s.nextInt()));
            break;
         case 9: 
            System.out.println("Digite a base: ");
            double base = s.nextDouble();
            System.out.println("Digite o expoente: ");
            System.out.println("A potência é: " + potenciacao(base, s.nextDouble()));
            break;
         case 10:
            System.out.println("O maior valor é: " + maiorConjunto());
            break;
         default:
            System.out.println("Valor Inválido!");
            break;
            
      }
           
   }
 
   public static double maior(double x, double y){
    /********************************************
    * Nome do método: Maior
    * Data da elaboração: 01/04/2018
    * Data da última alteração: 01/04/2018
    * Autor: Luiz Junio
    * Contexto de ação: Calcula o maior entre dois valores reais.
    * Argumentos: x, y
    * Valor gerado: r
    ********************************************
    */
   
      double r;
      if ( x > y) r = x;
      else if ( y > x ) r = y;
      else r = x;
      return r;
  }    
     
   public static double soma(double x, double y){
    /********************************************
    * Nome do método: soma
    * Data da elaboração: 21/03/2018
    * Data da última alteração: 21/03/2018
    * Autor: Luiz Junio
    * Contexto de ação: Realizar a soma de dois valores e retornar o resultado.
    * Argumentos: x, y
    * Valor gerado: r
    ********************************************
    */
   
      double r;
      r = x + y;
      return r;
  } 
  
   public static void par(int x){
    /********************************************
    * Nome do método: soma
    * Data da elaboração: 01/04/2018
    * Data da última alteração: 01/04/2018
    * Autor: Luiz Junio
    * Contexto de ação: Calcula o maior entre dois valores reais.
    * Argumentos: x
    * Valor gerado: nulo
    ********************************************
    */
      if ( x % 2 == 0 ) System.out.println(" O número " + x + " é par!");
      else System.out.println("O número " + x + " é impar!");
   
  }    
  
   public static double perimetroQuadrado(double lado){
    /********************************************
    * Nome do método: perimetroQuadrado
    * Data da elaboração: 01/04/2018
    * Data da última alteração: 01/04/2018
    * Autor: Luiz Junio
    * Contexto de ação: Calcula o perimetro de um quadrado.
    * Argumentos: lado
    * Valor gerado: r
    ********************************************
    */
      double r = 4.0 * lado;
      return r;
  }    
  
   public static double areaQuadrado(double lado){
    /********************************************
    * Nome do método: areaQuadrado
    * Data da elaboração: 01/04/2018
    * Data da última alteração: 01/04/2018
    * Autor: Luiz Junio
    * Contexto de ação: Calcula a área de um quadrado.
    * Argumentos: lado
    * Valor gerado: r
    ********************************************
    */
      double r = lado * lado;
      return r;
  }    
  
   public static void bissexto(int ano){
    /********************************************
    * Nome do método: bissexto
    * Data da elaboração: 01/04/2018
    * Data da última alteração: 01/04/2018
    * Autor: Luiz Junio
    * Contexto de ação: Diz se o ano é bissexto ou não.
    * Argumentos: ano
    * Valor gerado: nulo
    ********************************************
    */
     if ((ano%4 == 0)&&((ano%100 !=0)||(ano%400 == 0))){
           System.out.printf("O ano %d é bissexto.\n",ano);
     }
     else System.out.printf("O ano %d não é bissexto.\n",ano);
}    
  
  public static double pesoIdeal(char sexo, double altura){
    /********************************************
    * Nome do método: pesoIdeal
    * Data da elaboração: 01/04/2018
    * Data da última alteração: 01/04/2018
    * Autor: Luiz Junio
    * Contexto de ação: Calcula o peso ideal de uma pessoa.
    * Argumentos: sexo, altura
    * Valor gerado: peso
    ********************************************
    */
    sexo = Character.toUpperCase(sexo);
    double peso = 0;
    if (sexo == 'M')  peso = (72.7 * altura) - 58 ;
    if ( sexo == 'F' ) peso = (61.1 * altura) - 44.7 ;
    return peso;
  }          

  public static int fatorial(int num){
    /********************************************
    * Nome do método: fatorial
    * Data da elaboração: 01/04/2018
    * Data da última alteração: 01/04/2018
    * Autor: Luiz Junio
    * Contexto de ação: Calcula o fatorial de um número.
    * Argumentos: num
    * Valor gerado: fatorial
    ********************************************
    */
    int fatorial = 1;  
    for( int cont = num ; cont > 0; cont-- ){
         fatorial *= cont;
    }
    return fatorial;
  }   

 public static double potenciacao(double base, double expoente){
    /********************************************
    * Nome do método: potenciacao
    * Data da elaboração: 01/04/2018
    * Data da última alteração: 01/04/2018
    * Autor: Luiz Junio
    * Contexto de ação: Calcula uma número elevado a um expoente.
    * Argumentos: base, expoente
    * Valor gerado: resultado
    ********************************************
    */
    double resultado = 1;  
    for(int cont = 0; cont < expoente; cont++ ){
      resultado *= base;
   }
    return resultado;
   
 }   

 public static double maiorConjunto(){
    /********************************************
    * Nome do método: maiorConjunto
    * Data da elaboração: 01/04/2018
    * Data da última alteração: 01/04/2018
    * Autor: Luiz Junio
    * Contexto de ação: Calcula o maior entre um conjunto de números reais lidos.
    * Argumentos: nulo
    * Valor gerado: maior
    ********************************************
    */
    Scanner s = new Scanner(System.in);   
    int cont = 1;
    double maior = 0 , menor = 100000.0;
    System.out.println("Esse método calcula o maior valor de um conjunto de números, digite 0 para encerrar.");   
    System.out.print("Digite o 1º valor: ");
    double valor = s.nextDouble(); 
    while (valor != 0){
       if ( valor >= maior)  maior = valor;
       if ( valor <= menor) menor = valor;
       cont++;
       System.out.printf("Digite o %dº valor: ",cont);
       valor = s.nextDouble();  
    }
    return maior;    
   
 }   
   
  
}   
