#include <iostream>
#include <cmath>
using namespace std;

int gcd(int a, int b){
    int t;
    while(b != 0){
        t = a % b;
        a = b;
        b = t;
    }
    return a;
}

int main(void){
    int n;
    cin >> n;
    for(int i =0; i < n; i++){
        int a, b;
        cin >> a >> b;

        int lcm = a*b/gcd(a, b);
        cout << lcm << " " << gcd(a, b) << "\n";
    }
}