#include <bits/stdc++.h>
using namespace std;
int main(){
	int n;
	scanf("%d",&n);
	int arr[n];
	for(int i=0;i<n;i++){
		int j;
		scanf("%d",&j);
		arr[i]=j*(-1);
	}
	sort(arr,arr+n);
	int ans=0;
	for(int i=0;i<n;i++)
		ans=max(ans,i+1+(arr[i])*(-1));
printf("%d\n",ans+1);
}
