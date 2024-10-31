#include <iostream>
#include <vector>
#include <string>
#include <sstream>
using namespace std;

vector<int> split(string s, char delimiter){
    vector<int> result;
    string token;
    stringstream ss(s);
    while(getline(ss, token, delimiter)){
        result.push_back(stoi(token));
    }
    return result;
}

int main(void){
    int n;
    cin >> n;

    for(int i = 0; i < n; i++){
        string tmp;
        cin >> tmp;
        vector<int> v = split(tmp, ',');
        cout << v[0] + v[1] << "\n";
    }
    return 0;
}