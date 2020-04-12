#include <iostream>
#include <vector>
#include <map>
using namespace std;


class SuffixAutomaton {
    public:
        SuffixAutomaton(string s);
        int distinct_substrings();
    private:
        // edges[i] : the labeled edges from node i
        vector<map<char,int>> edges {};
        // link[i] : the parent of i
        vector<int> link {};
        // length[i] : the length of the longest string in the ith class
        vector<int> length {};
        // The index of equivalence class of the whole string
        int last {};
};

SuffixAutomaton::SuffixAutomaton(string s){
    // add the initial node
    this->edges.push_back(map<char,int>());
    this->link.push_back(-1);
    this->length.push_back(0);

    for(int i = 0; i < s.size(); i++){
        // constructs r
        this->edges.push_back(map<char,int>());
        this->length.push_back(i+1);
        this->link.push_back(0);
        int r = this->edges.size() - 1;

        // add edges to r and find p with link to q
        int p = this->last;
        while(p >= 0 && this->edges.at(p).find(s.at(i)) == edges.at(p).end()){
            this->edges.at(p)[s.at(i)] = r;
            p = this->link.at(p);
        }

        if(p != -1){
            int q = edges.at(p).at(s.at(i));
            if(this->length.at(p) + 1 == this->length.at(q)){
                // we do not have to split q, just set the correct suffix link
                this->link.at(r) = q;
            }
            else {
                // we have to split, add q'
                this->edges.push_back(this->edges.at(q)); // copy edges of q
                this->length.push_back(this->length.at(p) + 1);
                this->link.push_back(this->link.at(q)); // copy parent of q

                int qq = edges.size() - 1;
                // add qq as the new parent of q and r
                this->link.at(q) = qq;
                this->link.at(r) = qq;
                // move short classes pointing to q to point to q'
                while(p >= 0 && this->edges.at(p).at(s.at(i)) == q){
                    this->edges.at(p)[s.at(i)] = qq;
                    p = this->link.at(p);
                }
            }
        }
        this->last = r;
    }
}

int SuffixAutomaton::distinct_substrings(){
    int count {};
    for(int i = 1; i < this->length.size(); i++){
        // The number of distinct substrings is equal the sum of
        // the length of each node substring minus the length of the parent node substring
        count += this->length.at(i) - this->length.at(this->link.at(i));
    }
    return count;
}

// by brute force
int distinct_substrings(string s){

}

int main() {
    int number_test {};
    cin >> number_test;
    for(int i = 0; i < number_test; i++) {
        string s1 {};
        string s2 {};
        cin >> s1 >> s2;
        int number_substring1 = SuffixAutomaton(s1).distinct_substrings();
        int number_substring2 = SuffixAutomaton(s2).distinct_substrings();
        if(number_substring1 == number_substring2){
            cout << "s" << endl;
        }
        else {
            cout << "n" << endl;
        }
    }
}