// Baekjoon 2630 색종이 만들기
// 분할정복, 재귀 

import java.util.*;
import java.io.*;

class Main {

	static int[][] paper;
	static int[] dirX = {0, 1}; // r, d;
	static int[] dirY = {1, 0};
	static int blue = 0;
	static int white = 0;
			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		paper = new int[n][n];
		
		// 색종이 색칠하기
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 색종이 자르기
		cutPaper(0, 0, n);
		
		// 출력
		System.out.println(white);
		System.out.print(blue);
		
		br.close();
	}
	
	static void cutPaper(int x, int y, int len) {
		// 색 확인 
		int color = colorBfs(x, y, x+len-1, y+len-1);
		
		if(color == 0) {
			white++;
		} else if(color == 1) {
			blue++;
		} else {
			if(len > 1) {
				int nLen = len / 2;
				cutPaper(x, y, nLen);
				cutPaper(x + nLen, y, nLen);
				cutPaper(x, y + nLen, nLen);
				cutPaper(x + nLen, y + nLen, nLen);
			} else {
				return; // 중단 지점 
			}
		}
	}
	
	// -1: 다른 색, 0: 하얀색, 1: 파란
	static int colorBfs(int sx, int sy, int ex, int ey) {
		int initColor = paper[sx][sy];
		
		// 시작 노드 넣기 
		for(int x = sx; x <= ex; x++) {
			for(int y = sy; y <= ey; y++) {
				if(paper[x][y] != initColor) {
					return -1;
				}
			}
		}
		
		return initColor;
	}

}
