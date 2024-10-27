#include <bits/stdc++.h>
using namespace std;

int main(void){
    long long n;
    cin >> n;

    long long result = 0;
    long long idx = 1;
    while(true){
        if(n == 1) {
            break;
        }
        idx++;
        result += idx;
        if(result >= n) {
            idx--;
            break;
        }
    }

    cout << idx << endl;

}