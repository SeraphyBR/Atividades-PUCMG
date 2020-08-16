#include <iostream>
#include <algorithm>
#include <vector>

using std::cin;
using std::cout;
using std::endl;
using std::vector;
using std::min;

// https://www.youtube.com/watch?v=jgiZlGzXMBw
int main(){
    int num_instances {};
    cin >> num_instances;
    for(int i = 0; i < num_instances; i++){
        int block_types {};
        int desired_length {};

        cin >> block_types;
        cin >> desired_length;

        vector<int> blocks(block_types, 0);
        for(auto& i : blocks) cin >> i;
        sort(blocks.begin(), blocks.end());

        vector<int> min_amount(desired_length + 1, desired_length + 1);
        min_amount.at(0) = 0;
        for(int i = 1; i < min_amount.size(); i++){
            for(auto& length : blocks){
                if(length <= i){
                    min_amount.at(i) = min(min_amount.at(i - length) + 1, min_amount.at(i));
                }
            }
        }

        cout << min_amount.at(desired_length) << endl;
    }
    return 0;
}
