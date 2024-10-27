#include <bits/stdc++.h>
using namespace std;

int main(void){
    int t, n;
    cin >> t;
    string s;

    while(t--){
        cin >> n;
        cin >> s;

        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < n; j++){
                cout << s[i];
            }
        }
        cout << '\n';
        
    }
    return 0;
}