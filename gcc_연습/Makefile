all : main.out

main.out : main.o my_header.o std_headers.o
	gcc -o main.out main.o my_header.o std_headers.o

main.o : main.c my_header.h std_headers.h
	gcc -c main.c

my_header.o : my_header.c
	gcc -c my_header.c

std_headers.o : std_headers.c
	gcc -c std_headers.c

clean :
	rm -f *.o *.out