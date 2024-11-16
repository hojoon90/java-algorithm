#include <iostream>
#include <string>
#include <cctype>
using namespace std;

int main(){
    int n;
    cin >> n;
    cin.ignore();
    for(int tc = 1; tc <= n; tc++){
        string s;
        getline(cin, s);
        int arr[26]{0};

        for(char& c: s){
            c = tolower(c);
        }
        

        for(int i = 0; i < s.size(); i++){
            if(s[i] >= 'a' && s[i] <='z'){
                int wi = s[i] - 'a';
                arr[wi]++;
            }
        }

        int standNum = arr[0];
for(int i = 1; i < 26; i++){
            standNum = min(standNum, arr[i]);
        }

        if(standNum == 0) cout << "Case " << tc << ": Not a pangram";
        else{
            string multi = "Pangram!";
            if(standNum == 2) multi = "Double pangram!!";
            else if(standNum == 3) multi = "Triple pangram!!!";

            cout << "Case " << tc << ": " << multi;
        }
        cout << "\n";
    }
    return 0;
}