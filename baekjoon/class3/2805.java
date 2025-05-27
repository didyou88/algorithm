// Baekjoon 2805 나무 자르기

import java.util.*;
import java.io.*;

class Main {			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] trees = new int[n];
		
		int min = 0;
		int max = 0;
		
		// 나무 정보
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			
			// 나무 중 최대값 구하
			if(trees[i] > max) {
				max = trees[i];
			}
		}
		
		// 이분 탐색 (upper bound)
		while(min < max) {
			int mid = (max + min) / 2;
			long sum = 0;
			
			for(int height: trees) {
				if(height > mid) {
					sum += (height - mid); 
				}
			}
			
//			System.out.println("max: " + max + ", min: " + min + ", mid: " + mid + ", sum: " + sum);
			
			// 합이 기준 보다 낮다 == 자르는 높이가 너무 높다 
			// 즉, 자르는 높이를 줄여야 한다. 
			if(sum < m) {
				max = mid;
			}
			// 합이 기준 보다 높다 == 자르는 높이가 너무 낮다
			// 즉, 자르는 높이를 높여야 한다. 
			else {
				min = mid +1;
			}
		}
		
		System.out.print(min-1);
		br.close();
	}
}
