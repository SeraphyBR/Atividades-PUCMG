#include<iostream>

using namespace std;

int main(){
    string p {};
    getline(cin, p);
    int maiusculas {};
    while(p != "FIM "){
        for(auto c : p){
            if(c <= 'Z' && c >= 'A'){
                maiusculas++;
            }
        }
        cout << maiusculas << endl;
        maiusculas = 0;
        getline(cin, p);
    }
    return 0;
}
