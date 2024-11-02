#include <iostream>
using namespace std;

int main(void){
    int a, b;
    while(cin){
        cin >> a >> b;
        //입력값 종료처리
        if(cin.eof()) break;
        cout << a+b << "\n";
    }
    return 0;

}