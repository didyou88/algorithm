// Baekjoon 9465. 스티커 

import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int testCase = 0; testCase < t; testCase++) {
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n];
			int[][] dp = new int[2][n+1];
			
			// 스티커 값 저장 하기 
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				sticker[0][i] = Integer.parseInt(st1.nextToken());
				sticker[1][i] = Integer.parseInt(st2.nextToken());
			}
			
			// dp 알고리즘
			dp[0][0] = 0;
			dp[1][0] = 0;
			dp[0][1] = sticker[0][0];
			dp[1][1] = sticker[1][0];
			
			for(int i = 2; i < n+1; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + sticker[0][i-1];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + sticker[1][i-1];
			}

			sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
		}
		
		System.out.print(sb.toString().trim());
	}	
}

