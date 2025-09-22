// Baekjoon 5427. 불  

import java.util.*;
import java.io.*;

class Node {
	int x;
	int y;
	int time;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		this.time = 0;
	}
	
	public Node(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
}

public class Main {
	
	static int w, h;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static Queue<int[]> fireQ;
	static Queue<Node> personQ;
	static boolean[][] visited;
	
	// bfs
	static int bfs(char[][] map) {
		int totalTime = 0;
		
		while(!personQ.isEmpty()){
			
			// 불 번지기 
			int size = fireQ.size();
			for(int f = 0; f < size; f++) {
				int fx = fireQ.peek()[0];
				int fy = fireQ.peek()[1];
				fireQ.poll();
				
				for(int d = 0; d < 4; d++) {
					int nfx = fx + dx[d];
					int nfy = fy + dy[d];
					
					if(nfx >= 0 && nfx < h && nfy >= 0 && nfy < w) {
						if(map[nfx][nfy] == '.') {
							map[nfx][nfy] = '*';
							fireQ.add(new int[] {nfx, nfy});
						}
					}
				}
			}
			
			// 상근이 이동
			int sizeP = personQ.size();
			for(int p = 0; p < sizeP; p++) {
				int cx = personQ.peek().x;
				int cy = personQ.peek().y;
				int cTime = personQ.peek().time;
				personQ.poll();
				
				for(int d = 0; d < 4; d++) {
					int nx = cx + dx[d];
					int ny = cy + dy[d];
					
					// 벽 확인
					if(nx >= 0 && nx < h && ny >= 0 && ny < w) {
						if(map[nx][ny] == '.' && !visited[nx][ny]) {
							personQ.add(new Node(nx, ny, cTime+1));
							visited[nx][ny] = true;
						}
					} else {
						totalTime = cTime + 1;
					}
				}
			}	
			
			if(totalTime != 0) break;
		}
		
		return totalTime;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			char[][] map = new char[h][w];
			fireQ = new LinkedList<>();
			personQ = new LinkedList<>();
			visited = new boolean[h][w];
			
			// 지도 생성
			for (int ch = 0; ch < h; ch++) {
				st = new StringTokenizer(br.readLine());
				map[ch] = st.nextToken().toCharArray();
				for(int cw = 0; cw < w; cw++) {					
					// 사람 위치 추가 
					if(map[ch][cw] == '@') {
						personQ.add(new Node(ch, cw));
						map[ch][cw] = '.';
						visited[ch][cw] = true;
					}
					// 불 위치 추가 
					if(map[ch][cw] == '*') {
						fireQ.add(new int[] {ch, cw});
					}
				}
			}
			
			// 탈출
			int time = bfs(map);
			
			if(time == 0) {
				sb.append("IMPOSSIBLE\n");
			} else {
				sb.append(time).append("\n");
			}
		}
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}	
}

