#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;
unordered_map<char, unsigned> Set;
void setup(){
	Set['a']=2;Set['b']=22;Set['c']=222;
	Set['d']=3;Set['e']=33;Set['f']=333;
	Set['g']=4;Set['h']=44;Set['i']=444;
	Set['j']=5;Set['k']=55;Set['l']=555;
	Set['m']=6;Set['n']=66;Set['o']=666;
	Set['p']=7;Set['q']=77;Set['r']=777;Set['s']=7777;
	Set['t']=8;Set['u']=88;Set['v']=888;
	Set['w']=9;Set['x']=99;Set['y']=999;Set['z']=9999;
	Set[' ']=0;
}
int main(){
	int TC,caseno=0;
	scanf("%d",&TC);
	char input[1002];
	setup();
	fgets(input, sizeof input, stdin);
	while(TC-->0){
		printf("Case #%d: ",++caseno);
		fgets(input, sizeof input, stdin);
       string in=input;
       int len = in.length();
       for(int i=0;i<len-1;i++){
    	   char curr=input[i];
    	   if(i>0){
    		   char prev = input[i-1];
    		   if(Set[curr]%10 == Set[prev]%10){
    			 //  printf("\ncurr %c prev %c diff %d\n",curr,prev,abs((Set[curr]-Set[prev])%10));
    			   printf(" ");
    		   }
    	   }
    	   printf("%d",Set[curr]);
       }
       printf("\n");
	}
}
