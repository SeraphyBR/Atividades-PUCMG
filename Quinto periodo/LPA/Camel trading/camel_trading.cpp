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

long max_interpret(string expression){
    long max = 1;
    vector<string> split_mult = split(expression,'*');
    for(string &s : split_mult){
        long sum {};
        vector<string> split_sum = split(s, '+');
        for(string &number : split_sum){
            sum += stoi(number);
        }
        max *= sum;
    }
    return max;
}

long min_interpret(string expression){
    long min {};
    vector<string> split_sum = split(expression,'+');
    for(string &s : split_sum){
        long mult = 1;
        vector<string> split_mult = split(s, '*');
        for(string &number : split_mult){
            mult *= stoi(number);
        }
        min += mult;
    }
    return min;
}

int main(){
    int num_expressions;
    cin >> num_expressions;

    for(int i = 0; i < num_expressions; i++){
        string expression {};
        cin >> expression;
        long max = max_interpret(expression);
        long min = min_interpret(expression);
        cout << "The maximum and minimum are " << max << " and " << min << "." << endl;
    }

    return 0;
}