#include <iostream>
#include <list>
#include <queue>
#include <vector>
using namespace std;

enum Cor {
    Branco,
    Cinza,
    Preto
};

class Grafo {
    private:
        vector<vector<int>> *matriz_adj;
        int numVertices;
        bool orientado;
        void dfs_visit(vector<Cor> &cor,int v,list<int> &lcomp);
    public:
        Grafo(int vertices) : Grafo(vertices, false){};
        Grafo(int vertices, bool ehOrientado);
        ~Grafo();
        void display();
        int get_numVertices();
        int get_conexao(int v1, int v2);
        void add_conexao(int v1, int v2);
        int grau_vertice(int v);
        vector<list<int>> componentes();
};

Grafo::Grafo(int vertices, bool ehOrientado) {
    orientado = ehOrientado;
    numVertices = vertices;
    matriz_adj = new vector<vector<int>>(numVertices,vector<int>(numVertices, 0));
}

Grafo::~Grafo() {
    delete matriz_adj;
    matriz_adj = nullptr;
}

void Grafo::display() {
    for (auto& coluna : *matriz_adj){
        for (auto v : coluna){
            cout << v << " ";
        }
        cout << endl;
    }
}

void Grafo::add_conexao(int v1, int v2) {
    if(v1 < numVertices && v2 < numVertices){
        if(v1 == v2) {
            matriz_adj->at(v1).at(v2) = 2;
        }
        else{
            if(orientado){
                matriz_adj->at(v1).at(v2) = 1;
            }
            else {
                matriz_adj->at(v1).at(v2) = 1;
                matriz_adj->at(v2).at(v1) = 1;
            }
        }
    }
}//end Grafo::add_conexao();

int Grafo::get_conexao(int v1, int v2){
    return matriz_adj->at(v1).at(v2);
}

int Grafo::get_numVertices(){
    return numVertices;
}

void Grafo::dfs_visit(vector<Cor> &cor,int v,list<int> &lcomp) {
    cor.at(v) = Cinza;
    lcomp.push_back(v);
    for (int i = 0; i < numVertices; i++){
        if (matriz_adj->at(i).at(v) == 1 && cor.at(i) == Branco){
            dfs_visit(cor, i, lcomp);
        }
    }
    cor.at(v) = Preto;
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
        if(cor.at(i) == Branco){
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
    int v1, v2;
    int min_aresta {};
    int max_aresta {};
    Grafo *g;

    cin >> testes;
    for (int t = 0; t < testes; t++){
        cin >> vertices >> arestas >> arestas_inseridas >> cores;
        vector<int> vcor(vertices,0);//vetor contendo as cores de cada vertice
        vector<int> count_cor(cores,0);//vetor contator do numero de vertices de cor X.
        g = new Grafo(vertices);
        for (auto &cor : vcor){
            cin >> cor;
            cor--;
            count_cor.at(cor)++;
        }
        for (int i = 0; i < arestas; i++){
            cin >> v1 >> v2;
            g->add_conexao(v1 - 1,v2 - 1);
        }
        min_aresta = g->componentes().size() - 1;
        max_aresta = 0;
        for(int i = 0; i < cores; i++){
            for(int j = i + 1; j < cores; j++){
                max_aresta += count_cor.at(i) * count_cor.at(j);
            }
        }

        max_aresta -= arestas;

        if (arestas_inseridas <= max_aresta && arestas_inseridas >= min_aresta){
            cout << "Y" << endl;
        }
        else {
            cout << "N" << endl;
        }
        cout << endl;
        delete g;
    }
    return 0;
}//end main();
