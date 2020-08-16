#include <iostream>
#include <vector>

using std::cin;
using std::cout;
using std::endl;
using std::vector;

int main() {
    int num_columns {};
    cin >> num_columns;
    vector<int> cs(num_columns + 2, 0);

	for(int i = 1; i <= num_columns; i++) {
        cin >> cs.at(i);
        cs.at(i) = cs.at(i) > cs.at(i - 1) ? cs.at(i - 1) + 1 : cs.at(i);
    }

	for(int i = num_columns; i >= 1; i--)
        cs.at(i) = cs.at(i) > cs.at(i + 1) ? cs.at(i + 1) + 1 : cs.at(i);

    int biggest {};
	for(int i = 0; i <= num_columns; i++)
        biggest = cs.at(i) > biggest ? cs.at(i) : biggest;

    cout << biggest << endl;
	return 0;
}