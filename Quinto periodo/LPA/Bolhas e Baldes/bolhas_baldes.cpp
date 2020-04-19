#include <iostream>
#include <vector>
using namespace std;

// Merges two subarrays of arr[].
// First subarray is arr[l..m]
// Second subarray is arr[m+1..r]
int merge(vector<int> &arr, int l, int m, int r, int moves)
{
    int i, j, k;
    int n1 = m - l + 1;
    int n2 =  r - m;
    int mv = moves;

    /* create temp arrays */
    vector<int> L {};
    vector<int> R {};

    /* Copy data to temp arrays L[] and R[] */
    for (i = 0; i < n1; i++) {
        L.push_back(arr.at(l + i));
    }
    for (j = 0; j < n2; j++) {
        R.push_back(arr.at(m + 1 + j));
    }

    /* Merge the temp arrays back into arr[l..r]*/
    i = 0; // Initial index of first subarray
    j = 0; // Initial index of second subarray
    k = l; // Initial index of merged subarray
    while (i < n1 && j < n2)
    {
        if (L.at(i) <= R.at(j))
        {
            arr.at(k) = L.at(i);
            i++;
        }
        else
        {
            arr.at(k) = R.at(j);
            j++;
            mv += n1 - i;
        }
        k++;
    }

    /* Copy the remaining elements of L[], if there
       are any */
    while (i < n1)
    {
        arr.at(k) = L.at(i);
        i++;
        k++;
    }

    /* Copy the remaining elements of R[], if there
       are any */
    while (j < n2)
    {
        arr.at(k) = R.at(j);
        j++;
        k++;
    }
    return mv;
}

/* l is for left index and r is right index of the
   sub-array of arr to be sorted */
int mergeSort(vector<int> &arr, int l, int r)
{
    int moves {};
    if (l < r)
    {
        // Same as (l+r)/2, but avoids overflow for
        // large l and h
        int m = l+(r-l)/2;

        // Sort first and second halves
        moves = mergeSort(arr, l, m) + mergeSort(arr, m+1, r);
        moves = merge(arr, l, m, r, moves);
    }
    return moves;
}

int main(){
    int N {};
    cin >> N;
    while (N != 0){
        vector<int> P(N);
        for(int i = 0; i < N; i++) cin >> P[i];
        int moves = mergeSort(P, 0, P.size() - 1);
        moves % 2 == 0 ? cout << "Carlos" << endl : cout << "Marcelo" << endl;
        cin >> N;
    }

    return 0;
}
