/**
 * Classe Celula de Inteiro
 * @author Luiz Junio Veloso Dos Santos
 * @version 1
 */
class Celula 
{//Inicio classe Celula
    public int elemento;
    public Celula inf, sup, esq, dir;

    public Celula(){
        this(0, null, null, null, null);
    }

    public Celula(int elemento){
        this(elemento, null, null, null, null);
    }

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

    public Matriz (){
        this(3, 3);
    }

    public Matriz (int linha, int coluna)
    {//Inicio construtor linha, coluna
        this.numLinhas = linha;
        this.numColunas = coluna;

        int contL = 0;
        int contC = 0;
        this.inicio = new Celula();
        for(Celula l = inicio; contL < this.numLinhas; contL++)
        {//Inicio for l
            contL = 0;
            for(Celula c = l; contC < this.numColunas; contC++)
            {//Inicio for c
                c.dir = new Celula();
                c.dir.esq = c.dir;
                c = c.dir;
                if(contC != 0){
                    c.esq.sup.dir.inf = c;
                    c.sup = c.esq.sup.dir;
                }
            }//Fim for c
            if(contL != this.numLinhas){
                l.inf = new Celula();
                l.inf.sup = l;
                l = l.inf;  
            }          
        }//Fim for l
    }//Fim construtor linha, coluna

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

    public Matriz multiplica(Matriz m) throws Exception
    {//Inicio multiplica
        Matriz produto = null;
        if(m != null && this.numColunas == m.numLinhas)
        {//Inicio if
            produto = new Matriz(this.numLinhas, m.numColunas);
            for(Celula p1 = produto.inicio, m1 = m.inicio, t1 = this.inicio; p1 != null; p1 = p1.inf, t1 = t1.inf)
            {//Inicio for p linha
                for(Celula p2 = p1; p2 != null; p2 = p2.dir, m1 = m1.dir)
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

    public boolean ehQuadrada(){
        return (this.numLinhas == this.numColunas);
    }

    public void mostrarDiagonalPrincipal()
    {//Inicio mostrarDiagonalPrincipal
        if(this.ehQuadrada()){
            for(Celula i = inicio; i != null; i = i.inf.dir){
                System.out.println(i.elemento);
            }
        }
    }//Fim mostrarDiagonalPrincipal

    public void mostrarDiagonalSecundaria()
    {//Inicio mostrarDiagonalSecundaria
        if(this.ehQuadrada()){
            Celula i;
            for(i = this.inicio; i.dir != null; i = i.dir);
            for(Celula j = i; j != null; j = j.inf.esq){
                System.out.println(j.elemento);
            }
        }
        else System.out.println("É necessario que a matriz seja quadrada!");
    }//Fim mostrarDiagonalSecundaria

    public void mostrar()
    {//Inicio mostrar
        for(Celula j = this.inicio; j != null; j = j.inf){
            for(Celula i = j; i != null; i = i.dir){
                System.out.print(i.elemento + " ");
            }
            System.out.println();
        }
    }//Fim mostrar
}//Fim classe Matriz      
