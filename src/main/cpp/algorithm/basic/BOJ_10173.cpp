#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(void){
    while(true){
        string s;
        getline(cin, s);
        if(s == "EOI") break;

        transform(s.begin(), s.end(), s.begin(), ::tolower);
        if(s.find("nemo") != string::npos) cout << "Found" << "\n";
        else cout << "Missing" << "\n";
    }
    
}