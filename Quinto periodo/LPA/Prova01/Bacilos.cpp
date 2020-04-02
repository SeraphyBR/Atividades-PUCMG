// https://www.urionlinejudge.com.br/judge/pt/problems/view/1380
#include <iostream>
#include <vector>
#include<iomanip>

using namespace std;

int mod(string big_number, int n){
    int result = 0;

    for (int i = 0; i < big_number.length(); i++){
        result = (result * 10 + (big_number.at(i) - '0')) % n;
    }

    return result;
}


int main(){

    // Criar um vetor para armazenar o periodico pisano mod 1000
    vector<int> fibo_pisano_1000N {};

    // O pisano de mod 1000 tem tamanho de 1500
    // https://webspace.ship.edu/msrenault/fibonacci/fiblist.htm
    fibo_pisano_1000N.reserve(1500);

    fibo_pisano_1000N.push_back(1);
    fibo_pisano_1000N.push_back(1);
    for(int f = 2; f < 1500; f++){
        fibo_pisano_1000N.push_back((fibo_pisano_1000N.at(f - 1) + fibo_pisano_1000N.at(f - 2)) % 1000);
    }

    int t_instances {};
    string k {};
    cin >> t_instances;
    for(int i = 0; i < t_instances; i++){
        cin >> k;
        cout << setw(3) << setfill('0') << fibo_pisano_1000N.at(mod(k, 1500) - 1) << endl;
    }

    return 0;
}