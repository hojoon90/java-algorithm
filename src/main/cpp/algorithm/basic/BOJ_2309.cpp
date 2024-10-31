#include <iostream>
#include <algorithm>
using namespace std;

int main(void){

    int allP[9];
    int result = 0;
    for(int i = 0; i < 9; i++){
        cin >> allP[i];
        result += allP[i];
    }
    sort(allP, allP+9);

    for(int i = 0; i < 8; i++){
        for(int j = 0; j < 9; j++){
            if(result - (allP[i] + allP[j]) == 100){
                for(int k = 0; k < 9; k++){
                    if(k != i && k != j ){
                        cout << allP[k] << "\n";
                    }
                }
                return 0;
            }
        }
    }

    return 0;
}