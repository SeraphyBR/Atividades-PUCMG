
#include <iostream>
#include <list>
#include <vector>
#include <cmath>
using namespace std;

enum Cor {
    Branco,
    Cinza,
    Preto
};

enum GrafoType {
    Comum,
    Orientado,
    Ponderado,
    Orientado_Ponderado,
};

class Grafo {
    private:
        vector<vector<int>> *matriz_adj;
        int numVertices;
        GrafoType tipo;
        void dfs_visit(vector<Cor> &cor,int v);
    public:
        Grafo(int vertices) : Grafo(vertices, GrafoType::Comum){};
        Grafo(int vertices, GrafoType tipo);
        ~Grafo();
        void display();
        int get_numVertices();
        int get_conexao(int v1, int v2);
        void add_conexao(int v1, int v2, int peso);
        void add_conexao(int v1, int v2);
        void del_conexao(int v1, int v2);
        int grau_vertice(int v);
        bool conexo();
};

Grafo::Grafo(int vertices, GrafoType t) {
    tipo = t;
    numVertices = vertices;
    matriz_adj = new vector<vector<int>>(numVertices,vector<int>(numVertices, -1));
}

Grafo::~Grafo() {
    delete matriz_adj;
    matriz_adj = nullptr;
}

void Grafo::display() {
    for (auto& linha : *matriz_adj){
        for (auto v : linha){
            cout << v << " ";
        }
        cout << endl;
    }
}

void Grafo::add_conexao(int v1, int v2, int peso) {
    if(v1 < numVertices && v2 < numVertices){
        switch(tipo){
            case Comum:
                if (v1 == v2) matriz_adj->at(v1).at(v1) = 2;
                else {
                    matriz_adj->at(v1).at(v2) = 1;
                    matriz_adj->at(v2).at(v1) = 1;
                }
                break;
            case Ponderado:
                matriz_adj->at(v1).at(v2) = peso;
                matriz_adj->at(v2).at(v1) = peso;
                break;
            case Orientado:
                matriz_adj->at(v1).at(v2) = 1;
                break;
            case Orientado_Ponderado:
                matriz_adj->at(v1).at(v2) = peso;
                break;
        }
    }
}//end Grafo::add_conexao();

void Grafo::add_conexao(int v1, int v2){
    add_conexao(v1,v2,1);
}

void Grafo::del_conexao(int v1, int v2){
    if (v1 < numVertices && v2 < numVertices){
        if(tipo == Orientado || tipo == Orientado_Ponderado){
            matriz_adj->at(v1).at(v2) = -1;
        }
        else {
            matriz_adj->at(v1).at(v2) = -1;
            matriz_adj->at(v2).at(v1) = -1;
        }
    }
}

int Grafo::get_conexao(int v1, int v2){
    return matriz_adj->at(v1).at(v2);
}

int Grafo::get_numVertices(){
    return numVertices;
}

void Grafo::dfs_visit(vector<Cor> &cor,int v) {
    cor.at(v) = Cinza;
    for (int i = 0; i < numVertices; i++){
        if (matriz_adj->at(i).at(v) != -1 && cor.at(i) == Branco){
            dfs_visit(cor, i);
        }
    }
    cor.at(v) = Preto;
}//end Grafo::dfs_visit();

// Retorna true se o grafo for fortemente conectado
bool Grafo::conexo() {
    bool conexo = true;
    for(int v = 0; v < numVertices && conexo; v++){
        int componentes {};
        vector<Cor> cor(numVertices, Branco);
        for (int i = v; i < numVertices; i++){
            if(cor.at(i) == Branco){
                dfs_visit(cor, i);
                componentes++;
            }
        }
        if(componentes > 1) conexo = false;

        // Se ainda houverem vertices brancos
        for(auto &v : cor){
            if(v == Branco) conexo = false;
            break;
        }
    }
    return conexo;
}//end Grafo::conexo()


int main(){
    int number_intersections {};
    int number_streets {};
    cin >> number_intersections >> number_streets;
    while(number_intersections > 0 && number_streets > 0){
        Grafo* g = new Grafo(number_intersections, GrafoType::Orientado);
        for(int i = 0; i < number_streets; i++){
            int intersection1 {};
            int intersection2 {};
            int street_type {};
            cin >> intersection1 >> intersection2 >> street_type;
            g->add_conexao(intersection1 - 1, intersection2 - 1);
            if(street_type == 2) g->add_conexao(intersection2 - 1, intersection1 - 1);
        }

        cout << (g->conexo() ? 1 : 0) << endl;

        delete g;
        g = nullptr;

        cin >> number_intersections >> number_streets;
    }

    return 0;
}