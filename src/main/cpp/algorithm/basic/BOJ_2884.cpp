#include <iostream>
#include <string>
using namespace std;

int main(void){
    int h, m;
    cin >> h >> m;

    if(h == 0) h = 24;
    int minusMin = m - 45;

    if(minusMin < 0){
        h -= 1;
        m = 60 + minusMin;
    }else{
        if(h == 24) h = 0;
        m = minusMin;
    }

    cout << h << ' ' << m << endl;

}