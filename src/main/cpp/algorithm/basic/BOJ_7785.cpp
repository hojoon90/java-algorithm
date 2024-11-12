#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int n;
    cin >> n;
    map<string, bool> m;
    vector<string> v;
    for(int i = 0; i < n; i++){
        string name, status;
        cin >> name >> status;
        bool isStatus = status == "leave" ? false : true;
        if(m.find(name) == m.end()){
            m.insert(make_pair(name, isStatus));
        }else{
            m[name] = isStatus;
        }
    }

    for(pair<string, bool> p : m) {
        if(p.second) v.push_back(p.first);
    }

    sort(v.begin(), v.end(), greater());
    for(string s:v){
        cout << s << "\n";
    }
    return 0;

}