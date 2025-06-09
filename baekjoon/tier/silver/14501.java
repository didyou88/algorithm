// Baekjoon 14501. 퇴사 

import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		int[] dp = new int[n+2];
		
		// 스케쥴 정리 
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());			
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		// 최대 값 구하기
		for(int i = 1; i < n+1; i++) {			
			if(i + t[i] <= n+1) {
				dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
			}
			
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		
		System.out.print(dp[n+1]);
		br.close();
	}
}
