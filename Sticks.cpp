#include <cstdio>
#include <cstring>
#include <algorithm>
#include <vector>
#include <stack>
using namespace std;
long V,E;
vector< vector<long> > L;
vector<int> states;
int UNVISITED = -1,VISITED=1,COMPLETED=2;
vector<long> S;
bool cycle = false;
void DFS(long v){
    states[v]=VISITED; vector<long> cur = L[v];
    for (vector<long>::iterator it = cur.begin() ; it != cur.end(); ++it){
     if(states[*it]==VISITED){cycle = true;return;}
     if(states[*it]==UNVISITED){DFS(*it);}
    }
    states[v]=COMPLETED;
    S.push_back(v);
}
int main(){
   scanf("%ld %ld",&V,&E);S.clear();L.clear();
   states.assign(V+1,UNVISITED);
   for(long i = 0; i <= V;i++){
	   vector<long> row;
	   L.push_back(row);
   }
   while(E -- > 0){
       long f,s;
       scanf("%ld %ld", &f,&s);
       L[f].push_back(s);
   }
   for(long i = 1; i <= V; i++){
	   if(cycle) {printf("IMPOSSIBLE\n");break;}
	   if(states[i]==UNVISITED){DFS(i);}
   }
   if(!cycle){
	   for (vector<long>::reverse_iterator i = S.rbegin(); i != S.rend(); ++i )
	       printf("%ld\n", *i);
   }
}
