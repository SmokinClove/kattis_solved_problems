#include <bits/stdc++.h>
using namespace std;

typedef vector<int> vi;
typedef long long ll;
#define LSOne(S) (S & (-S))
int visited[300003];
int S[300003],E[300003];
int  N=0,Q, start = 1;
vector< vi > AdjList;
class FenwickTree {
public:
  vector<ll> ft;

public:
  FenwickTree(int n) { ft.assign(n + 1, 0); }

  ll rsq(int b) {
    ll sum = 0; for (; b; b -= LSOne(b)) sum ^= ft[b];
    return sum; }

 ll rsq(int a, int b) {
    return rsq(b) ^ rsq(a - 1); }

  // modified BIT: toggle the vth bit/the vth color in vertex k
  void adjust(int k, int v) {                    // note: n = ft.size() - 1
    for (; k < (int)ft.size(); k += LSOne(k)) ft[k] ^= (1ll << v);}
};

void dfs(int i){//O(N-1)
   S[i]=start;
   visited[i]=1;
   for(int j=0;j<(int)AdjList[i].size();j++){
	   if(!visited[AdjList[i][j]]){
		   start++;
		   dfs(AdjList[i][j]);
	   }
   }
   E[i]=start;
}

int main() {
scanf("%d%d",&N,&Q);
FenwickTree F1(N),F2(N);
AdjList.clear();
int color[N+1];
memset(visited,0,sizeof visited);
for(int i=0;i<N;i++){
	scanf("%d",color+i+1);
}
for(int i=0;i<=N;i++){vi row;
	AdjList.push_back(row);
}
for(int i=0;i<N-1;i++){
	int p;
	scanf("%d",&p);
	AdjList[p].push_back(i+2);
}
dfs(1);
for(int i=1;i<=N;i++){
	 if(color[i]<=50){F1.adjust(S[i],color[i]);}
	 else {F2.adjust(S[i],color[i]-50);}
}
while(Q--){
	int q, num;
	scanf("%d%d",&q,&num);
	if(q){
	     if(color[num]<=50){F1.adjust(S[num],color[num]);}
		 else {F2.adjust(S[num],color[num]-50);}
	     if(q<=50){F1.adjust(S[num],q);}
	     else {F2.adjust(S[num],q-50);}
         color[num]=q;
	}else{
        if(S[num]==E[num]){printf("1\n");}
        else{
            printf("%d\n",__builtin_popcountll(F1.rsq(S[num],E[num])) + __builtin_popcountll(F2.rsq(S[num],E[num])));
        }
	}
}
}
