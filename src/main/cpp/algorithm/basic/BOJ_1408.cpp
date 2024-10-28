#include <iostream>
#include <string>
using namespace std;

int main(void){

    int curH, curM, curS;
    int stH, stM, stS;
    
    //특정형태 입력 처리
    scanf("%d:%d:%d", &curH, &curM, &curS);
    scanf("%d:%d:%d", &stH, &stM, &stS);

    int s = stS - curS;
    int m = stM - curM;
    int h = stH - curH;
    
    if(s < 0) {
        s = s + 60;
        m -= 1;
    }

    if(m < 0) {
        m = m + 60;
        h -= 1;
    }

    if(h < 0){
        h = h + 24;

    }

    //특정 형태 출력 처리
    printf("%02d:%02d:%02d", h, m, s);
    cout << endl;
}