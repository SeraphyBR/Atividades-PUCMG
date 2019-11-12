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
        int num_vertices;
        void dfs_visit(vector<Cor> &cor, int v,list<int> &lcomp);
    public:
        Grafo(int numVertices);
        ~Grafo();
        void add_conexao(int v1, int v2, int peso);
        void del_conexao(int v1, int v2);
        int grau_vertice(int v);
        void display();
        vector<list<int>> componentes();
};

Grafo::Grafo(int numVertices){
    num_vertices = numVertices;
    matriz_adj = new vector<vector<int>>(numVertices, vector<int>(numVertices, -1));
}

Grafo::~Grafo(){
    delete matriz_adj;
}

void Grafo::add_conexao(int v1, int v2, int peso){
    matriz_adj->at(v1).at(v2) = peso;
    matriz_adj->at(v2).at(v1) = peso;
}

void Grafo::del_conexao(int v1, int v2){
    matriz_adj->at(v1).at(v2) = -1;
    matriz_adj->at(v2).at(v1) = -1;
}

int Grafo::grau_vertice(int v){
    int count {};
    for(auto aresta: matriz_adj->at(v)){
        if(aresta != -1){
            count++;
        }
    }
    return count;
}

void Grafo::display() {
    for (auto& coluna : *matriz_adj){
        for (auto v : coluna){
            cout << v << " ";
        }
        cout << endl;
    }
}

void Grafo::dfs_visit(vector<Cor> &cor,int v,list<int> &lcomp) {
    cor.at(v) = Cinza;
    lcomp.push_back(v);
    for (int i = 0; i < num_vertices; i++){
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
    vector<Cor> cor(num_vertices, Branco);
    for (int i = 0; i < num_vertices; i++){
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
    int vertices {};
    cin >> vertices;
    while (vertices != 0){
        Grafo *g = new Grafo(vertices);
        for(int i = 0; i < vertices; i++){
            for(int v = i + 1; v < vertices; v++){
                int a {};
                cin >> a;
                g->add_conexao(i, v, a);
            }
        }
        int cont_impar {};
        for(int i = 0; i < vertices; i++){
            if(g->grau_vertice(i) % 2 == 1){
                cont_impar++;
            }
        }
        if(cont_impar == 2 && g->componentes().size() == 1){
            cout << "SIM" << endl;
        }
        else {
            cout << "NAO" << endl;
        }
        cin >> vertices;
    }
    return 0;
}