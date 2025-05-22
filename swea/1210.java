// swea - 1210. [S/W 문제해결 기본] 2일차 - Ladder1

import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[][] ladder = new int[100][100];
		int testCase;
		int cx, cy;
		int[] dx = {0, 0}; // left, right
		int[] dy = {-1, 1}; // left, right
		
		
		for(int tc = 0; tc < 10; tc++) {
			st = new StringTokenizer(br.readLine());
			testCase = Integer.parseInt(st.nextToken());
			cx = 99;
			cy = -1;
			
			// 사다리 그리
			for(int lx = 0; lx < 100; lx++) {
				st = new StringTokenizer(br.readLine());
				for(int ly = 0; ly < 100; ly++) {
					ladder[lx][ly] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 목적지 찾기
			for(int ly = 0; ly < 100; ly++) {
				if(ladder[99][ly] == 2) {
					cy = ly;
					break;
				}
			}
			
			// 목적지로 부터 거슬러 올라가기
			int dirIdx = -1;
			while(cx > -1) {
				
				// 좌우 이동이 가능한지 확인
				for(int di = 0; di < 2; di++) {
					int nx = cx + dx[di];
					int ny = cy + dy[di];
					
					// 사다리에서 벗어나는지 확인
					if(ny >= 0 && ny < 100) {
						if(ladder[nx][ny] == 1) {
							// 방향 저장
							dirIdx = di;
							break;
						}
					}
				}
				
				// 좌우 이동
				if(dirIdx != -1) {
					while(true) {
						int ny = cy + dy[dirIdx];
						
						if(ny < 0 || ny > 99) {
							break;
						} else {
							if(ladder[cx][ny] == 1) {
								cy = ny;
							} else {
								break;
							}
						}
					}
				}
				
				dirIdx = -1;
				cx--; // up
			}
			
			sb.append("#" + testCase + " " + cy + "\n");
		}
		
		System.out.print(sb.toString().trim());
		br.close();
	}

}

