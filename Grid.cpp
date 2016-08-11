#include <cstdio>
#include <cstring>
#include <algorithm>
#include <math.h>
#include <vector>
#include <queue>
using namespace std;
int maxR = -1, maxC = -1;
int p[100000];
class IntegerPair{
private:int first; int sec;
public:
    IntegerPair(): first(-1), sec(-1){}
    IntegerPair(int f, int s): first(f),sec(s){}
    int _first(){return first;}
    int _sec(){return sec;}
};
class IntegerTriple{
private:int first; int sec; int third;
public:
    IntegerTriple(): first(-1), sec(-1), third(-1){}
    IntegerTriple(int f, int s, int t): first(f),sec(s),third(t){}
    int _first(){return first;}
    int _sec(){return sec;}
    int _third(){return third;}
};
struct pair_compare {
    bool operator() (IntegerPair f, IntegerPair s) const{
        if(f._first() == s._first()) return f._sec() > s._sec();
        return f._first() > s._first();
    }
};
struct triple_compare {
    bool operator() (IntegerTriple f, IntegerTriple s) const{
    	if(f._first() != s._first()) return f._first() > s._first();
        if(f._sec() != s._sec()) return f._sec() > s._sec();
        return f._third() > s._third();
    }
};
IntegerPair A[1000][1000];
int inRange(int r, int c){
    return 0<=r && r<=maxR && 0<=c && c<=maxC;
}
int occupied(int r, int c){
	return A[r][c]._first() != -1;
}
int par(int i){
	if(p[i] == i) return i;
	p[i] = par(p[i]);
	return p[i];
}
void merge(int i, int j){
	if(par(i) < par(j)) {
		p[par(j)] = par(i);
	} else if(par(j) < par(i)) {
		p[par(i)] = p[j];
	}
}

int sameSet(int i, int j){
	return par(i) == par(j);
}
int main(){
	priority_queue<IntegerTriple, vector<IntegerTriple>, triple_compare> Set;
	priority_queue<IntegerTriple, vector<IntegerTriple>, triple_compare> pq;
	int neighbors[4][4]={{-1,0,1,0},{0,1,0,-1}};
	int N = 0, size = 0;scanf("%d\n", &N);
	for(int i = 0; i < N; i++){
		p[i] = i;
		int f, s; scanf("%d%d", &f, &s); maxR = max(maxR, f), maxC = max(maxC, s);
		if(A[f][s]._first()==-1){//to avoid repeated points
			size++;
			Set.push(IntegerTriple(0,f,s));
			A[f][s] = IntegerPair(i, 0);
		}
	}
     while(!Set.empty()){
          IntegerTriple head = Set.top();
          Set.pop(); int row = head._sec(), col = head._third(), dist = head._first();
          for(int j= 0; j < 4; j++){
               int nR = row+neighbors[0][j], nC = col+neighbors[1][j];
               if(inRange(nR,nC)){
            	    if(!occupied(nR,nC)){
                         A[nR][nC] = IntegerPair(A[row][col]._first(), dist + 1);
                         Set.push(IntegerTriple(dist + 1,nR,nC));
            	    } else {//if occupied, either belongs to same point or diff
            		     if(A[nR][nC]._first()!=A[row][col]._first()){//diff point
            		    	// printf("i %d dist %d nei \n", f,s,dist);
            		         pq.push(IntegerTriple(dist + 1 + A[nR][nC]._sec(),
            		              A[nR][nC]._first(), A[row][col]._first()));
            		     }
            		}//if same point, do nothing
            	}
           }
     }

	int mst = 0, num = size;
     while(!pq.empty()&&num>1){
    	 IntegerTriple head = pq.top();
    	 pq.pop(); int f = head._sec(), s = head._third(), dist = head._first();
    	// printf("f %d s %d dist %d\n", f,s,dist);
    	 if(!sameSet(f, s)){
    		 merge(f,s);
    		 mst+=dist;num--;
    	 }
     }
	printf("%d\n", mst);
}
