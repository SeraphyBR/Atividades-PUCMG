// https://www.urionlinejudge.com.br/judge/pt/problems/view/1224
#include <iostream>
#include <vector>
#define llong long long
using namespace std;

void show(vector<llong> &v){
    for(auto &i : v) cout << i << " ";
    cout << endl;
}

int main(){
    int num_cards {};

    while(cin >> num_cards){

        if(num_cards % 2 != 0) continue;

        vector<llong> player[2];
        player[0].resize(num_cards, 0);
        player[1].resize(num_cards, 0);

        vector<llong> cards(num_cards);

        for(auto &c : cards) cin >> c;

        for(int i = 0; i < num_cards - 1; i++){
            player[0][i] = max(cards[i], cards[i+1]);
        }

        short prev, t = 0;

        for(int interval_size = 4; interval_size <= num_cards; interval_size += 2){
            prev = t;
            t = (t == 0) ? 1 : 0;
            for(int i = 0, j = interval_size - 1; j < num_cards; i++, j++) {
                llong x = cards[j] + min(player[prev][i], player[prev][i + 1]);
                llong y = cards[i] + min(player[prev][i+1], player[prev][i + 2]);
                player[t][i] = max(x,y);
            }
        }

        cout << player[t][0] << endl;
    }
    return 0;
}
