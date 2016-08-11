//accepted!! XD
#include <cstdio>
#include <cstring>
#include <algorithm>
using namespace std;
int price[100];
int N,M,caseno=0;
int memo[100][300000],lastvisit[100][300000];;
int order(int index, int money_left){
	if(index==N||money_left<0)return 0;
	if(money_left==0)return 1;
	if(lastvisit[index][money_left]==caseno)return memo[index][money_left];
	lastvisit[index][money_left]=caseno;
	memo[index][money_left]=order(index+1,money_left);
	if(money_left-price[index]>=0&&memo[index][money_left]<=1)memo[index][money_left]+=order(index,money_left-price[index]);
    return memo[index][money_left];
}
void print(int indx, int m){
	if(m<=0||indx==N) return;
	if(order(indx+1,m)==1){
		print(indx+1,m);
	}else{
		if(order(indx,m-price[indx])==1){
			printf("%d ",(indx+1));
			print(indx,m-price[indx]);
		}
	}
}
int main(){
scanf("%d",&N);
memset(memo,-1,sizeof memo);
for(int i=0;i<N;i++){
	int p;
	scanf("%d",&p);
	price[i]=p;
}
scanf("%d",&M);
while(M -- > 0){
	caseno++;
	int S;
	scanf("%d",&S);
	order(0,S);
	if(memo[0][S]==0)printf("Impossible\n");
	if(memo[0][S]>1)printf("Ambiguous\n");
	if(memo[0][S]==1){
	print(0,S);
	printf("\n");
	}
}
}
