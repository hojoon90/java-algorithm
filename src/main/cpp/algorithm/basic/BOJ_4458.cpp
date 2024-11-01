#include <iostream>
#include <string>
using namespace std;

int main(void){
    int t;
    cin >> t;
    //https://kin.naver.com/qna/detail.nhn?d1id=1&dirId=1040101&docId=303880876
    getchar();
    for(int tc = 0; tc < t; tc++){
        string s;
        getline(cin, s);
        if(s[0] >= 97){
            s[0] = s[0]-32;
        }
        cout << s << "\n";
    }
    return 0;
}