#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(void){
    string n;
    cin >> n;
    int arr[n.length()];
    for(int i = 0; i < n.length(); i++){
        arr[i] = n[i] - '0';
    }
    sort(arr, arr+n.length(), greater());

    for(int i =0; i < sizeof(arr)/sizeof(int); i++){
        cout << arr[i];
    }
    cout << "\n";
    return 0;
}