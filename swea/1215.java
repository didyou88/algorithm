// swea - 1215. [S/W 문제해결 기본] 3일차 - 회문1

import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String[][] map = new String[8][8];
		
		for(int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int w = (int)(len / 2);
			int total = 0;
			
			//지도
			for(int x = 0; x < 8; x++) {
				st = new StringTokenizer(br.readLine());
				map[x] = st.nextToken().split("");
			}
			
			// 탐색
			boolean rFlag = true;
			boolean cFlag = true;
			// 세로 탐
			for(int x = 0; x < 9-len; x++) {
				for(int y = 0; y < 8; y++) {
					// 가로 세 탐색
					for(int s = 0; s < w; s++) {
						if(!map[x+s][y].equals(map[x+len-1-s][y])) {
							cFlag = false;
						}
					}
					if(cFlag) total++;
					
					// flag 초기화
					cFlag = true;
				}
			}
			
			for(int x = 0; x < 8; x++) {
				for(int y = 0; y < 9-len; y++) {
					// 가로 세 탐색
					for(int s = 0; s < w; s++) {
						if(!map[x][y+s].equals(map[x][y+len-1-s])) {
							rFlag = false;
						}
					}
					if(rFlag) total++;
					
					// flag 초기화
					rFlag = true;
				}
			}
			
			// 저장
			sb.append("#" + tc + " " + total + "\n");
		}
		
		System.out.print(sb.toString().trim());
		br.close();
	}

}

