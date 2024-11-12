#include <iostream>
#include <string>
#include <algorithm>
#include <vector>
#include <map>
using namespace std;

int main(){
    int n, m;
    cin >> n >> m;
    string s;

    vector<string> v;
    map<string, bool> mp;

    int cnt =0;
    for(int i = 0; i < n; i++){
        cin >> s;
        mp.insert(make_pair(s, true));
    }

    for(int i = 0; i < m; i++){
        cin >> s;
        if(mp[s]){
            cnt++;
            v.push_back(s);
        }
    }

    cout << cnt << "\n";
    sort(v.begin(), v.end());
    for(int i = 0; i < v.size(); i++){
        cout << v[i] << "\n";
    }
    return 0;
}