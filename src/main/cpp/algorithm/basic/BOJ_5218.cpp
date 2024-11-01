#include <iostream>
#include <string>
using namespace std;

int main(void){
    int t;
    cin >> t;
    for(int tc = 0; tc < t; tc++){
        string s1, s2;
        cin >> s1 >> s2;

        cout << "Distances: ";
        for(int i = 0; i < s1.length(); i++){
            int distance = 0;
            if(s1[i] > s2[i]){
                distance = int(s2[i]) + 26 - int(s1[i]);
            }else if(s1[i] < s2[i]){
                distance = int(s2[i]) - int(s1[i]);
            }
            cout << distance <<" ";
        }
        cout << "\n";
    }
    return 0;
}