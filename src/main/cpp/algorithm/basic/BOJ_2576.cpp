#include <iostream>
#include <climits>
using namespace std;

int main(void){
    int result = 0;
    int min = INT_MAX;
    for(int i =0; i < 7; i++){
        int n;
        cin >> n;
        if(n % 2 != 0){
            if(min > n){
                min = n; 
            }
            result += n;
        }
    }

    if(min == INT_MAX) cout << -1 << "\n";
    else cout << result << "\n" << min << "\n";
}