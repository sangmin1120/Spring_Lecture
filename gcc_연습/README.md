# GCC  연습 ( 자세한 건 노션 )
---------------------------
- std_header.c : std 관련된 헤더들이 들어있다.
  main에서 printf를 출력하기 위해 std_header.h를 include 해야한다.

- my_header.c : main에 간단한 사칙연산 함수를 호출했다.

- Makefile : 헤더 컴파일하고 링크를 간단하게 하기 위함.

  # ignore
  ----------------
  touch .gitignore => 파일 만들고

 ## 이미 push/commit 된 파일
 --------------------------------
 `
 git rm .env --cached
 git add .
 git commit -m "remove .env file from git"
 git push
 `
