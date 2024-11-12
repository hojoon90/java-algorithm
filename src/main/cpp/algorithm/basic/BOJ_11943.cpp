#include <iostream>
#include <string>
using namespace std;

int main(){
    int n, m;
    cin >> n >> m;
    string arr[n];
    for(int i = 0; i < n; i++){
        string s;
        cin >> s;
        arr[i] = s;
    }

    for(int i = 0; i < n; i++){
        string ns = arr[i];
        for(int j = ns.size()-1; j >= 0; j--){
            cout << ns[j];
        }
        cout << "\n";
    }
}