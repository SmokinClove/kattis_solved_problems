//usual bipartite max matching, but hash the names to index number?#include <vector>
#include <bits/stdc++.h>
#include <unordered_map>
#include<string>
using namespace std;

typedef vector<int> VI;
typedef vector<VI> VVI;
int N,M;
bool FindMatch(int i, const VVI &w, VI &mr, VI &mc, VI &seen) {
  for (unsigned j = 0; j < w[i].size(); j++) {
    if (w[i][j] && !seen[j]) {
      seen[j] = true;
      if (mc[j] < 0 || FindMatch(mc[j], w, mr, mc, seen)) {
        mr[i] = j;
        mc[j] = i;
        return true;
      }
    }
  }
  return false;
}

int BipartiteMatching(const VVI &w, VI &mr, VI &mc) {
  int ct = 0;
  for (unsigned i = 0; i < w.size(); i++) {
    VI seen(w[0].size());
    if (FindMatch(i, w, mr, mc, seen)) ct++;
  }
  return ct;
}

int main(){
scanf("%d%d",&N,&M);//N=numof boys, M=num of girls
unordered_map<string,int> books;
VVI w;
for(int i =0; i< N;i++){
     VI row = VI(M, 0);
     w.push_back(row);
     char boy_name[20];
     int no_books;
     scanf("%s %d",boy_name,&no_books);
     for(int j=0;j<no_books;j++){
    	 char book[20];
    	 scanf("%20s",book);
    	 string book_name = book;
    	 books[book_name]=i;
     }
}
for(int i=0;i<M;i++){
	char girl_name[20];
	     int no_books;
	     scanf("%s %d",girl_name,&no_books);
	     for(int j=0;j<no_books;j++){
	        	 char book[20];
	        	 scanf("%s",book);
	        	 string book_name = book;
	        	 int boy_indx=books[book_name];
	        	 w[boy_indx][i]=1;//w[boy_indx][i]=1;
	         }
}
VI mr = VI(N, -1),mc = VI(M, -1);
printf("%d\n",BipartiteMatching(w, mr, mc));
}

