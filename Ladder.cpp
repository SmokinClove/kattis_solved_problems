#include <bits/stdc++.h>
using namespace std;
int main(){
	long long l;
	int angle;
	scanf("%lld%d",&l,&angle);
	long long ans= ceil(l/sin((angle*M_PI)/180));
	printf("%lld\n",ans);
}
