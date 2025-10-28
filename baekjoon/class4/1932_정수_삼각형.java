// Baekjoon 1932. 정수 삼각형 

import java.util.*;
import java.io.*;

public class Main {
	
	static List<Integer>[] tree;
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] dp = new int[n][n];
		
		// tree 초기
		tree = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			tree[i] = new ArrayList<>();
		}
		
		// 정삼각형 채우기
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				tree[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		// dp 
		dp[0][0] = tree[0].get(0);
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < tree[i].size(); j++) {
				int cn = dp[i][j];
				dp[i+1][j] = Math.max(dp[i+1][j], cn + tree[i+1].get(j));
				dp[i+1][j+1] = Math.max(dp[i+1][j+1], cn + tree[i+1].get(j+1));
			}
		}
		
		Arrays.sort(dp[n-1]);
		System.out.println(dp[n-1][n-1]);
	}
}
