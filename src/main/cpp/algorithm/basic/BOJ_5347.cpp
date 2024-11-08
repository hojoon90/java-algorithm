#include <iostream>
using namespace std;

int main(){
    int n, m, t;
    cin >> n >> m;
    int arr[n];
    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }

    int cnt = 0;
    for(int i = 0; i < n; i++){
        for(int j = n-1; j > i; j--){
            if(arr[i] + arr[j] == m) cnt++;
        }
    }

    cout << cnt << "\n";
}