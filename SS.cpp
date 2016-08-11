//Dijkstra since no neg weight
#include <cstdio>
#include <cstring>
#include <algorithm>
#include <vector>
#include <queue>
#include <math.h>
#include <limits.h>
using namespace std;
int V,M,q,s,t;
long long d[10000];
const long long INF = 2000000000000;
class IntegerPair{
private:int first; int sec;
public:
    IntegerPair(): first(-1), sec(-1){}
    IntegerPair(int f, long long s): first(f),sec(s){}
    int _first(){return first;}
    long long _sec(){return sec;}
};
vector< vector <IntegerPair> >A;
struct pair_compare {
    bool operator() (IntegerPair f, IntegerPair s) const{
        if(f._sec() == s._sec()) return f._first() > s._first();
        return f._sec() > s._sec();
    }
};
priority_queue<IntegerPair, vector<IntegerPair>, pair_compare> pq;
void dijkstra(){
   pq.push(IntegerPair(s,0));d[s]=0;int num =0;int v[V]; memset(v,0,sizeof v);
   while(!pq.empty()){
       IntegerPair p = pq.top();pq.pop();
       int vertex = p._first();
       if(!v[vertex]){
    	   num++;v[vertex]=1;
    	   for(unsigned i = 0; i < A[vertex].size(); i++){
    		   IntegerPair cur = A[vertex][i]; int neighbor = cur._first();long long weight = cur._sec();
    		   if(d[vertex]+weight<d[neighbor]){
    			   d[neighbor] = d[vertex]+weight;
    			   pq.push(IntegerPair(neighbor,d[vertex]+weight));
    		   }
    	   }
       }
   }
}
int main(){
	scanf("%d%d%d%d",&V,&M,&q,&s);
	while(V>0){
		A.clear();
		for(int i = 0; i < V;i++){
		    vector<IntegerPair> row; A.push_back(row);
			d[i]=INF;
		}
		for(int i = 0; i < M; i++){
			int x,y;long long z; scanf("%d %d %lld", &x,&y,&z);
			A[x].push_back(IntegerPair(y,z));
		}
		dijkstra();
		while(q -- > 0){scanf("%d", &t);
           if(d[t]==INF) printf("Impossible\n");
           else printf("%lld\n", d[t]);
		}
		scanf("%d%d%d%d",&V,&M,&q,&s);
	}
}
