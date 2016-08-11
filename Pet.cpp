#include <bits/stdc++.h>
using namespace std;
int main(){
int a[5];memset(a,0,sizeof a);
for(int i=0;i<5;i++){
	for(int j=0;j<4;j++){
		int k;
		scanf("%d",&k);
		a[i]+=k;
	}
}
int ans=0,indx=0;
for(int i=0;i<5;i++){
	if(a[i]>ans){
		indx=i+1;ans=a[i];
	}
}
printf("%d %d\n",indx,ans);
}
