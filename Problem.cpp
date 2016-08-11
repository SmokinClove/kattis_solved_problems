#include <bits/stdc++.h>
using namespace std;

#define MAX_N 90

char T[MAX_N], P[8]; // T = text, P = pattern
int b[MAX_N], n, m; // b = back table, n = length of T, m = length of P
bool found;
void kmpPreprocess() { // call this before calling kmpSearch()
  int i = 0, j = -1; b[0] = -1; // starting values
  while (i < m) { // pre-process the pattern string P
    while (j >= 0 && P[i] != P[j]) j = b[j]; // if different, reset j using b
    i++; j++; // if same, advance both pointers
    b[i] = j; // observe i = 8, 9, 10, 11, 12 with j = 0, 1, 2, 3, 4
} }           // in the example of P = "SEVENTY SEVEN" above

void kmpSearch() { // this is similar as kmpPreprocess(), but on string T
  int i = 0, j = 0; // starting values
  while (i < n) { // search through string T
    while (j >= 0 && T[i] != P[j]) j = b[j]; // if different, reset j using b
    i++; j++; // if same, advance both pointers
    if (j == m) { // a match found when j == m
     found = true;
      break;
} } }

int main(){
	strcpy(P,"problem");
	m=strlen(P);
while(fgets(T, sizeof T, stdin) != NULL){
	n=strlen(T);
	for(int i=0;i<n;i++)
		T[i]=tolower(T[i]);
		found=false;
	kmpPreprocess();
	kmpSearch();
	if(found)printf("yes\n");
	else printf("no\n");
}

}
