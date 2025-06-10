// Baekjoon 14503. 로봇 청소기 

import java.util.*;
import java.io.*;

class Main {
	
	static int n, m, d, sx, sy;
	static int[] dirX = {-1, 0, 1, 0}; // 북 동 남 서 
	static int[] dirY = {0, 1, 0, -1}; // 북 동 남 서 
	static int[][] map;
	static int clean = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		// 지도 그리기 
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(sx, sy, d);
		
		System.out.print(clean);
		br.close();
	}
	
	static void dfs(int x, int y, int d) {
		// 현재 칸 청소
		map[x][y] = 2;

		// 주변 청소 
		for(int i = 1; i < 5; i++) {
			// 탐색 방향 선정 
			int nd = (d - i) < 0 ? d - i + 4 : d - i;
			int nx = x + dirX[nd];
			int ny = y + dirY[nd];
			
			// 지도 범위인지 확인 
			if(nx >=  0 && nx < n && ny >= 0 && ny < m) {
				// 벽이 아닌지, 청소 안 했는지 확인 
				if(map[nx][ny] == 0) {
					clean++;
					dfs(nx, ny, nd);
					return;
				}
			}
		}
		
		// 후진
		int bx = x - dirX[d];
		int by = y - dirY[d];
		if(bx >= 0 && bx < n && by >= 0 && by < m && map[bx][by] != 1) {
			dfs(bx, by, d);
		}
	}
}
