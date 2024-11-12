#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> v;

//최근에 들어온 원소를 알맞은 위치까지 올려줌.
void heapifyUp(int idx){
    int parent = (idx - 1)/2;
    while(idx > 0 && v[idx] > v[parent]){
        swap(v[idx], v[parent]);
        idx = parent;
        parent = (idx - 1) / 2;
    }

}

//제일 높은수가 위로 오게 정렬.
void heapifyDown(int idx){
    int leftchild = 2*idx+1;
    int rightchild = 2*idx+2;
    int largest = idx;

    if(leftchild < v.size() && v[leftchild] > v[largest]){
        largest = leftchild;
    }

    if(rightchild < v.size() && v[rightchild] > v[largest]){
        largest = rightchild;
    }

    if(largest != idx){
        swap(v[idx], v[largest]);
        heapifyDown(largest);
    }

}


int main(){
    int n, x;
    cin >> n;

    for(int i = 0; i < n; i++){
        int x;
        cin >> x;
        if(x == 0){
            if(v.empty()) cout << 0 << "\n";
            else{
                //제일 높은 수 출력
                cout << v[0] << "\n";
                
                //제일 마지막 수를 루트로 땡김
                v[0] = v.back();
                v.pop_back();
                heapifyDown(0);
            }

        }else{
            v.push_back(x);
            heapifyUp(v.size()-1);
        }
    }
    return 0;
}