#include <vector>
#include <bits/stdc++.h>
using namespace std;

typedef vector<int> VI;
typedef vector<VI> VVI;
int N,M;
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
scanf("%d%d",&N,&M);
VVI w;
for(int i =0; i< N;i++){
     VI row = VI(N, 0);
     w.push_back(row);
}
for(int i=0;i<M;i++){
int f,s;
scanf("%d%d",&f,&s);
w[f-1][s-1]=w[s-1][f-1]=1;
}
VI mr = VI(N, -1),mc = VI(N, -1);
if(BipartiteMatching(w, mr, mc)<N){
	printf("Impossible\n");
}
else {
	for(int i =0; i < N;i++){
		printf("%d\n",mr[i]+1);
	}
}
}
