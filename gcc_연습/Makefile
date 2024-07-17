all : main.out

main.out : main.o my_header.o std_header.o
	gcc -o main.out main.o my_header.o std_header.o

main.o : main.c
	gcc -c main.c

my_header.o : my_header.c
	gcc -c my_header.c

std_header.o : std_header.c
	gcc -c std_header.c

clean :
	rm -f *.o *.out