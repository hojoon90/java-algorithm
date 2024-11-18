#include <bits/stdc++.h>
using namespace std;

int main(){
    int n, p;
    while(true){
        cin >> n; 
        if(n == 0) break;
        cin >> p;

        vector<int> v;
        v.push_back(p % 2 ? p+1 : p-1);
        v.push_back(p % 2 ? n-p : n-p+1);
        v.push_back(p % 2 ? n-p+1 : n-p+2);

        sort(v.begin(), v.end());
        for(int vi : v){
            cout << vi << " ";
        }
        cout << "\n";
    }


}