#include <vector>
#include <bits/stdc++.h>
#include <algorithm>
using namespace std;

typedef vector<int> VI;
typedef vector<VI> VVI;
int N,M;
double s,v;
VVI w=VVI(10000, VI(10000));
bool FindMatch(int i, const VVI &w, VI &mr, VI &mc, VI &seen) {
  for (int j = 0; j < w[i].size(); j++) {
    if (w[i][j] && !seen[j]) {
      seen[j] = true;
      if (mc[j] < 0 || FindMatch(mc[j], w, mr, mc, seen)) {
        mr[i] = j;
        mc[j] = i;
        return true;
      }
    }
  }
  return false;
}

int BipartiteMatching(const VVI &w, VI &mr, VI &mc) {
  int ct = 0;
  for (int i = 0; i < w.size(); i++) {
    VI seen(w[0].size());
    if (FindMatch(i, w, mr, mc, seen)) ct++;
  }
  return ct;
}
int main(){
while(scanf("%d%d%lf%lf",&N,&M,&s,&v)==4){
	w.clear();
	double G[N][2], H[M][2];
for(int i =0; i< N;i++){
     VI row = VI(M, 0);
     w.push_back(row);
     double x,y;
     scanf("%lf%lf",&x,&y);
     G[i][0]=x;G[i][1]=y;
}
for(int i=0;i<M;i++){
	double x,y;
	     scanf("%lf%lf",&x,&y);
	     H[i][0]=x;H[i][1]=y;
}
double dist = s*v;

for(int i=0;i<N;i++){
	for(int j=0;j<M;j++){
		double curDist = sqrt((G[i][0]-H[j][0])*(G[i][0]-H[j][0])+(G[i][1]-H[j][1])*(G[i][1]-H[j][1]));
		//printf("%f%f%f%f\n",s,v,dist,curDist);
        if(curDist <= dist){
        	w[i][j]=1;
        //	printf("%d %d %f %f\n", i, j, sqrt((G[i][0]-H[j][0])*(G[i][0]-H[j][0])+(G[i][1]-H[j][1])*(G[i][1]-H[j][1])), dist);
        }
	}
}
VI mr = VI(N, -1),mc = VI(M, -1);
printf("%d\n",N-BipartiteMatching(w, mr, mc));
}
}
