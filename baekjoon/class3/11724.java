// Baekjoon 11724. 연결 요소의 개수

import java.util.*;
import java.io.*;

class Main {
	static boolean[] visited;
	static ArrayList<Integer>[] graph; // 인접 리스트 형식으로 풀어야 bfs 안 터짐 
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		// 방향 없는 연결 요소 [i][j], [j][i] 모두 1 로 표시해야 함
		visited = new boolean[n];
		graph = new ArrayList[n];
		
		for(int i = 0; i < n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		// 탐색 
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				bfs(i); // 연결 노드 방문처리
//				dfs(i);
				cnt++;
			}
		}
		
		System.out.print(cnt);
		br.close();
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		
		// 시작 노드 방문 처리
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(int nv : graph[node]) {
				if(!visited[nv]) {
					visited[nv] = true;
					q.add(nv);
				}
			}
		}
	}
	
	static void dfs(int cv) {
		if(!visited[cv]) {
			
			visited[cv] = true;
			
			for(int nv : graph[cv]) {
				if(!visited[nv]) {
					dfs(nv);
				}
			}
		}
	}
}
