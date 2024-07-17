#include "std_header.h"
#include "my_header.h"

int main(){
    printf("두 수를 입력해 주세요: ");
    int a,b;
    scanf("%d %d",&a,&b);

    printf("덧셈: %d\n",add(a,b));
    printf("뺄셈: %d\n",sub(a,b));
    printf("곱셈: %d\n",mul(a,b));
    printf("나눗셈: %d\n",div(a,b));

    return 0;
}