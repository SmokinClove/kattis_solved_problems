#include <bits/stdc++.h>
using namespace std;
int N;
int gcd(int a, int b){
	if(b==1)return 1;
	if(b==0)return a;
	return gcd(b,a%b);
}
class Compare
{
public:
    bool operator() (pair<double, double> p1, pair<double, double> p2)
    {
        return (double)(p1.second/p1.first) > (double)(p2.second/p2.first);
    }
};

int main(){
scanf("%d",&N);
priority_queue< pair<double, double> , vector< pair<double, double> >, Compare> pq;
int count = 0,sum=2;
int limit = N<=4?N:ceil(N/4);
while(count<=limit){
for(int i=1;i<=sum/2;i++){
	if(gcd(i,sum-i)==1){
		pq.push(make_pair(i,sum-i));count++;
		if(i!=(sum-i)){pq.push(make_pair(sum-i,i));count++;}
	}
}
sum++;
}
//start from the top,
int num = 1;
int x=20000000,y=40000000,dx=0,dy=0;
while(num<=N && !pq.empty()){
	//printf("dx %d dy %d\n", dx,dy);
	 x+=dx, y-=dy;
printf("%d %d\n",x,y);num++;
if(num<=N){//reflect about the middle vertical
	int dist = y-20000000;
	printf("%d %d\n",(int)x,(int)20000000-dist);
	num++;
}
if(dx>0&&num<=N){
	int dist_x = abs(x-20000000);
	printf("%d %d\n",(int)(20000000-dist_x),(int)y);num++;
	if(num<=N){
		int dist_y = abs(y-20000000);
		printf("%d %d\n",(int)(20000000-dist_x),(int)(20000000-dist_y));num++;
	}
}
/*
if(num<=N){printf("%d %d\n",w,z);num++;}
if(num<=N){//reflect about the middle horizontal
	int dist = w-20000000;
	printf("%d %d\n",20000000-dist,z);
	num++;
}*/
pair<double, double> p=pq.top();
pq.pop();
dx=p.first,dy=p.second;
}
}
