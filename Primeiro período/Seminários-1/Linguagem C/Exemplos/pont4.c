#include<stdio.h>
#include <stdlib.h>

int main() {
	int y, *p, x;

	y = 0;
	p = &y;
	x = *p;
	x = 4;
	(*p)++;
	x--;
	(*p) += x;
	printf ("Apontado por p = %d\n", *p);
	printf ("y = %d\n", y);
	printf ("x = %d\n", x);
	return 0;
}
