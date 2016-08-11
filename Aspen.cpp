#include <cmath>
#include <algorithm>
#include <cstdio>
using namespace std;

int N, L, W;
int trees[2001];
double dd;
double dist[2001];
double memo[2001][2001];
const double INF = 1e30;

double cal(int tree, int pos){
   	if(pos < N/2) return abs(trees[tree] - dist[pos]);
   	else return sqrt((trees[tree] - dist[pos - N/2]) * (trees[tree] - dist[pos - N/2]) + W * W);
}

double solve(int cur_tree, int cur_left, int cur_right){
		if(cur_left == N/2 - 1 && cur_right == N) {
			return cal(cur_tree, cur_left);//go left
		}
		if(cur_left == N/2 && cur_right == N - 1) {
			return cal(cur_tree, cur_right);//go right
		}
		if(cur_left == N/2 ) {
			return cal(cur_tree, cur_right) + solve(cur_tree + 1, cur_left, cur_right + 1);//must put on the right
		}
		if(cur_right == N) {
			return cal(cur_tree, cur_left) + solve(cur_tree + 1, cur_left + 1, cur_right);//must put on the left
		}

		double& l = memo[cur_tree][cur_left];
		if(l == -1){
			l = cal(cur_tree, cur_left) + solve(cur_tree + 1, cur_left + 1, cur_right);
		}
		double& r = memo[cur_tree][cur_right];
		if(r == -1){
			r = cal(cur_tree, cur_right) + solve(cur_tree + 1, cur_left, cur_right + 1);
		}

		return min(l, r);
}
int main(){
scanf("%d%d%d", &N, &L, &W);
    for(int i = 0; i < N; ++i){
    	int p; scanf("%d", &p);
    	trees[i] = p;
    }
    sort(trees, trees + N);
    dd = (double)L/(N/2 - 1);
    for(int i = 0; i < N/2; i++){
         dist[i] = i * dd;
    }
    for (int i = 0; i <= N; ++i) {
         for (int j = 0; j <= N; ++j) memo[i][j] = -1;
    }

    printf("%.15g\n", solve(0,0,N/2));
}
