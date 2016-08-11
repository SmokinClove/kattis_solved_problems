#include <bits/stdc++.h>
using namespace std;
int arr[30];
int num=0,sum,lastNum;
char c;
int main(){
	char str[1000000];
	while(scanf(" %[^\n]",str)>0){
		num=0;int no=0;sum=0;
		char * pch;
		pch = strtok(str," ");
		while (pch != NULL){
			no = atoi(pch);
			arr[num++]=no;
			pch = strtok (NULL, " ");
			sum+=no;
		}

       for(int i=0;i<num;i++){
    	   if(sum==(arr[i]<<1)){
    		   printf("%d\n",arr[i]);
    		   break;
    	   }
       }
}
}
