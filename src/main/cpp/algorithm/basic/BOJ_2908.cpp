#include <iostream>
#include <string>
using namespace std;

int main(void){
    string a, b;
    cin >> a >> b;
    string result = "";
    for(int i = 2; i >= 0; i--){
        if(a[i] - '0' > b[i] -'0'){
            result = a;
            break;
        }else if(a[i] -'0' < b[i] - '0'){
            result = b;
            break;
        }
    }
    for(int i = 2; i >= 0; i--){
        cout << result[i];
    }
    cout << "\n";

}