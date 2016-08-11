#include <bits/stdc++.h>
using namespace std;

int main(){
int TC;
scanf("%d",&TC);
while(TC-->0){
	int n;
	scanf("%d",&n);
	string A[n];
	for(int i=0;i<n;i++){
		char temp[13];
		scanf("%s",temp);
		string t=temp;
		A[i]=t;
	}
	sort(A,A+n);
bool ans=true;
	for(int i=1;i<n;i++){
		char one[1024];
		strcpy(one, A[i-1].c_str());
		char two[1024];
		strcpy(two, A[i].c_str());
		if(strncmp(one,two,A[i-1].length())==0){
			ans=false;
			break;
		}
	}
	if(ans)printf("YES\n");
	else printf("NO\n");
}
}
