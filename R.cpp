//fibonacci
#include <bits/stdc++.h>
using namespace std;
int main(){
	int f[46];
	f[0]=0;f[1]=f[2]=1;
	for(int i=3;i<=45;i++)
		f[i]=f[i-1]+f[i-2];
	int j;
	scanf("%d",&j);
	printf("%d %d\n",f[j-1],f[j]);
}
