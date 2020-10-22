
void funcao_f(float a[200], float b[200], int n, int i, int c1, double c2){

}

int main() {
    float a[200];
    float b[200];
    int n = 100;

    int i;
    int c1 = 340002;
    double c2 = 34.223;

    for(int j = 1; j < n; j *= 2){
        for (i = 0; i < n; i++) {
            a[i] = c1 * a[i + 17] + c2 * b[i] - n;
            c2 = a[i + 2] * 3.45;
            funcao_f(a, b, n, i, c1, c2);
            if(a[(int) i/2] == 4) main();
        }
    }

    return 0;
}
