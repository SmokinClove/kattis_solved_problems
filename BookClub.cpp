// This code performs maximum bipartite matching.
//
// Running time: O(|E| |V|) -- often much faster in practice
//
//   INPUT: w[i][j] = edge between row node i and column node j
//   OUTPUT: mr[i] = assignment for row node i, -1 if unassigned
//           mc[j] = assignment for column node j, -1 if unassigned
//           function returns number of matches made

#include <vector>
#include <bits/stdc++.h>
using namespace std;

typedef vector<int> VI;
typedef vector<VI> VVI;
int N,M;
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
scanf("%d%d",&N,&M);
for(int i =0; i< N;i++){
	 VI row = VI(N, 0);
	 w.push_back(row);
}
for(int i=0;i<M;i++){
int f,s;
scanf("%d%d",&f,&s);
w[f][s]=1;
}
VI mr = VI(N, -1),mc = VI(N, -1);
if(BipartiteMatching(w, mr, mc)==N)printf("YES\n");
else printf("NO\n");
}
