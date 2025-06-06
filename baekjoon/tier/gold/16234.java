// Baekjoon 16234. 인구 이동 

import java.util.*;
import java.io.*;

class Main {
	
	static int n, l, r;
	static int[][] map;
	static boolean[][] visited;
	static boolean isMove = true;
	static int day = 0;
	static int[] dirX = {0, 0, 1, -1};
	static int[] dirY = {1, -1, 0, 0};
	static ArrayList<int[]> groupList = new ArrayList<>();
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		// 지도 그리기
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 탐색
		while(isMove) {
			// 초기화
			visited = new boolean[n][n];
			isMove = false;
			
			// n번째 날 탐
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(!visited[i][j]) {
						bfs(i, j);
					}
				}
			}
			
			// 이동 했는지 확인
			if(isMove) {
				day++;
			}
		}
		
		System.out.print(day);
		br.close();
	}
	
	// 연맹 맺기 
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		groupList.clear();
		
		q.add(new int[] {x, y});
		visited[x][y] = true;
		groupList.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int cx = q.peek()[0];
			int cy = q.peek()[1];
			q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cx + dirX[i];
				int ny = cy + dirY[i];
				
				// 지도내 범위 확인
				if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
					// 방문 여부 확인 
					if(!visited[nx][ny]) {
						// 연맹 조건 확인 
						int diff = Math.abs(map[cx][cy] - map[nx][ny]);
						if(diff >= l && diff <= r) {
							q.add(new int[] {nx, ny});
							visited[nx][ny] = true;
							groupList.add(new int[] {nx, ny});
						}
					}
				}
			}
		}
		
		// 연맹 국가 인구 이동
		if(groupList.size() > 1) {
			isMove = true;
			move();
		}
	}
	
	// 연맹 내 인구 이동 
	static void move() {
		int pSum = 0;
		int avg = 0;
		
		for(int i = 0; i < groupList.size(); i++) {
			pSum += map[groupList.get(i)[0]][groupList.get(i)[1]];
		}
		avg = (int) (pSum / groupList.size());
		
		for(int i = 0; i < groupList.size(); i++) {
			map[groupList.get(i)[0]][groupList.get(i)[1]] = avg;
		}
	}
}
