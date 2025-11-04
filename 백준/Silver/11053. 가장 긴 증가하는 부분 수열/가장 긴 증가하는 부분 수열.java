// Baekjoon 11053. 가장 긴 증가하는 부분 수열 

import java.util.*;
import java.io.*;

public class Main {
	
	static int[] a;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		a = new int[n];
		dp = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			LIS(i);
		}
		
		int max = dp[0];
		
		for(int i = 1; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		
		System.out.print(max);
	}
	
	static int LIS(int n) {
		if(dp[n] == 0) {
			dp[n] = 1;
			
			for(int i = n-1; i >= 0; i--) {
				if(a[i] < a[n]) {
					dp[n] = Math.max(dp[n], LIS(i) + 1);
				}
			}
		}
		
		return dp[n];
	}
}