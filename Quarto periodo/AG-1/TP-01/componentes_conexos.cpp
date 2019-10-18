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
		void dfs_visit(Cor *cor,int v,list<int> &lcomp);
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

void Grafo::dfs_visit(Cor *cor,int v,list<int> &lcomp) {
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
	Cor cor[numVertices] {Branco};
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

//Cada vertice esta sendo representado de 'a'-'z' na entrada.
int charToNum(char c) {
	return c - 97;
}

//Cada vertice esta sendo representado de 'a'-'z' na entrada.
char numToChar(int i) {
	return i + 97;
}

int main() {
	int testes {};
	int vertices {};
	int arestas {};
	char v1, v2;
	Grafo *g;

	cin >> testes;
	for (int t = 1; t <= testes; t++){
		cin >> vertices >> arestas;
		g = new Grafo(vertices);
		for (int a = 0; a < arestas; a++){
			cin >> v1 >> v2;
			g->add_conexao(charToNum(v1),charToNum(v2));
		}
		cout << "Case #" << t << ":" << endl;
		auto vec_comp = g->componentes();
		for(auto componente : vec_comp){
			for(auto vertice : componente){
				cout << numToChar(vertice) << ",";
			}
			cout << endl;
		}
		cout << vec_comp.size() << " connected components" << endl;
		cout << endl;
	}
	return 0;
}//end main();