#include <cstdio>
#include <cmath>
using namespace std;
int main(){
	int arr[31];
	arr[1]=1;
	for(int i=2;i<=30;i++){
		arr[i]=(arr[i-1]<<1)+1;
	}
	int TC,k;
	scanf("%d",&TC);
	while(TC--){
		scanf("%d",&k);
		printf("%d\n",arr[k]);
	}
}
