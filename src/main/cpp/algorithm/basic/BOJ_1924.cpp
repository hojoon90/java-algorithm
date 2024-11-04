#include <iostream>
using namespace std;

int main(void){
    int dates[13] = {31,28,31,30,31,30,31,31,30,31,30,31};
    string days[7] ={"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    int month, day;
    cin >> month >> day;
    for(int i = 0; i < month-1; i++){
        day += dates[i];
    }
    int result = day % 7;
    cout << days[result];

    return 0;
}

//2948
int boj_2948(void){
    int dates[12] = {31,28,31,30,31,30,31,31,30,31,30,31};
    string days[7] = {"Wednesday","Thursday", "Friday", "Saturday", "Sunday","Monday", "Tuesday"};

    int month, date;
    cin >> date >> month;
    for(int i = 0; i < month -1; i++){
        date += dates[i];
    }

    int result = date % 7;
    cout << days[result];

    return 0;
}