#include <iostream>
using namespace std;

int main(){
    int t, n, m;
    cin >> t;
    for(int tc = 0; tc < t; tc++){
        cin >> n >> m;

        int result = 0;
        for(int i = 1; i < n; i++){
            for(int j = i+1; j < n; j++){      
                // double a = (double)((i*i) + (j*j) + m) / (i*j);
                // if((a-(int)a) == 0) result++;
                if((i*i+j*j+m) % (i*j) == 0) result ++;
            }
    }
        cout << result << "\n";
    }

}