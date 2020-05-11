#include <vector>
#include <iostream>

using namespace std;

vector<string> split(string s, char delimiter){
    vector<string> result;
    int pos {};
    while((pos = s.find(delimiter)) != string::npos){
        result.push_back(s.substr(0,pos));
        s.erase(0, pos + 1);
    }
    result.push_back(s);
    return result;
}

void display(vector<string> &v){
    for(auto &s : v) cout << s << ' ';
    cout << endl;
}

int main(){
    int num_expressions;
    cin >> num_expressions;

    vector<string> expressions(num_expressions);

    for(auto &exp : expressions) cin >> exp;

    for(auto exp : expressions){
        int max = 1;
        vector<string> maxs = split(exp,'*');
        for(string &s : maxs){
            int sum {};
            vector<string> s2 = split(s, '+');
            for(string &number : s2){
                sum += stoi(number);
            }
            max *= sum;
        }
        int min {};
        vector<string> mins = split(exp,'+');
        for(string &s : mins){
            int mult = 1;
            vector<string> s2 = split(s, '*');
            for(string &number : s2){
                mult *= stoi(number);
            }
            min += mult;
        }
        cout << max << endl;
        cout << min << endl;

    }

    return 0;
}