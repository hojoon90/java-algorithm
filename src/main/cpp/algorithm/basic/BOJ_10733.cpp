#include <iostream>
#include <stack>
using namespace std;

int main(void){
    int n;
    cin >> n;
    stack<int> s;
    for(int i = 0; i < n; i++){
        int p;
        cin >> p;
        if(p != 0){
            s.push(p);
        }else{
            s.pop();
        }
    }
    int result = 0;
    while(!s.empty()){
        result += s.top();
        s.pop();
    }

    cout << result << "\n";
    return 0;
}