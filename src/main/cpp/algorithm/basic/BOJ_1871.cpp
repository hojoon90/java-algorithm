#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <cmath>
using namespace std;

vector<string> split(string s, char delimiter){
    vector<string> result;
    string token;
    stringstream ss(s);
    while(getline(ss, token, delimiter)){
        result.push_back(token);
    }
    return result;
}


int main(void){
    int t;
    cin >> t;

    for(int tc = 0; tc < t; tc++){
        string s;
        cin >> s;
        vector<string> vs = split(s, '-');

        string word = vs[0];
        int wordNum = 0;
        int backNo = stoi(vs[1]);
        for(int i = word.length()-1; i >= 0; i--){
            int w = word[2-i] - 'A';
            int n = pow(26,i);
            wordNum += w*n;
        }
        int result = abs(wordNum - backNo);
        if(result <= 100) cout << "nice" << "\n";
        else cout << "not nice" << "\n"; 
    }
    
}