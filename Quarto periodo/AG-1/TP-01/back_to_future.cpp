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

enum GrafoType {
    Comum,
    Orientado,
    Ponderado,
    Orientado_Ponderado,
};

class Grafo {
    using MinHeap = priority_queue<int, vector<int>, greater<int>>;

    private:
        vector<vector<int>> *matriz_adj;
        int numVertices;
        GrafoType tipo;
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
        int dijkstra(bool caminho_unico);
        int dijkstra();
        vector<list<int>> componentes();
};

Grafo::Grafo(int vertices, GrafoType t) {
    tipo = t;
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
            matriz_adj->at(v1).at(v2) = 0;
        }
        else {
            matriz_adj->at(v1).at(v2) = 0;
            matriz_adj->at(v2).at(v1) = 0;
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

int menor_nao_visitado(vector<int> &vec, vector<int> &visitado){
    int indice {};
    int menor {__INT_MAX__};
    for(int i = 0; i < vec.capacity() && i < visitado.capacity(); i++){
        if(visitado.at(i) != 1 && vec.at(i) < menor){
            menor = vec.at(i);
            indice = i;
        }
    }
    return indice;
}

// Algoritmo de dijkstra que retorna o somatorio dos pesos do caminho
// Modificado de forma a não usar o mesmo caminho na proxima chamada
int Grafo::dijkstra(bool caminho_unico){
    vector<int> dist {numVertices, __INT_MAX__};
    vector<int> pai {numVertices, -1};
    vector<int> visitado {numVertices,0};
    dist.at(0) = 0;
    visitado.at(0) = 1;
    int menor {};
    for (int i = 0; i < numVertices; i++){
        for (int j = 0; j < numVertices; j++){
            if(visitado.at(j) != 1 && j != menor && matriz_adj->at(menor).at(j) != 0){
                if(dist.at(j) > dist.at(menor) + matriz_adj->at(menor).at(j)){
                    dist.at(j) = dist.at(menor) + matriz_adj->at(menor).at(j);
                    pai.at(j) = menor;
                }
            }

            cout << "teste" << endl;
        }
        visitado.at(menor) = 1;
        menor = menor_nao_visitado(dist, visitado);
    }

    if(caminho_unico) {
        int v = numVertices - 1;
        while(pai.at(v) != -1){
            del_conexao(pai.at(v), v);
            v = pai.at(v);
        }
        if (v != 0) return -1;//Caso a volta não seja possivel
    }
    return dist.at(numVertices - 1);
}

int Grafo::dijkstra() {
    return dijkstra(false);
}

int main(){
    int num_cidades {};
    int num_rotas {};

    for(int instancia = 1; cin >> num_cidades; instancia++){
        cin >> num_rotas;
        Grafo *g = new Grafo(num_cidades, GrafoType::Ponderado);
        int a {};
        int b {};
        int c {};
        int num_amigos {};
        int assentos_livres {};
        int preco_final {};
        int preco_unitario {};
        for(int r = 0; r < num_rotas; r++){
            cin >> a >> b >> c;
            g->add_conexao(a - 1,b - 1,c);
        }
        cin >> num_amigos >> assentos_livres;
        g->display();
        while(num_amigos > 0) {
            preco_unitario = g->dijkstra(true);
            if(num_amigos > assentos_livres){
                preco_final += preco_unitario * assentos_livres;
            }
            else preco_final += preco_unitario * num_amigos;
            num_amigos -= assentos_livres;
            if(preco_final == -1) break;//Caso impossivel
        }

        cout << "Instancia " << instancia << endl;
        cout << (preco_final == -1 ? string("impossivel") : to_string(preco_final)) << endl;
        cout << endl << endl << endl;
    }


    return 0;
}