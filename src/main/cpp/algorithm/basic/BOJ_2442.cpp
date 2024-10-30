#include <iostream>
#include <string>
using namespace std;

int main(void){
    int n;
    cin >> n;

    for(int i = n-1; i >= 0; i--){
        for(int j = 0; j < n-1; j++){
            if(j >= i) cout << "*";
            else cout << " ";
        }
        for(int j = n-1; j >= 0; j--){
            if(j >= i) cout << "*";
        }
        cout << '\n';
    }

}