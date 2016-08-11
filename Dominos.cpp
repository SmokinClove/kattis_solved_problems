//wrong answer =(
#include <cstdio>
#include <cstring>
#include <algorithm>
#include <vector>
using namespace std;
long N,M,size;
int TC, UNVISITED = -1,VISITED=0;
vector<int> states;
vector< vector<long> > L;
vector<long> S;
void DFS(long v){
    states[v]=VISITED; vector<long> cur = L[v];
    for (vector<long>::iterator it = cur.begin() ; it != cur.end(); ++it){
     if(states[*it]==UNVISITED){DFS(*it);}
    }
    S.push_back(v);
}
void DFS2(long v){
    states[v]=VISITED; vector<long> cur = L[v];
    for (vector<long>::iterator it = cur.begin() ; it != cur.end(); ++it){
     if(states[*it]==UNVISITED){DFS2(*it);}
    }
}
int main(){
   scanf("%d", &TC);
   while(TC -- > 0){
	   L.clear();states.clear();size=0;
	   S.clear();
	   scanf("%ld%ld", &N, &M);
	   states.assign(N+1,UNVISITED);
	   for(long i = 0; i <= N;i++){
	   	   vector<long> row;
	   	   L.push_back(row);
	   }
       while(M -- > 0){
          long f,s;
          scanf("%ld%ld", &f, &s);
          L[f].push_back(s);
       }
	   for(long i = 1; i <= N; i++){//find the toposort
	  	   if(states[i]==UNVISITED){DFS(i);}
	     }
	   states.clear();states.assign(N+1,UNVISITED);
	  	   for (vector<long>::reverse_iterator i = S.rbegin(); i != S.rend(); ++i ){
	  		 if(states[*i]==UNVISITED){size++;DFS2(*i);}
	  	   }

       printf("%ld\n", size);
   }
}
