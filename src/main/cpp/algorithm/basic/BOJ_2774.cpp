#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(void){
    int t;
    cin >> t;
    for(int tc = 0; tc < t; tc++){
        string s;
        cin >> s;
        vector<char> v;
        for(int i = 0; i < s.length(); i++){
            v.push_back(s[i]);
        }
        sort(v.begin(), v.end());
        v.erase(unique(v.begin(), v.end()), v.end());

        cout << v.size() << "\n";
    }
    return 0;
}