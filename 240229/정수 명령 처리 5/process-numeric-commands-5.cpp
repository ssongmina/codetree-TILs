#include <iostream>
#include <vector>

using namespace std;

int main() {
    // 여기에 코드를 작성해주세요.
    vector<int> v;
    int n;
    cin >> n;
    for(int i=0; i<n; i++){
        string c;
        cin >> c;
        if(c=="push_back"){
            int a;
                cin >> a;
                v.push_back(a);
        }
        else if(c=="pop_back"){
            v.pop_back();
        }
        else if(c=="size"){
            cout << v.size() << endl;
        }
        else if(c=="get"){
            int k;
                cin >> k;
                cout << v[k-1] << endl;
        }
    }
    return 0;
}