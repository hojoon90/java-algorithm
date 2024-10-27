#include <bits/stdc++.h>
using namespace std;

int main(void){

    string a, b, c;

    cin >> a >> b >> c;

    int al = a.length();
    int cl = c.length();

    if(b == "+") {

        if(al > cl){
            int idx = al - cl;
            for(int i = 0; i < al; i++){
                if(idx <= i){
                    cout << int(c[i-idx]) - '0' + int(a[i]) - '0';
                }else{
                    cout << a[i];
                }
            }
        }else if(al < cl){
            int idx = cl - al;
            for(int i = 0; i < cl; i++){
                if(idx <= i){
                    cout << int(a[i-idx]) - '0' + int(c[i]) - '0';
                }else{
                    cout << c[i];
                }
            }
        }else{
            for(int i = 0; i < al ; i++){
                int n1 = int(a[i]) - '0' + int(c[i]) - '0';
                cout << n1;
            }
        }

    }else {
        cout << 1;
        for(int i = 1; i < al + cl-1; i++){
            cout << 0;
        }
    }

    cout<<'\n';
    return 0;

}