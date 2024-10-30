#include <iostream>
using namespace std;

int main(void){
    int t, n;
    cin >> t;

    for(int test = 0; test < t; test++){
        cin >> n;
        int totalh = 0;
        double totalp = 0.0;
        for(int i = 0; i < n; i++){
            int h;
            double p;
            cin >> h >> p;

            totalh += h;
            totalp += h * p;

        }
        cout.precision(1);
        cout << fixed << totalh << " " << (totalp / totalh) << endl;
    }

}