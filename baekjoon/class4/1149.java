// Baekjoon 11498. RGB거리

import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] priceArr = new int[n][3];
		int[][] priceSum = new int[n][3];
		int ans;
		
		// rgb 정보 
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				priceArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 누적 합 구하기
		priceSum[0][0] = priceArr[0][0];
		priceSum[0][1] = priceArr[0][1];
		priceSum[0][2] = priceArr[0][2];
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				int p1 = 0;
				int p2 = 0;
				
				if(j == 0) {
					p1 = priceSum[i-1][1] + priceArr[i][j];
					p2 = priceSum[i-1][2] + priceArr[i][j];
				} else if(j == 1) {
					p1 = priceSum[i-1][0] + priceArr[i][j];
					p2 = priceSum[i-1][2] + priceArr[i][j];
				} else {
					p1 = priceSum[i-1][0] + priceArr[i][j];
					p2 = priceSum[i-1][1] + priceArr[i][j];
				}
				
				priceSum[i][j] = Math.min(p1, p2);
			}
		}
		
		ans = Math.min(Math.min(priceSum[n-1][0], priceSum[n-1][1]), priceSum[n-1][2]);
		System.out.print(ans);
		br.close();
	}
}
