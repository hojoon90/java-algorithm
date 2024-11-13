#include <iostream>
#include <string>
using namespace std;

int main(){
    int t, cnt=0;
    string s, ring;
    cin >> s >> t;

    for(int i = 0; i < t; i++){
        cin >> ring;
        ring += ring;

        if(ring.find(s) != string::npos){
            cnt++;
        }
    }

    cout << cnt;

}