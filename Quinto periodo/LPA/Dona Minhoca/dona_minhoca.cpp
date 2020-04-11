// https://www.urionlinejudge.com.br/judge/pt/problems/view/1711
#include <iostream>
#include <list>
#include <queue>
#include <vector>
#include <cmath>
#include <map>
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
        int indice_menor(vector<int> &vec);
        void dfs_visit(vector<Cor> &cor,int v,list<int> &lcomp);
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
        vector<list<int>> componentes();
        pair<int,int> prim();
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

void Grafo::dfs_visit(vector<Cor> &cor,int v,list<int> &lcomp) {
    cor.at(v) = Cinza;
    lcomp.push_back(v);
    for (int i = 0; i < numVertices; i++){
        if (matriz_adj->at(i).at(v) != -1 && cor.at(i) == Branco){
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


int Grafo::indice_menor(vector<int> &vec){
    int indice {};
    int menor {__INT_MAX__};
    for(int i = 0; i < vec.capacity(); i++){
        if((vec.at(i) != -1) && (vec.at(i) < menor)){
            menor = vec.at(i);
            indice = i;
        }
    }
    return indice;
}

// Função baseada no PRIM que retorna a soma
// dos pesos das arestas da AGM e o maior peso da AGM
pair<int,int> Grafo::prim(){
    int size = matriz_adj->capacity();
    vector<int> chave(size,__INT_MAX__);
    int soma_agm {};
    int maior_peso {};
    int menor {};

    chave.at(0) = -1;
    for (int i = 1; i < size; i++){
        for (int j = 0; j < size; j++){
            if(menor != j){
                if(matriz_adj->at(menor).at(j) != -1 && matriz_adj->at(menor).at(j) < chave.at(j)){
                    chave.at(j) = matriz_adj->at(menor).at(j);
                }
            }
        }
        menor = indice_menor(chave);
        maior_peso = maior_peso < chave.at(menor) ? chave.at(menor) : maior_peso;
        soma_agm += chave.at(menor);
        chave.at(menor) = -1;
    }
    return pair<int,int>(soma_agm, maior_peso);
}

int main(){
    int number_halls {};
    int number_tunnels {};
    while(cin >> number_halls >> number_tunnels){
        Grafo* g = new Grafo(number_halls, GrafoType::Ponderado);

        for (int t = 0; t < number_tunnels; t++){
            int hall1 {};
            int hall2 {};
            int tunnel_lenght {};
            cin >> hall1 >> hall2 >> tunnel_lenght;
            int old_value = g->get_conexao(hall1 - 1, hall2 - 1);
            if(old_value > tunnel_lenght || old_value == -1){
                g->add_conexao(hall1 - 1, hall2 - 1, tunnel_lenght);
            }
        }

        int number_consults {};
        cin >> number_consults;

        for(int c = 0; c < number_consults; c++){
            int entrance_hall {};
            int worm_size {};
            cin >> entrance_hall >> worm_size;
            if(g->componentes().size() == 1){
                pair<int,int> result = g->prim();
                cout << result.first << endl;
            }
            else {
                cout << -1 << endl;
            }
        }

        delete g;
        g = nullptr;

    }

    return 0;
}