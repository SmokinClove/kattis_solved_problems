#include <algorithm>
#include <cstdio>
#include <stack>
using namespace std;

#define MAX_N 100000

void print_array(const char *s, int a[], int n) {
  for (int i = 0; i < n; ++i) {
    if (i) printf(", ");
    else printf("%s: [", s);
    printf("%d", a[i]);
  }
  printf("]\n");
}

void reconstruct_print(int end, int a[], int p[]) {
  int x = end;
  stack<int> s;
  for (; p[x] >= 0; x = p[x]) s.push(x);
  printf("%d\n",s.size()+1);
  printf("%d", x);
  for (; !s.empty(); s.pop()) printf(" %d", s.top());
  printf("\n");
}

int main() {
  int n;
  while(scanf("%d",&n)>0){
  int L[n], L_id[n], P[n],A[n];
for(int i=0;i<n;i++)
	scanf("%d",A+i);
  int lis = 0, lis_end = 0;
  for (int i = 0; i < n; ++i) {
    int pos = lower_bound(L, L + lis, A[i]) - L;
    L[pos] = A[i];
    L_id[pos] = i;
    P[i] = pos ? L_id[pos - 1] : -1;
    if (pos + 1 > lis) {
      lis = pos + 1;
      lis_end = i;
    }

  }

  reconstruct_print(lis_end, A, P);
  }
}
