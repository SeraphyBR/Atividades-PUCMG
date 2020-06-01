#include <iostream>
#include <vector>
#define debug cout << "Passei aqui" << endl;

using std::cin;
using std::cout;
using std::endl;
using std::end;
using std::vector;
using std::string;

template<class T> using Matrix = vector<vector<T>>;

template<class T>
void display(Matrix<T>& matrix) {
    for (vector<T>& row : matrix) {
        for (T value : row){
            cout << value << " ";
        }
        cout << endl;
    }
}

Matrix<int> matrix;

bool bpm(int u, vector<bool> &visited, vector<int> &matchR) {
    for (int v = 0; v < matrix.at(u).size(); v++) {
        int ve = matrix.at(u).at(v);
        if (!visited.at(ve)) {
            visited.at(ve) = true;
            if (matchR[ve] < 0 || bpm(matchR[ve], visited, matchR)) {
                matchR[ve] = u;
                return true;
            }
        }
    }
    return false;
}

int max_towers(int N)
{
    vector<int> matchR(N, -1);
    int result = 0;
    for (int u = 0; u < N; u++)
    {
        vector<bool> seen(matrix.size() + 1, false);
        if (bpm(u, seen, matchR))
            result++;
    }
    return result;
}

int main(){
    int board_size;
    while(cin >> board_size){
        Matrix<char> board(board_size, vector<char>(board_size, '.'));
        Matrix<int> id(board_size, vector<int>(board_size, 0));
        for(auto& row : board){
            for(char &c : row){
                cin >> c;
            }
        }

        matrix = Matrix<int>(board_size * board_size);
        int l = 0;
        for(int i = 0; i < board_size; i++){
            for(int j = 0 ; j < board_size; j++){
                if(board.at(i).at(j) == 'X'){
                    l++;
                    continue;
                }
                id[i][j] = l;
            }
            l++;
        }
        int c = 0;
        for(int i = 0; i < board_size; i++){
            for(int j = 0 ; j < board_size; j++){
                if(board.at(j).at(i) == 'X'){
                    c++;
                    continue;
                }
                matrix.at(c).push_back(id.at(j).at(i));
            }
            c++;
        }

        cout << max_towers(board_size * board_size) << endl;
    }
    return 0;
}
