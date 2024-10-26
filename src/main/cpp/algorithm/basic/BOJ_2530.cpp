#include <iostream>
using namespace std;

int main(void){
    int h, m, s;
    int p;
    cin >> h >> m >> s >> p;
    
    int ph = 0;
    int pm = 0;
    int ps = 0;


    if(p >= 3600){
        ph = p / 3600; 
        pm = (p - 3600*ph) / 60;
        ps = (p - 3600*ph) % 60;   
    }else{
        pm = p / 60;
        ps = p % 60;
    }

    s = s + ps;
    m = m + pm;
    h = h + ph;

    if(s >= 60){
        m += 1;
        s = s % 60;
    }


    if(m >= 60){
        h += 1;
        m = m % 60;
    }

    h = h % 24;

    cout << h << " " << m << " " << s <<'\n';

}