#include <iostream>
#include <vector>
#include <list>
using namespace std;

enum Cor {
	Branco,
	Cinza,
	Preto
};

class Grafo {
	private:
		int **matriz_adj;
		int numVertices;
		void dfs_visit(vector<Cor> &cor,int v,list<int> &lcomp);
	public:
		Grafo(int vertices);
		~Grafo();
		void display();
		void add_conexao(int v1, int v2);
		int grau_vertice(int v);
		vector<list<int>> componentes();
};

Grafo::Grafo(int vertices) {
	numVertices = vertices;
	matriz_adj = new int*[numVertices];
	for (int i = 0; i < numVertices; i++){
		matriz_adj[i] = new int[numVertices];
	}
	for (int i = 0; i < numVertices; i++){
		for (int j = 0; j < numVertices; j++){
			matriz_adj[i][j] = 0;
		}
	}
}

Grafo::~Grafo() {
	for (int i = 0; i < numVertices; i++){
		delete[] matriz_adj[i];
	}
	delete[] matriz_adj;
}

void Grafo::display() {
	for (int i = 0; i < numVertices; i++){
		for (int j = 0; j < numVertices; j++){
			cout << matriz_adj[i][j] << " ";
		}
		cout << endl;
	}
}

void Grafo::add_conexao(int v1, int v2) {
	if(v1 < numVertices && v2 < numVertices){
		if(v1 == v2) {
			matriz_adj[v1][v2] = 2;
		}
		else{
			// Como os grafos lidos são não orientados,
			// acrecenta-se  as arestas nos dois sentidos.
			matriz_adj[v1][v2] = 1;
			matriz_adj[v2][v1] = 1;
		}
	}
}//end Grafo::add_conexao();

void Grafo::dfs_visit(vector<Cor> &cor,int v,list<int> &lcomp) {
	cor[v] = Cinza;
	lcomp.push_back(v);
	for (int i = 0; i < numVertices; i++){
		if (matriz_adj[i][v] == 1 && cor[i] == Branco){
			dfs_visit(cor, i, lcomp);
		}
	}
	cor[v] = Preto;
}//end Grafo::dfs_visit();

// Uso do algoritmo de busca em profundidade
// retorna um vetor contendo uma lista para cada componente
// do grafo, essa lista contem o numero dos vetores pertencentes
// ao componente.
vector<list<int>> Grafo::componentes() {
	vector<list<int>> componentes {};
	list<int> lcomp {};
	vector<Cor> cor(numVertices, Branco);
	for (int i = 0; i < numVertices; i++){
		if(cor[i] == Branco){
			dfs_visit(cor, i, lcomp);
			lcomp.sort();
			componentes.push_back(lcomp);
			lcomp.clear();
		}
	}
	return componentes;
}//end Grafo::componentes()

int main() {
	int testes {};
	int vertices {};
	int arestas {};
    int arestas_inseridas {};
    int cores {};
	char v1, v2;
	Grafo *g;

	cin >> testes;
	for (int t = 0; t < testes; t++){
		cin >> vertices >> arestas >> arestas_inseridas >> cores;
        vector<int> vcor {cores,0};
        for (auto &cor : vcor){
            cin >> cor;
        }
        for (int i = 0; i < arestas; i++){
        }


	}
	delete g;
	return 0;
}//end main();