#include <vector>
#include <iostream>

using namespace std;

int budget {};
vector<vector<int>> garments;
vector<vector<int>> aux;

void debug(){
    cout << "Passei aqui" << endl;
}

int max_shop(int money, int garment){
    if(money < 0) return -1;

    if(garment == garments.size()) return budget - money;

    if(aux.at(money).at(garment) != -1) return aux.at(money).at(garment);

    int result = -1;

    for(int i = 0; i < garments.at(garment).size(); i++){
        result = max(result, max_shop(money - garments.at(garment).at(i), garment + 1));
    }

    return aux[money][garment] = result;
}

int main(){
    int num_tests {};
    int num_garments {};

    cin >> num_tests;
    for(int i = 0; i < num_tests; i++) {
        cin >> budget >> num_garments;
        aux = vector<vector<int>>(budget + 1,vector<int>(num_garments, -1));

        for(int j = 0; j < num_garments; j++){
            int models {};
            cin >> models;
            vector<int> garment(models,0);
            for(auto &price : garment) cin >> price;
            garments.push_back(garment);
        }

        int ans = max_shop(budget,0);

        if(ans > 0) cout << ans << endl;
        else cout << "no solution" << endl;

        garments.clear();
        aux.clear();
    }


    return 0;
}
