#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main(void){
    int n;
    cin >> n;
    vector<int> q;
    for(int i = 0; i < n; i++){
        string s;
        cin >> s;

        if(s=="push"){
            int n;
            cin >> n;
            q.push_back(n);
        }else if(s=="pop"){
            if(q.empty()){
                cout << -1 << "\n";
            }else{
                cout << q[0] << "\n";
                q.erase(q.begin());
            }
        }else if(s=="size"){
            cout << q.size() << "\n";
        }else if(s=="empty"){
            if(q.empty()) cout << 1 <<"\n";
            else cout << 0 << "\n";
        }else if(s=="front"){
            if(q.empty()) cout << -1 << "\n";
            else cout << q[0] << "\n";
        }else if(s=="back"){
            if(q.empty()) cout << -1 << "\n";
            else cout << q[q.size()-1] << "\n"; 
        }
    }
    return 0;
}