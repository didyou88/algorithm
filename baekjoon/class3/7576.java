// Baekjoon 7576. 토마토 

import java.util.*;
import java.io.*;

class Main {
	
	static int m, n;
	static int[][] box;
	static int minDay = Integer.MAX_VALUE;
	static int[] dirX = {0, 0, 1, -1};
	static int[] dirY = {1, -1, 0 , 0};
	static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		box = new int[n][m];
		int ans = Integer.MIN_VALUE;
		
		// 토마토 채우기
		boolean tomatoFlag = true;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());

				if(box[i][j] == 1) {
					q.add(new int[] {i, j, 1});
				} else {
					tomatoFlag = false;
				}
			}
		}
		
		if(tomatoFlag) {
			System.out.print(0);
		} else {
			// 토마토 익히기
			bfs();
			
			// 토마토 기간 찾기
			boolean nonTomatoFlag = false;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(box[i][j] == 0) {
						nonTomatoFlag = true;
					}
					if(box[i][j] > ans) {
						ans = box[i][j];
					}
				}
			}
			
			if(nonTomatoFlag) {
				System.out.print(-1);
			} else {
				System.out.print(ans-1);
			}
		}

		br.close();
	}
	
	static void bfs() {	
		while(!q.isEmpty()) {
			int cx = q.peek()[0];
			int cy = q.peek()[1];
			int day = q.peek()[2];
			q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = cx + dirX[d];
				int ny = cy + dirY[d];
				int nDay = day + 1;
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if(box[nx][ny] == 0) {
						box[nx][ny] = nDay;
						q.add(new int[] {nx, ny, nDay});
					} else if(box[nx][ny] > 2) {
						if(nDay < box[nx][ny]) {
							box[nx][ny] = nDay;
							q.add(new int[] {nx, ny, nDay});
						}
					} else {
						continue;
					}
				}
			}
		}
	}
}
