#include <bits/stdc++.h>
using namespace std;

#define EPS 1e-9
#define PI acos(-1.0)
int n;
int memo[15],arr[15],visited[15];

double DEG_to_RAD(double d) { return d * PI / 180.0; }

double RAD_to_DEG(double r) { return r * 180.0 / PI; }

struct point { double x, y;   // only used if more precision is needed
  point() { x = y = 0.0; }                      // default constructor
  point(double _x, double _y) : x(_x), y(_y) {}        // user-defined
  bool operator == (point other) const {
   return (fabs(x - other.x) < EPS && (fabs(y - other.y) < EPS)); } };
double dist(point p1, point p2) {                // Euclidean distance
  return hypot(p1.x - p2.x, p1.y - p2.y); }
point p[15];
int dp(int i){//actually dfs style
     visited[i]=1;
     int ans =arr[i]*arr[i];
     for(int j=0;j<n;j++){
    	 if(!visited[j]&&(double)(arr[i]+arr[j])-dist(p[i],p[j])<0){
    		 bool can=true;
    		 for(int k=0;k<n;k++){
    			 if((visited[k]&&(double)(arr[k]+arr[j])-dist(p[k],p[j])>=0))can =false;
    		 }
    		 if(can)ans=max(ans,arr[i]*arr[i]+dp(j));
    	 }
     }
     visited[i]=0;
     return ans;
}
int main(){
	int TC;
	scanf("%d",&TC);
	while(TC--){
		scanf("%d",&n);
		int x,y,d;
		for(int i=0;i<n;i++){
		    scanf("%d%d%d",&x,&y,&d);
		    p[i]=point(x,y);arr[i]=d;
		}
		memset(visited,0, sizeof visited);
		int ans = dp(0);
		for(int i=1;i<n;i++){
			memset(visited,0, sizeof visited);
			ans = max(ans,dp(i));
			//printf("i %d ans %d\n",i,ans);
		}

        printf("%d\n",ans);
	}
}
