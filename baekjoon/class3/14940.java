// Baekjoon 14940. 쉬운 최단거

import java.util.*;
import java.io.*;

class Main {
	static int n, m;
	static int[][] map;
	static int[][] dirMap;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dirMap = new int[n][m];
		visited = new boolean[n][m];
		int sx = 0, sy = 0; // 목표 좌표 위치 
		
		// 지도 그리기 
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 2) {
					sx = i;
					sy = j;
				}
			}
		}
		
		bfs(sx, sy);
		
		// 출력 지도 그리기 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 1 && dirMap[i][j] == 0) {
					dirMap[i][j] = -1;
				}
				
				sb.append(dirMap[i][j]);
				if(j != m-1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString().trim());
		br.close();
	}
	
	static void bfs(int sx, int sy) {
		Queue<int[]> q = new LinkedList<>(); // [x, y, 목표 지점으로부터 거리] 
		
		q.add(new int[] {sx, sy, 0});
		dirMap[sx][sy] = 0;
		visited[sx][sy] = true;
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int dir = q.peek()[2];
			q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				// 지도 범위인지 확인 
				if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
					// 갈 수 있는 곳인지 확인
					if(map[nx][ny] == 1 && !visited[nx][ny]) {
						q.add(new int[] {nx, ny, dir+1});
						dirMap[nx][ny] = dir+1;
						visited[nx][ny] = true;
					}
				}
			}
		}

	}
			
}
