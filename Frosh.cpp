#include <bits/stdc++.h>
using namespace std;
long long ans;
long long A[1000010];
void merge(int i, int mid, int j){
	int temp[j-i+1];int len=j-i+1;
	int left =i, right = mid+1, it=0;
	while(left<=mid&&right<=j){
		if(A[left]<A[right]){
			temp[it++]=A[left++];
		}else{
			ans+= mid-left+1;
			temp[it++]=A[right++];
		}
	}
	while(left<=mid)temp[it++]=A[left++];
	while(right<=j)temp[it++]=A[right++];
	for(int k=0;k<len;k++)
		A[i+k]=temp[k];
}
void mergesort(int i,int j){
if(i<j){
	int mid=(i+j)/2;
	mergesort(i,mid);
	mergesort(mid+1,j);
	merge(i,mid,j);
}
}
int main(){
int N;
scanf("%d",&N);
for(int i=0;i<N;i++)
	scanf("%lld",A+i);
ans=0;
mergesort(0,N-1);
printf("%lld\n",ans);
}
