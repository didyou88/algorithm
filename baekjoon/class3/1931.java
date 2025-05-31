// Baekjoon 1931. 회의실 배정 

import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] time = new int[n][2];
		
		// 시간표 저장 
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		// 시간표 정렬
		Arrays.sort(time, (o1, o2) -> {
			return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
		});
		
		
		int cnt = 1;
		int e = time[0][1];
		int ns, ne;
		for(int i = 1; i < n; i++) {
			ns = time[i][0];
			ne = time[i][1];
			
			if(ns >= e) {
				cnt++;
				e = ne;
			}
		}
		
		System.out.print(cnt);
		br.close();
	}
}
