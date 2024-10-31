#include <iostream>
#include <climits>
#include <algorithm>
using namespace std;

int main(void){
    int hamberger = INT_MAX;
    int drink = INT_MAX;
    for(int i = 0; i < 3; i++){
        int h;
        cin >> h;
        hamberger = min(hamberger, h);
    }
    for(int i = 0; i < 2; i++){
        int d;
        cin >> d;
        drink = min(drink, d);
    }
    int total = hamberger + drink - 50;
    cout << total;
    return 0;
}