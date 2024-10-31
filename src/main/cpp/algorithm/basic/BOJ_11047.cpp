#include <iostream>
using namespace std;

int main(void){
    int n, k;
    cin >> n >> k;
    int money[n];
    for(int i = n-1; i >= 0; i--){
        cin >> money[i];
    }

    int moneyCnt = 0;
    for(int i = 0; i < n; i++){
        moneyCnt += k / money[i];
        k %= money[i];
    }

    cout << moneyCnt << "\n";
    return 0;
}