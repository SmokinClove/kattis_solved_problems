#include <cstdio>
#include <string>
#include <algorithm>
#include <math.h>
#include <vector>
#include <queue>
using namespace std;
int R = 9,C = 9, initR=0,initC=0;
int A[9][9];
int moves[2][8]={{-2,-2,-1,1,-1,1,2,2},{-1,1,-2,-2,2,2,-1,1}};
char chars[8] = {'a','b','c','d','e','f','g','h'};
int inRange(int r, int c){return (1<= r&&r<R)&&(0<=c&&c<C-1);}
class IntegerTriple{
private:int first; int sec; int third;
public:
    IntegerTriple(): first(-1), sec(-1), third(-1){}
    IntegerTriple(int f, int s, int t): first(f),sec(s),third(t){}
    int _first(){return first;}
    int _sec(){return sec;}
    int _third(){return third;}
};
struct triple_compare {
    bool operator() (IntegerTriple f, IntegerTriple s) const{
    	if(f._third() != s._third()) return f._third() > s._third();;
        if(f._sec() != s._sec()) return f._sec() > s._sec();
        return f._first() > s._first();
    }
};
int main(){int TC; scanf("%d",&TC);
    while(TC -- > 0){
        char input[3];
        scanf("%s",input);
        char init_col=input[0];
        for(int i = 0; i < R; i++)
        	for (int j = 0; j < C;j++)
        		A[i][j]=-1;
        for(int i = 0; i < 8;i++){
	        if(chars[i]==init_col) {
	        	initC=i;break;
	        }
        }
         initR = input[1]-'0';
        priority_queue<IntegerTriple, vector<IntegerTriple>, triple_compare> pq;
        pq.push(IntegerTriple(initR,initC,0)); A[initR][initC]=0;
        while(!pq.empty()){
	    IntegerTriple p = pq.top();pq.pop(); int row = p._first(), col = p._sec(),count=p._third();
        for(int i = 0; i < 8; i++){
           int nR=row+moves[0][i],nC=col+moves[1][i];
           if(inRange(nR,nC)){
               if(A[nR][nC]==-1) {
        	       A[nR][nC]=count+1;
        	       pq.push(IntegerTriple(nR,nC,count+1));
               } else if(count+1 < A[nR][nC]){
        	       A[nR][nC]=count+1 ; pq.push(IntegerTriple(nR,nC,A[nR][nC]));
               }
           }
        }
      }
   //traverse to get the max
   int max = -1;
   for(int i = 8; i >= 0; i--){
	   for(int j = 0; j < 8; j++){
	       if(A[i][j] > max) max = A[i][j];
	   }
   }
   printf("%d ", max);
   for(int i = 8; i >= 0 ; i--){
   	   for(int j = 0; j < 8; j++){
   	       if(A[i][j] == max) printf("%c%d ", chars[j],i);
       }
   }
   printf("\n");
}
}
