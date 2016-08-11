#include <cstdio>
#include <cstring>
#include <algorithm>
#include <vector>
#include <queue>
#include <math.h>
#include <limits.h>
using namespace std;
int V,M,q,s,t;
const long long INF = 2000000000000;
long long d[1000],inf[1000];
class IntegerTriple{
private:int first; int sec; long long third;
public:
    IntegerTriple(): first(-1), sec(-1), third(-1){}
    IntegerTriple(int f, int s, long long t): first(f),sec(s),third(t){}
    int _first(){return first;}
    int _sec(){return sec;}
    long long _third(){return third;}
};
vector<IntegerTriple> E;
void BellmanFord(int source){
	d[source] = 0;
	for(int round = 1; round <= V -1;  round++){
		for(unsigned i = 0;i<E.size();i++){
			IntegerTriple p = E[i];
		    int u = p._first(), v = p._sec(); long long dist=p._third();
		    if(d[u]!=INF&&d[u]+dist<d[v]){
		    	d[v] = d[u]+dist;
		    }
		}
	}
	bool c = true;
	while(c){c = false;
	for(unsigned i = 0;i<E.size();i++){
		IntegerTriple p = E[i];
	    int u = p._first(), v = p._sec(); long long dist=p._third();
	    if(d[u]!=INF&&d[u]+dist<d[v]&&!inf[v]){
	    	c = true;
	    	d[v] = -INF;
	    	inf[v]=1;
		}
    }
	}
}
int main(){
    scanf("%d%d%d%d",&V,&M,&q,&s);
    while(V>0){
        E.clear();
    	for(int i = 0; i < 1000; i++){
    		d[i] = INF;
    	}
    	memset(inf,0,sizeof inf);
        while(M -- > 0){
             int x,y;long long z; scanf("%d %d %lld",&x,&y,&z);
             E.push_back(IntegerTriple(x,y,z));
        }
        BellmanFord(s);
        while(q -- > 0){
        	scanf("%d",&t);
        	if(inf[t]){
           		printf("-Infinity\n");
        	} else if(d[t]==INF) {
        		printf("Impossible\n");
        	} else {
        		printf("%lld\n",d[t]);
        	}
        }
        printf("\n");
        scanf("%d%d%d%d",&V,&M,&q,&s);
    }
}
