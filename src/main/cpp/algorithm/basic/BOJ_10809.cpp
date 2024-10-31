#include <iostream>
#include <string>
using namespace std;

int main(void){
    string s;
    cin >> s;

    for(int i = 97; i < 123; i++){
        int r = -1;
        for(int j = s.length(); j >= 0; j--){
            char w = s[j];
            if(i == w){
                r = j;
            }
        }
        cout << r << " ";
    }
    cout << "\n";

}