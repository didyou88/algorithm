// Baekjoon 15685. 치킨 배달 

import java.util.*;
import java.io.*;

class Main {

	static int n, m;
	static int[][] map;
	static ArrayList<int[]> home;
	static ArrayList<int[]> chicken;
	static boolean[] open;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 도시 사이즈 
		m = Integer.parseInt(st.nextToken()); // 치킨 집 개
		
		// 도시 정보 저장
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					home.add(new int[] {i, j});
				}
				if(map[i][j] == 2) {
					chicken.add(new int[] {i, j}); 
				}
			}
		}
		
		open = new boolean[chicken.size()];
		
		chooseOpen();
		
		System.out.print(ans);
		br.close();
	}
	
	static void chooseOpen() {
		// 오픈할 치킨집 선택
		
		
		// 거리 탐색
		calcDist();
	}
	
	static void calcDist() {
		int tmp = Integer.MAX_VALUE;
		
		for(int c = 0; c < chicken.size(); c++) {
			for(int h = 0; h < home.size(); h++) {
				if(open[c]) {
					tmp = tmp + Math.abs(chicken.get(c)[0] - home.get(h)[0]) 
							+ Math.abs(chicken.get(c)[1] - home.get(h)[1]); 
				}
			}
		}
		
		if(tmp < ans) {
			ans = tmp;
		}
	}
		
}
