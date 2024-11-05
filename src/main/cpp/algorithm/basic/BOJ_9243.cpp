#include <iostream>
#include <string>
using namespace std;

int main(void){
    int n;
    string s1, s2;
    cin >> n >> s1 >> s2;

    for(int i = 0; i < s1.length(); i++){
        if(n % 2 == 0){
            if(s1[i] != s2[i]){
                cout << "Deletion failed" << "\n";
                return 0;
            }
        }else{
            if(s1[i] == s2[i]){
                cout << "Deletion failed" << "\n";
                return 0;
            }
        }
    }
    cout << "Deletion succeeded" << "\n";
    return 0;
}