#include <cstdlib>
#include <cstdio>
#include <cstring>
#include <math.h>
#include <algorithm>
using namespace std;

int N, P;

int main(){
	scanf("%d", &N);
	scanf("%d", &P);
	//printf("N = %d  P = %d\n", N, P);
	int A[N];
	int temp;
	for(int i = 0; i < N; i++){
		scanf("%d", &temp);
		A[i] = temp - P;
	//	printf("i = %d %d\n", i, A[i]);
	}

//Kadane routine
	int ans = 0, sum = 0;
	for(int i = 0; i < N; i++){
        sum += A[i];
        if(sum < 0) sum = 0;
        ans = max(ans, sum);
	}

	printf("%d\n", ans);
}
