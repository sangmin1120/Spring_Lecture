#include <iostream>
using namespace std;

void func(){

    cout << "Hello world ( main 2 ) \n";
    cout << "Hello world ( test 1 conflict ) \n";

}
int main(){

    func();
    return 0;
}