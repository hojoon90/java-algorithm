#include <iostream>
#include <string>
using namespace std;

string rev(string s){
    string result = "";
    for(int i = s.length()-1; i >= 0; i--){
        result += s[i];
    }
    return result;
}

int main(void){
    string s1, s2;
    cin >> s1 >> s2;

    string result = rev(to_string(stoi(rev(s1)) + stoi(rev(s2))));

    cout << stoi(result);
}