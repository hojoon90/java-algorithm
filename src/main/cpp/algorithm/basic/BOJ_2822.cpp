#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(void){
    vector<pair<int,int>> v;
    for(int i = 0; i < 8; i++){
        int n;
        cin >> n;
        v.push_back({n, i+1});
    }
    int result = 0;
    
    //역순 정렬
    sort(v.begin(), v.end(), greater());
    for(int i = 0; i < 5; i++){
        result += v[i].first;
        v[i].first= -1;
    }
    cout << result << "\n";

    sort(v.begin(), v.end());
    for(int i = 0; i < 5; i++){
        cout << v[i].second << " ";
    }

    return 0;
}
