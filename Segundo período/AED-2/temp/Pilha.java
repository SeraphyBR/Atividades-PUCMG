/**
 * Pilha dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
public class Pilha {
	private Celula topo;

	/**
	 * Construtor da classe que cria uma fila sem elementos.
	 */
	public Pilha() {
		topo = null;
	}


	/**
	 * Insere elemento na pilha (politica FILO).
	 * @param x int elemento a inserir.
	 */
	public void inserir(int x) {
		Celula tmp = new Celula(x);
		tmp.prox = topo;
		topo = tmp;
      tmp = null;
	}


	/**
	 * Remove elemento da pilha (politica FILO).
	 * @return Elemento removido.
	 * @trhows Exception Se a sequencia nao contiver elementos.
	 */
	public int remover() throws Exception {
		if (topo == null) {
			throw new Exception("Erro ao remover!");
		}

		int resp = topo.elemento;
      Celula tmp = topo;
		topo = topo.prox;
      tmp.prox = null;
      tmp = null;
		return resp;
	}

    /////////////////////////////////////////////////////////////////////////////////////////////////
    public int soma() throws Exception 
    {//Inicio soma
        if(topo == null){
            throw new Exception("Nao ha elemento para somar");
        }

        int resp = 0;
        for(Celula i = topo; i!= null; i = i.prox){
            resp += i.elemento;
        }

        return resp;
    }//Fim soma

    public int somaRecursivo() throws Exception
    {//Inicio soma
        if(topo == null){
            throw new Exception("Nao ha elemento para somar");
        }

        int resp = somaRecursivo(topo);
        return resp;
    }//Fim soma

    private int somaRecursivo(Celula i)
    {//Inicio somaRecursivo
        int resp = 0;

        if(i != null){
            resp += i.elemento;
            i = i.prox;
            resp += somaRecursivo(i);
        }
        return resp;
    }//Fim somaRecursivo

    public int maior() throws Exception
    {//Inicio maior
        if(topo == null) throw new Exception("Nao tem elementos");
        int maiorValor = topo.elemento;
        int tmp;
        for(Celula i = topo.prox; i != null; i = i.prox){
            tmp = i.elemento;
            if(tmp > maiorValor) maiorValor = tmp;
        }
        return maiorValor;
    }//Fim maior

    public int maiorRecursivo() throws Exception
    {//Inicio maiorRecursivo
        if(topo == null) throw new Exception("Nao tem elementos");
        int resp = maiorRecursivo(topo);
        return resp;
    }//Fim maiorRecursivo

    private int maiorRecursivo(Celula i)
    {//Inicio maiorRecursivo
        int tmp, tmp2, maior;
        if(i.prox != null){
            tmp = i.elemento;
            tmp2 = maiorRecursivo(i.prox);
            if(tmp > tmp2) maior = tmp;
            else maior = tmp2;
        }
        else maior = i.elemento;
        return maior;
    }//Fim maiorRecursivo

    /////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Mostra os elementos separados por espacos, comecando do topo.
	 */
	public void mostrar() {
		System.out.print("[ ");
		for(Celula i = topo; i != null; i = i.prox){
			System.out.print(i.elemento + " ");
      }
		System.out.println("] ");
	}
	public void mostrarRec() {
		System.out.print("[ ");
	   mostrarRec(topo);
		System.out.println("] ");
   }
	public void mostrarRec(Celula i) {
		if(i != null){
		   mostrarRec(i.prox);
			System.out.print(i.elemento + " ");
      }
	}
}
