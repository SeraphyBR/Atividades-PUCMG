#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

float dist_pontos(int x1, int y1, int x2, int y2){
    return sqrt(pow(x2 - x1, 2.0) + pow(y2 - y1, 2.0));
}

int indice_menor(vector<float> &vec){
    int indice {};
    float menor {__FLT_MAX__};
    for(int i = 0; i < vec.capacity(); i++){
        if((vec.at(i) != -1) && (vec.at(i) < menor)){
            menor = vec.at(i);
            indice = i;
        }
    }
    return indice;
}

// Função baseada no PRIM que retorna a soma
// dos pesos da aresta da AGM
float prim(vector<vector<float>> &matriz_dist){
    int size = matriz_dist.capacity();
    vector<float> chave(size,__FLT_MAX__);
    float contador {};
    int menor {};

    chave[0] = -1;
    for (int i = 1; i < size; i++){
        for (int j = 0; j < size; j++){
            if(menor != j){
                if(matriz_dist.at(menor).at(j) < chave.at(j)){
                    chave.at(j) = matriz_dist.at(menor).at(j);
                }
            }
        }
        menor = indice_menor(chave);
        contador += chave.at(menor);
        chave.at(menor) = -1;
    }
    return contador;
}

int main() {
    int num_testes {};
    int num_pessoas {};
    float compr_minimo {};

    cin >> num_testes;
    for(int t = 0; t < num_testes; t++){
        cin >> num_pessoas;
        //Criação e incialização da matriz de distancias.
        vector<vector<float>> matriz_dist(num_pessoas, vector<float>(num_pessoas, 0.0));

        vector<int> x(num_pessoas, -1);
        vector<int> y(num_pessoas, -1);

        for (int p = 0; p < num_pessoas; p++){
            cin >> x.at(p) >> y.at(p);
        }

        for(int i = 0; i < num_pessoas; i++){
            for(int j = 0; j < num_pessoas; j++){
                if (i != j){
                    matriz_dist.at(i).at(j) = dist_pontos(x.at(i), y.at(i), x.at(j), y.at(j));
                }
            }
        }

        compr_minimo = prim(matriz_dist);
        cout.precision(2);
        cout << fixed;
        cout << (compr_minimo / 100.0) << endl;
        cout << endl;
    }
    return 0;
}//end main();
