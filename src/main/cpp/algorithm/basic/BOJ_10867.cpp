#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(void){
    int n, a;
    cin >> n;

    vector<int> v;
    for(int i = 0; i < n; i++){
        cin >> a;
        v.push_back(a);
    }
    sort(v.begin(), v.end());
    v.erase(unique(v.begin(), v.end()), v.end());

    for(int i = 0; i < v.size(); i++){
        cout << v[i] << " ";
    }
}