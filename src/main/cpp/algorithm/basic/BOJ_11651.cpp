#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(pair<int, int> a, pair<int, int> b){
    if(a.second == b.second){
        return a.first < b.first;
    }
    return a.second < b.second;
}

int main(void){
    int t;
    cin >> t;
    pair<int, int> pArr[t];
    for(int i = 0; i < t; i++){
        pair<int,int> p;
        cin >> p.first >> p.second;
        pArr[i] = p;
    }

    sort(pArr, pArr+t, compare);

    for(int i = 0; i < t; i++){
        cout << pArr[i].first << " " << pArr[i].second << "\n";
    }

    return 0;
}