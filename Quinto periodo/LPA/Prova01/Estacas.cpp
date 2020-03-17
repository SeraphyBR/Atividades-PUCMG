// https://www.urionlinejudge.com.br/judge/pt/problems/view/1630
#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int x {};
    int y {};
    while(cin >> x >> y){
        int perimetro = 2 * x + 2 * y;
        int mdc = __gcd(x,y);
        cout << perimetro/mdc << endl;
    }
    cout << endl;
}
