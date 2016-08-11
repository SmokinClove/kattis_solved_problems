#include <cstdio>
#include <cstring>
#include <algorithm>
using namespace std;
int main(){
	int TC,N,sum,indx,max;
	scanf("%d",&TC);
	while(TC--){
		scanf("%d",&N);
		int arr[50010];
		memset(arr,0,sizeof arr);
		sum=0,max=0,indx=-1;
		for(int i=0;i<N;i++){
			int num;
			scanf("%d",&num);
			if(num>max){indx=i;max=num;}
			sum+=num;
			arr[num]++;
		}
		if(arr[max]>1)printf("no winner\n");
		else if(sum < (max<<1))printf("majority winner %d\n",(indx+1));
		else printf("minority winner %d\n",(indx+1));
	}
}
