#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

string arr[10] = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

int main(void){
    string c1, c2, c3;
    cin >> c1 >> c2 >> c3;

    auto it1 = find(begin(arr), end(arr), c1);
    string idx1 = to_string(distance(arr, it1));

    auto it2 = find(begin(arr), end(arr), c2);
    string idx2 = to_string(distance(arr, it2));

    auto it3 = find(begin(arr), end(arr), c3);
    int idx3 = distance(arr, it3);

    string sum = idx1+idx2;
    long long h = 1;
    for(int i = 0; i < idx3; i++){
        h *= 10;
    }
    
    cout << stol(sum) * h << "\n";

}