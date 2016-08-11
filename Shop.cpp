#include <bits/stdc++.h>
using namespace std;
int main(){
int n;
scanf("%d",&n);
long long A[n],sum=0;
for(int i=0;i<n;i++){
	long long k;
	scanf("%lld",&k);sum+=k;
	A[i]=k*(-1);
}
sort(A,A+n);
long long ans=0;
for(int i=2;i<n;i+=3){
	ans += A[i]*(-1);
}
printf("%lld\n",sum-ans);
}
