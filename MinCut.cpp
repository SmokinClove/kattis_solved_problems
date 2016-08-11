#include <algorithm>
#include <bitset>
#include <cstdio>
#include <vector>
#include <queue>
#include <stack>
using namespace std;
typedef vector<int> vi;
#define MAX_V 500
#define INF 1000000000
int res[MAX_V][MAX_V], s, t,V,E;                          // global variables
long long mf, f;
vi p;
vector<vi> AdjList;
void augment(int v, int minEdge) {     // traverse BFS spanning tree from s to t
  if (v == s) { f = minEdge; return; }  // record minEdge in a global variable f
  else if (p[v] != -1) { augment(p[v], min(minEdge, res[p[v]][v])); // recursive
                         res[p[v]][v] -= f; res[v][p[v]] += f; }       // update
}

int main() {
  int vertex, weight,neighbor;
  scanf("%d%d%d%d", &V,&E, &s, &t);
  for(int i=0;i<V;i++)
  	  for(int j=0;j<V;j++)
  		  res[i][j]=0;
  AdjList.assign(V, vi());
    for (int i = 0; i < E; i++) {
      scanf("%d%d%d", &vertex,&neighbor, &weight);
      res[vertex][neighbor] = weight;
      AdjList[vertex].push_back(neighbor);AdjList[neighbor].push_back(vertex);
    }
  mf = 0;
  while (1) {                     // now a true O(VE^2) Edmonds Karp's algorithm
    f = 0;
    bitset<MAX_V> vis; vis[s] = true;            // we change vi dist to bitset!
    queue<int> q; q.push(s);
    p.assign(MAX_V, -1);
    while (!q.empty()) {
      int u = q.front(); q.pop();
      if (u == t) break;
      for (int j = 0; j < (int)AdjList[u].size(); j++) {  // we use AdjList here!
        int v = AdjList[u][j];
        if (res[u][v] > 0 && !vis[v])
          vis[v] = true, q.push(v), p[v] = u;
      }
    }
    augment(t, INF);
    if (f == 0) break;
    mf += f;
  }
  stack<int> toPrint;
  bitset<MAX_V> vis; vis[s] = true;            // we change vi dist to bitset!
     queue<int> q; q.push(s);toPrint.push(s);
     while (!q.empty()) {
       int u = q.front(); q.pop();
       for (int j = 0; j < (int)AdjList[u].size(); j++) {  // we use AdjList here!
         int v = AdjList[u][j];
         if (res[u][v] > 0 && !vis[v]){//hmm buggy here, why?
           vis[v] = true, q.push(v), toPrint.push(v);
         }
       }
     }
printf("%d\n", toPrint.size());
while(!toPrint.empty()){
	printf("%d\n", toPrint.top());toPrint.pop();
}
  return 0;
}


