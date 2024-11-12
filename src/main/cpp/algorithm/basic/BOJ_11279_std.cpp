#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;


int main(){
    //입출력을 빠르게 해주는 코드
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n, x;
    cin >> n;
    priority_queue<int> q;

    for(int i = 0; i < n; i++){
        int x;
        cin >> x;
        if(x == 0){
            if(q.empty()) cout << 0 << "\n";
            else{
                //제일 높은 수 출력
                cout << q.top() << "\n";
                
                // //제일 마지막 수를 루트로 땡김
                q.pop();
            }

        }else{
            q.push(x);
        }
    }
    return 0;
}

