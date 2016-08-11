#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;
char input[41];
const char A[28]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','_','.'};
unordered_map<int, char> Set;
void reverseArr(int length){
//0->len-1
	for(int i=0;i<=(length-1)/2;i++){
		int temp=input[i];
		input[i]=input[length-1-i];
		input[length-1-i]=temp;
	}
}
int main(){
	for(int i=0;i<28;i++)
		Set[A[i]]=i;
	int N;
	scanf("%d",&N);
	while(N>0){
	scanf("%s",input);
	string in=input;
	int len=in.length();
	reverseArr(len);
	for(int i=0;i<len;i++){
		printf("%c",A[(Set[input[i]]+N)%28]);
	}
	printf("\n");
	scanf("%d",&N);
	}
}
