#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int number_tests {};
    cin >> number_tests;
    for(int i = 0; i < number_tests; i++){
        int f1 {};
        int f2 {};
        cin >> f1 >> f2;
        cout << __gcd(f1,f2) << endl;
    }
}