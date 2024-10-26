#include <iostream>
using namespace std;

int main(void){
    int h, m, p;
    cin >> h >> m >> p;

    int plusHour = p / 60;
    int plusMinute = p % 60;

    m = m + plusMinute;
    if(m >= 60){
        plusHour += 1;
        m = m % 60;
    }

    h = (h + plusHour) % 24;
    
    cout << h << " " << m;
}