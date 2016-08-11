#include <cstdio>
#include <cstring>
#include <algorithm>
#include <vector>
using namespace std;
int N,M,Q;
const int INF = 1000000000;
int T[150][150];
void Query(int s, int t){
	int res =T[s][t];
	for(int i=0;i<N;i++){
    if(T[s][i]!=INF&&T[i][t]!=INF&&T[i][i]<0){
        res=-INF;
        break;
	}
	}
	 if(res == -INF){
	      printf("-Infinity\n");
	 } else if (res == INF){
	       printf("Impossible\n");
	 } else {
	       printf("%d\n",res);
	 }
}
void FloydWarshall(){
    for(int k = 0; k < N; k++)
         for(int i = 0; i < N; i++)
             for(int j = 0; j < N; j++)
            	 if(T[i][k] != INF && T[k][j] != INF)T[i][j] = min(T[i][j], T[i][k] + T[k][j]);
}
int main() {
    	scanf("%d%d%d",&N,&M,&Q);
            while (N > 0){
              memset(T,0,sizeof T);
              for(int i = 0; i < 150; i++)
                  for(int j = 0; j < 150; j++)
                      if(i != j) T[i][j] = INF;
             while(M -- > 0){
            	 int f,s,w;
            	 scanf("%d%d%d",&f,&s,&w);
            	 T[f][s]=min(T[f][s],w);
             }
              FloydWarshall();
              while(Q -- > 0){
            	  int source,dest;
            	  scanf("%d%d",&source,&dest);
                  Query(source, dest);

              }
              printf("\n");
              scanf("%d%d%d",&N,&M,&Q);
            }
}
