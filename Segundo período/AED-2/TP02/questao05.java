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
        this.linha = linha;
        this.coluna = coluna;

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

    public Matriz soma(Matriz m) {
        Matriz resp = null;

        if(this.linha == m.linha && this.coluna == m.coluna){
            //...
        }

        return resp;
    }

    public Matriz multiplica(Matriz m) {
        Matriz resp = null;

        if(){
            //...
        }

        return resp;
    }

    public boolean ehQuadrada(){
        return (this.linha == this.coluna);
    }

    public void mostrarDiagonalPrincipal (){
        if(isQuadrada() == true){
            for(Celula i = inicio; i != null; i = i.inf.dir){
                Sop(i.elemento);
            }
        }
    }

    public void mostrarDiagonalSecundaria (){
        if(isQuadrada() == true){

        }
    }

    public void mostrar(){
        for(Celula i = inicio; i != null; i = i.prox){
            for(Celula j = 
        }
    }
}//Fim classe Matriz      
