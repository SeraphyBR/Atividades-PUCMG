#include <iostream>
#include <vector>
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
        int numVertices;
        bool orientado;
    public:
        Grafo(int vertices) : Grafo(vertices, false){};
        Grafo(int vertices, bool ehOrientado);
        ~Grafo();
        void display();
        int get_numVertices();
        int get_conexao(int v1, int v2);
        void add_conexao(int v1, int v2);
        int grau_vertice(int v);
        Grafo* grafo_transposto();
        vector<int> busca_largura(int v);
};

Grafo::Grafo(int vertices, bool ehOrientado) {
    orientado = ehOrientado;
    numVertices = vertices;
    matriz_adj = new vector<vector<int>>(numVertices,vector<int>(numVertices, 0));
}

Grafo::~Grafo() {
    delete matriz_adj;
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

// Metodo que retorna o transposto do grafo original.
Grafo* Grafo::grafo_transposto() {
    Grafo *gt= new Grafo(numVertices, true);
    for (int i = 0; i < numVertices; i++){
        for (int j = 0; j < numVertices; j++){
            gt->matriz_adj->at(i).at(j) = matriz_adj->at(j).at(i);
        }
    }
    return gt;
}

// Implementação do algoritmo de busca em largura
// que retorna o vetor de distancias em relação a v.
vector<int> Grafo::busca_largura(int v) {
    vector<int> dist(numVertices,__INT_MAX__);
    vector<Cor> cor(numVertices,Branco);
    queue<int> fila;
    dist.at(v) = 0;
    cor.at(v) = Cinza;
    fila.push(v);
    while(!fila.empty()){
        int u = fila.front();
        fila.pop();
        for (int i = 0; i < numVertices; i++){
            if(matriz_adj->at(u).at(i) == 1 && cor.at(i) == Branco){
                cor.at(i) = Cinza;
                dist.at(i) = dist.at(u) + 1;
                fila.push(i);
            }
        }
        cor.at(u) = Preto;
    }
    return dist;
}

int main() {
    int num_especies {};
    int num_relacoes {};
    int v1, v2;
    bool bolada = true;

    cin >> num_especies >> num_relacoes;

    Grafo *g = new Grafo(num_especies,true);
    vector<vector<bool>> matriz_caminho(num_especies, vector<bool>(num_especies, false));

    for (int i = 0; i < num_relacoes; i++){
        cin >> v1 >> v2;
        g->add_conexao(v1 - 1,v2 - 1);
    }

    for (int i = 0; i < num_especies; i++){
        auto dist = g->busca_largura(i);
        for(int v = 0; v < dist.size(); v++){
            if (i != v && dist.at(v) != __INT_MAX__) {
                matriz_caminho.at(i).at(v) = true;
            }
        }
    }

    for (int i = 0; i < num_especies && bolada; i++){
        for (int j = 0; j < num_especies && bolada; j++){
            if(i != j){
                bolada = matriz_caminho.at(i).at(j) || matriz_caminho.at(j).at(i);
            }
        }
    }

    if(bolada){
        cout << "Bolada" << endl;
    }
    else{
        cout << "Nao Bolada" << endl;
    }
    delete g;
    return 0;
}//end main();
