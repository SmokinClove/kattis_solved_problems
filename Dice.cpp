#include <cstdio>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

typedef vector<int> vi;
#define LSOne(S) (S & (-S))
int G1,G2,G3,G4,E1,E2,E3,E4;
class FenwickTree {
private:
  vi ft;

public:
  FenwickTree() {}
  // initialization: n + 1 zeroes, ignore index 0
  FenwickTree(int n) { ft.assign(n + 1, 0); }

  int rsq(int b) {                                     // returns RSQ(1, b)
    int sum = 0; for (; b; b -= LSOne(b)) sum += ft[b];
    return sum; }

  int rsq(int a, int b) {                              // returns RSQ(a, b)
    return rsq(b) - (a == 1 ? 0 : rsq(a - 1)); }

  // adjusts value of the k-th element by v (v can be +ve/inc or -ve/dec)
  void adjust(int k, int v) {                    // note: n = ft.size() - 1
    for (; k < (int)ft.size(); k += LSOne(k)) ft[k] += v; }
};

int main() {              // idx   0 1 2 3 4 5 6 7  8 9 10, no index 0!
  scanf("%d%d%d%d",&G1,&G2,&G3,&G4);
  scanf("%d%d%d%d",&E1,&E2,&E3,&E4);
  FenwickTree _G1(202);
  FenwickTree _E1(202);
  int g_wins=0,e_wins=0;
  int g_S1=G2-G1+1,g_S2=G4-G3+1,e_S1=E2-E1+1,e_S2=E4-E3+1;
  int G[200],E[200];
  memset(G,0,sizeof G);
  memset(E,0,sizeof E);
  for(int i=G1;i<=G2;i++){
	  for(int j=G3;j<=G4;j++){
          _G1.adjust(i+j,1);
          G[i+j]++;
	  }
  }
  for(int i=E1;i<=E2;i++){
  	  for(int j=E3;j<=E4;j++){
            _E1.adjust(i+j,1);
            E[i+j]++;
  	  }
    }
  for(int i=1;i<=201;i++){
    if(G[i]>0)g_wins += _E1.rsq(i-1) * (_G1.rsq(i)-_G1.rsq(i-1));
  }
  for(int i=1;i<=201;i++){
     if(E[i]>0)e_wins += _G1.rsq(i-1)* (_E1.rsq(i)-_E1.rsq(i-1));
   }
 // printf("G %d E %d\n", g_wins, e_wins);
  if(g_wins < e_wins)printf("Emma\n");
  if(g_wins > e_wins)printf("Gunnar\n");
  if(g_wins == e_wins)printf("Tie\n");
}
