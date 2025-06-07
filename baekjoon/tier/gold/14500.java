// Baekjoon 14500. 테트로미노 

import java.util.*;
import java.io.*;

class Main {
	
	static int n, m;
	static int maxScore = 0;
	static int[][] map;
	static int[][][] tetromino = {
			{{1, 1, 1, 1}},
			{{1, 1}, {1, 1}},
			{{1, 1, 1}, {1, 0, 0}},
			{{0, 1, 1}, {1, 1, 0}},
			{{1, 1, 1}, {0, 1, 0}}
	};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		// 지도 그리기 
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
 			}
		}
		
		// 도형 배치
		for(int i = 0; i < 5; i++) {
			// 현재 도형 
			int[][] t = tetromino[i];
			
			// 도형 회전 
			for(int a = 0; a < 4; a++) {
				t = rotate(t, a);
				mapSearch(t);
			}
			
			// 도형 대칭 후 회전 
			t = mirror(t);
			for(int a = 0; a < 4; a++) {
				t = rotate(t, a);
				mapSearch(t);
			}
		}
		
		System.out.print(maxScore);
		br.close();
	}
	
	// 합 구하기
	static void mapSearch(int[][] t) {		
		int sizeX = t.length;
		int sizeY = t[0].length;
		int total;
		
		// 탐색 시작 위치 잡기 
		for(int x = 0; x < n-sizeX+1; x++) {
			for(int y = 0; y < m-sizeY+1; y++) {
				total = 0; // 초기화
				
				// 테트로노미어 총합 
				for(int tx = 0; tx < sizeX; tx++) {
					for(int ty = 0; ty < sizeY; ty++) {
						if(t[tx][ty] == 1) {
							total += map[x+tx][y+ty];
						}
					}
				}
				
				// 최대값과 비교 
				if(total > maxScore) {
					maxScore = total;
				}
				
			}
		}
	}
	
	// 도형 회전 
	static int[][] rotate(int[][] t, int angle) {
		int sizeX = t[0].length;
		int sizeY = t.length;
		int[][] result = new int[sizeX][sizeY];
		
		if(angle == 0) {
			return t;
		} else {
			for(int y = 0; y < sizeY; y++) {
				for(int x = 0; x < sizeX; x++) {
					result[x][sizeY-1-y] = t[y][x]; 
				}
			}
			
			return result;
		}
	}
	
	// 도형 대칭 
	static int[][] mirror(int[][] t) {
		int sizeX = t.length;
		int sizeY = t[0].length;
		int[][] result = new int[sizeX][sizeY];
		
		for(int x = 0; x < sizeX; x++) {
			for(int y = 0; y < sizeY; y++) {
				result[x][y] = t[x][sizeY-1-y];
			}
		}
		
		return result;
	}
}
