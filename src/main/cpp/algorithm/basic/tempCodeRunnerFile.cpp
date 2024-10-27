#include <bits/stdc++.h>
using namespace std;

int main(void){
    int allScore = 0;
    for(int i = 0; i < 5; i++){
        int n;
        cin >> n;
        if( n < 40) n = 40;
        allScore += n;
    }

    cout << allScore / 5 << endl;

}