#include <iostream>
using namespace std;

int main(){
    int a, b, c;
    cin >> a >> b >> c;
    int arr[101]{0};
    for(int tc = 0; tc < 3; tc++){
        int s, e;
        cin >> s >> e;

        for(int i = s; i < e; i++){
            arr[i]++;
        }
    }


    int result = 0;
    for(int i = 0; i <= 100; i++){
        if(arr[i] == 1) result += a;
        else if(arr[i] == 2) result += 2*b;
        else if(arr[i] == 3) result += 3*c;
    }

    cout << result;
}
