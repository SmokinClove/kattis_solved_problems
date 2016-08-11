#include <cstdio>
#include <cstring>
#include <algorithm>
#include <set>
#include <math.h>
#include <vector>
#include <queue>
using namespace std;
double A[1000][1000];
double C[2][1000];
int m;
class IntegerPair{
private:double first; int sec;
public:
    IntegerPair(double f, int s): first(f),sec(s){}
    double _first(){return first;}
    int _sec(){return sec;}
};
struct pair_compare {
    bool operator() (IntegerPair f, IntegerPair s) const{
        if(f._first() == s._first()) return f._sec() > s._sec();
        return f._first() > s._first();
    }
};
int main(){
    int TC;scanf("%i", &TC);
    while(TC -- > 0){
    	scanf("%i", &m); //printf("m = %i\n", m);
    	priority_queue<IntegerPair, vector<IntegerPair>, pair_compare> Set;
    	int num = 0;int included[m]; double mst=0.0000;
    	memset(A,0.0000000000,sizeof A); memset(C,0.0000000000,sizeof C);memset(included,0,sizeof included);
    	for(int i = 0; i < m; i++){
            double f,s;scanf("%lf %lf", &f, &s);
            C[0][i] = f; C[1][i] = s;
    	}
    	for(int i = 0; i < m; i++){
    		for(int j = i+1; j < m; j++){
                A[i][j] =A[j][i] =sqrt((C[0][i]-C[0][j])*(C[0][i]-C[0][j])+(C[1][i]-C[1][j])*(C[1][i]-C[1][j]));
    		}
    	}
    	Set.push(IntegerPair(0,0));//start the MST from vertex 0
    	//printf("size %d\n", Set.size());
    	while((!Set.empty())&&(num<m)){
    		IntegerPair head = Set.top();
    		double dist = head._first();int vertex = head._sec();
    	//	printf("vertex %d length %lf\n", vertex,dist);
    		Set.pop();
    		if(!included[vertex]){
    			mst+=dist;num++;//printf("mst = %f\n", mst);
                included[vertex] = 1;
                for(int i= 0; i < m; i++){
                    if(i != vertex) Set.push(IntegerPair(A[vertex][i],i));
                }
    		}
    	}
    	printf("%.15g\n", mst);
    }
}
