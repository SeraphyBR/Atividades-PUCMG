#include <iostream>
#include <vector>
#include <list>
#include <queue>

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
    public:
        Grafo(int numVertices);
        ~Grafo();
        void add_conexao(int v1, int v2, int peso);
        void del_conexao(int v1, int v2);
        int grau_vertice(int v);
        void display();
        vector<int> busca_largura(int v);

};

Grafo::Grafo(int numVertices) {
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

// Implementação do algoritmo de busca em largura
// que retorna um vetor de vertices percorridos.
vector<int> Grafo::busca_largura(int v) {
    vector<int> dist(num_vertices,__INT_MAX__);
    vector<Cor> cor(num_vertices,Branco);
    queue<int> fila;
    vector<int> caminho;
    dist.at(v) = 0;
    cor.at(v) = Cinza;
    caminho.push_back(v);
    fila.push(v);
    while(!fila.empty()){
        int u = fila.front();
        fila.pop();
        for (int i = 0; i < num_vertices; i++){
            if(matriz_adj->at(u).at(i) > -1 && cor.at(i) == Branco){
                cor.at(i) = Cinza;
                caminho.push_back(i);
                dist.at(i) = dist.at(u) + 1;
                fila.push(i);
            }
        }
        cor.at(u) = Preto;
    }
    return caminho;
}

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
        auto caminho = g->busca_largura(0);
        for (auto v : caminho){
            cout << v << " ";
        }
        cout << endl;
        cin >> vertices;
    }
    return 0;
}