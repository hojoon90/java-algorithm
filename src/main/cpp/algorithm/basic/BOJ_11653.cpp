#include <bits/stdc++.h>
using namespace std;

int main(void){

    int n;
    cin >> n;

    int p = 2;
    while (n > 1){
        while(n % p == 0){
            n /= p;
            cout << p << endl;
        }
        p++;
    }

}