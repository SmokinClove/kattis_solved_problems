#include <bits/stdc++.h>
using namespace std;

int main(){
int N,M,U,L,R,D;
scanf("%d%d%d%d%d%d",&M,&N,&U,&L,&R,&D);
int width = L+N+R;
char A[M][N];
for(int i=0;i<M;i++){
	scanf("%s",A[i]);
}
//frame
for(int indx=0;indx<U;indx++){//top frame
	if(indx%2==0){
		for(int i=0;i<width;i++){
			    	if(i%2==0)printf("#");
			    	if(i%2==1)printf(".");
			    }
	}else{
		for(int i=0;i<width;i++){
					    	if(i%2==0)printf(".");
					    	if(i%2==1)printf("#");
					    }
	}
	printf("\n");
}
//now the picture
for(int row=U;row<M+U;row++){
	if(row%2==0){
	    for(int i=0;i<L;i++){//left frame
	    	if(i%2==0)printf("#");
	    	if(i%2==1)printf(".");
	    }
    }else{
    	for(int j=0;j<L;j++){
    		if(j%2==0)printf(".");
    		if(j%2==1)printf("#");
    	}
    }
	for(int i=0;i<N;i++){
		printf("%c",A[row-U][i]);
	}

	if(row%2==0){//right frame
		    for(int i=L+N;i<width;i++){
		    	if(i%2==0)printf("#");
		    	if(i%2==1)printf(".");
		    }
	    }else{
	    	for(int j=L+N;j<width;j++){
	    		if(j%2==0)printf(".");
	    		if(j%2==1)printf("#");
	    	}
	    }
	printf("\n");
}
//bottom. Finally!
for(int row=M+U;row<M+U+D;row++){
	if(row%2==0){//right frame
		for(int i=0;i<width;i++){
			if(i%2==0)printf("#");
			if(i%2==1)printf(".");
		}
	}else{
		for(int i=0;i<width;i++){
			if(i%2==0)printf(".");
			if(i%2==1)printf("#");
	    }
	}
	printf("\n");
}
}
