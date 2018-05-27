#include<stdio.h>

int main(){
	float a, b;
	float res;

	scanf("%f", &a);
	scanf("%f", &b);

	res = a*b;

	printf("\n%f * %f = %f\n", a, b, res);
	return(0);
}
