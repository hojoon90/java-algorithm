#include <iostream>
#include <string>
using namespace std;

int main(void){
    int t, n;
    cin >> t;
    int arr[100];
    for(int test = 0; test < t; test++){
        cin >> n;
        int idx = 0;
        while(n > 0){
            arr[idx++] = n%2;
            n /= 2;
        }

        for(int i = 0; i < idx; i++){
            if(arr[i] == 1) cout << i << " ";
        }
        cout << "\n";
    }
}