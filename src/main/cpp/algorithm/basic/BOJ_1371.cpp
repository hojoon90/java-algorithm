#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(){
    string s;
    int arr[26]{0};
    while(!cin.eof()){
        getline(cin, s);

        for(int i = 0 ; i < s.size(); i++){
            int idx = s[i] - 'a';
            arr[idx]++;
        }
    }

    int mxNum = 0;
    for(int i = 0; i < 26; i++){
        mxNum = max(arr[i], mxNum);
    }

    for(int i =0; i < 26; i++){
        if(arr[i] == mxNum) {
            char w = i + 'a';
            cout << w;
        }
    }
    return 0;
}