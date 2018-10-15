/**
 * Classe Principal
 * @author Luiz Junio Veloso Dos Santos
 */
public class questao05
{//Inicio classe principal
    public static void main(String[] args){
        try{
            int numTestes = MyIO.readInt();
            for(int cont = 0; cont < numTestes; cont++){
                int numLinhasA = MyIO.readInt();
                int numColunasA = MyIO.readInt();
                Matriz matrizA = new Matriz(numLinhasA, numColunasA);
                matrizA.setValores();
                int numLinhasB = MyIO.readInt();
                int numColunasB = MyIO.readInt();
                Matriz matrizB = new Matriz(numLinhasB, numColunasB);
                matrizB.setValores();

                matrizA.mostrarDiagonalPrincipal();
                matrizA.mostrarDiagonalSecundaria();
                matrizA.soma(matrizB).mostrar();
                matrizA.multiplica(matrizB).mostrar();
            }

        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
}//Fim classe principal


/**
 * Classe Celula de Inteiro
 * @version 1
 */
class Celula 
{//Inicio classe Celula
    public int elemento;
    public Celula inf, sup, esq, dir;

    /**
     * Construtor vazio de Celula
     */
    public Celula(){
        this(0, null, null, null, null);
    }

    /**
     * Construtor de Celula
     * @param elemento Numero a ser guardado na celula
     */
    public Celula(int elemento){
        this(elemento, null, null, null, null);
    }
    
    /**
     * Construtor de Celula.
     * @param elemento Numero a ser guardado na celula.
     * @param inf Celula abaixo. 
     * @param sup Celula acima.
     * @param esq Celula a esquerda.
     * @param dir Celula a direita.
     */
    public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir){
        this.elemento = elemento;
        this.inf = inf;
        this.sup = sup;
        this.esq = esq;
        this.dir = dir;
    }
}//Fim classe Celula

/**
 * Classe Matriz de Celulas
 * @author Luiz Junio Veloso Dos Santos
 * @version 1
 */
class Matriz 
{//Inicio classe Matriz
    private Celula inicio;
    private int numLinhas, numColunas;

    /**
     * Construtor de Matriz, padrao 3x3.
     */
    public Matriz (){
        this(3, 3);
    }

    /**
     * Construtor de Matriz
     * @param linha Numero de linhas da matriz.
     * @param coluna Numero de colunas da matriz.
     */
    public Matriz (int linha, int coluna)
    {//Inicio construtor linha, coluna
        this.numLinhas = linha;
        this.numColunas = coluna;

        int contL = 0;
        int contC = 0;
        this.inicio = new Celula();
        for(Celula l = this.inicio; contL < this.numLinhas; contL++)
        {//Inicio for l
            contC = 0;
            for(Celula c = l; contC < this.numColunas - 1; contC++)
            {//Inicio for c
                c.dir = new Celula();
                c.dir.esq = c;
                c = c.dir;
                if(contL != 0){
                    //Se tiver mais de 1 linha, ligar o ponteiro da celula nova
                    //com a celula localizada acima (superior).
                    c.esq.sup.dir.inf = c;
                    c.sup = c.esq.sup.dir;
                }
            }//Fim for c
            if(contL != this.numLinhas - 1){
                l.inf = new Celula();
                l.inf.sup = l;
                l = l.inf;  
            }          
        }//Fim for l
    }//Fim construtor linha, coluna

    /**
     * Atribue os valores para uma matriz.
     */
    public void setValores(){
        for(Celula j = this.inicio; j != null; j = j.inf){
            for(Celula i = j; i != null; i = i.dir){
                i.elemento = MyIO.readInt();
            }
        }   
    }
    
    /**
     * Soma a matriz atual com outra matriz.
     * @param m A matriz com que sera somada.
     * @return A matriz contendo a soma.
     * @throws Exception Caso a matriz passada como parametro nao tiver as mesmas dimensoes.
     */
    public Matriz soma(Matriz m) throws Exception
    {//Inicio soma
        Matriz resp = null;
        if(m == null) throw new Exception("Matriz invalida!");
        else if(this.numLinhas == m.numLinhas && this.numColunas == m.numColunas)
        { 
            resp = new Matriz(m.numLinhas, m.numColunas);
            for(Celula s1 = resp.inicio, m1 = m.inicio, t1 = this.inicio; s1 != null; s1 = s1.inf, m1 = m1.inf, t1 = t1.inf)
            {
                for(Celula s2 = s1, m2 = m1, t2 = t1; s2 != null; s2 = s2.dir, t2 = t2.dir, m2 = m2.dir){
                    s2.elemento = t2.elemento + m2.elemento;
                }
            }    
        }
        else throw new Exception("As matrizes nao possuem as mesmas dimensoes!");

        return resp;
    }//Fim soma

    /**
     * Multiplica a matriz atual com outra.
     * @param m A segunda matriz para ser multiplicada
     * @return A matriz resultante do calculo.
     * @throws Exception Se o numero de colunas de uma for diferente do numero de linhas da outra.
     */
    public Matriz multiplica(Matriz m) throws Exception
    {//Inicio multiplica
        Matriz produto = null;
        if(m != null && this.numColunas == m.numLinhas)
        {//Inicio if
            produto = new Matriz(this.numLinhas, m.numColunas);
            for(Celula p1 = produto.inicio, t1 = this.inicio; p1 != null; p1 = p1.inf, t1 = t1.inf)
            {//Inicio for p linha
                for(Celula p2 = p1, m1 = m.inicio; p2 != null && m1 != null; p2 = p2.dir, m1 = m1.dir)
                {//Inicio for p coluna
                    for(Celula t2 = t1, m2 = m1; t2 != null; t2 = t2.dir, m2 = m2.inf){
                        p2.elemento += t2.elemento * m2.elemento; 
                    }
                }//Fim for p coluna
            }//Fim for p linha
        }//Fim if
        else throw new Exception("Matriz invalida!");
        return produto;
    }//Fim multiplica

    /**
     * Metodo para saber se a matriz e quadrada.
     * @return True se tiver o mesmo numero de linhas e colunas, false caso contrario.
     */
    public boolean ehQuadrada(){
        return (this.numLinhas == this.numColunas);
    }

    /**
     * Metodo para mostrar a diagonal principal da matriz.
     */
    public void mostrarDiagonalPrincipal()
    {//Inicio mostrarDiagonalPrincipal
        if(this.ehQuadrada()){
            Celula i;
            for(i = this.inicio; i.inf != null; i = i.inf.dir){
                MyIO.print(i.elemento + " ");
            }
            MyIO.println(i.elemento + " ");
        }
    }//Fim mostrarDiagonalPrincipal

    /**
     * Metodo para mostrar a diagonal secundaria da matriz.
     */
    public void mostrarDiagonalSecundaria()
    {//Inicio mostrarDiagonalSecundaria
        if(this.ehQuadrada()){
            Celula i;
            for(i = this.inicio; i.dir != null; i = i.dir);
            for(/**/; i.inf != null; i = i.inf.esq){
                MyIO.print(i.elemento + " ");
            }
            MyIO.println(i.elemento + " ");
        }
        else MyIO.println("É necessario que a matriz seja quadrada!");
    }//Fim mostrarDiagonalSecundaria

    /**
     * Metodo para mostrar todos os elementos da Matriz.
     */
    public void mostrar()
    {//Inicio mostrar
        for(Celula j = this.inicio; j != null; j = j.inf){
            for(Celula i = j; i != null; i = i.dir){
                MyIO.print(i.elemento + " ");
            }
            MyIO.println("");
        }
    }//Fim mostrar
}//Fim classe Matriz      
