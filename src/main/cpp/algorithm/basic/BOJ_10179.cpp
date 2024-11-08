#include <iostream>
#include <cmath>
using namespace std;

int main(){
    int t;
    cin >> t;
    for(int i = 0; i < t; i++){
        double d;
        cin >> d;

        //특정자리수 반올림을 하려면 그만큼 자리수를 곱해줘야 한다.
        cout << fixed;
        d *= 80;
        d = round(d);
        d /= 100;
        cout.precision(2);
        cout << "$" << d  << "\n";
    }
}