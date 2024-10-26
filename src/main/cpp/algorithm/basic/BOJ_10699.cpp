#include <iostream>
#include <ctime>
using namespace std;

int main(void){
    time_t curTime = time(NULL);
    struct tm*pLocal = localtime(&curTime);

    cout << pLocal->tm_year+1900 << "-" << pLocal->tm_mon +1 << "-" << pLocal->tm_mday;
    return 0;
}