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
        vector<vector<int>> *matriz_adj;
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
    matriz_adj = new vector<vector<int>>(numVertices, vector<int>(numVertices, 0));
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
            // Como os grafos lidos são não orientados,
            // acrecenta-se  as arestas nos dois sentidos.
            matriz_adj->at(v1).at(v2) = 1;
            matriz_adj->at(v2).at(v1) = 1;
        }
    }
}//end Grafo::add_conexao();

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
    int num_citizens {};
    int num_pairs_people {};
    int p1, p2;
    Grafo *g;

    cin >> testes;
    for (int t = 0; t < testes; t++){
        cin >> num_citizens >> num_pairs_people;
        g = new Grafo(num_citizens);
        for (int a = 0; a < num_pairs_people; a++){
            cin >> p1 >> p2;
            g->add_conexao(p1 - 1,p2 - 1);
        }
        auto vec_comp = g->componentes();
        int max_num_people = 0;
        for(auto componente : vec_comp){
            if(componente.size() > max_num_people){
                max_num_people = componente.size();
            }
        }
        cout << max_num_people << endl;
        delete g;
    }
    g = nullptr;
    return 0;
}//end main();
