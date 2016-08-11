#include <bits/stdc++.h>
using namespace std;
int main(){
char A[300];
scanf("%s",A);
string a=A;
int len = a.length();
int ans=0;
for(int i=0;i<len;i++){
   if(((i%3)==0&&A[i]!='P')||((i%3)==1&&A[i]!='E')||((i%3)==2&&A[i]!='R'))ans++;
}
printf("%d\n",ans);
}
