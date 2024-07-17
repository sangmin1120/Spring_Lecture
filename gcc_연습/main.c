#include "std_headers.h"
#include "my_header.h"

int main(){
    int a,b;
    printf("두 개의 숫자를 입력하세요 : ");
    scanf("%d %d",&a,&b);

    printf("덧셈 : %d\n" , add(a,b));
    printf("뺄셈 : %d\n" , sub(a,b));
    printf("곱셈 : %d\n" , mul(a,b));
    printf("나눗셈 : %d\n" , div(a,b));

    return 0;
}