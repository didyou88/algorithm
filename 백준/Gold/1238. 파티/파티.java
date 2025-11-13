// Baekjoon 1238. 파티 

import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m, x;
	static int[][] map;
	static boolean[] visited;
	static int[] distance;
	static int[] distanceGo;
	static int INF = 100000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 초기화 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		distance = new int[n+1];
		distanceGo = new int[n+1];
		Arrays.fill(distance, INF);
		
		// 지도 그리기 
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			map[s][e] = t;
		}
		
		// 돌아오기 
		dijkstra(x);
		
		// 가기
		for(int i = 1; i < n+1; i++ ) {
			Arrays.fill(visited, false);
			Arrays.fill(distanceGo, INF);
			distance[i] = distance[i] + dijkstra(i, x);
		}
		
		Arrays.sort(distance);
		
		System.out.print(distance[n-1]);
		
		br.close();
	}
	
	static public int dijkstra(int startNode, int endNode) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			return o1[1] - o2[1]; 
		});
		pq.add(new int[] {startNode, 0});
		distanceGo[startNode] = 0;
		
		while(!pq.isEmpty()) {
			int cn = pq.peek()[0];
			int ct = pq.peek()[1];
			pq.poll();
			
			if(cn == endNode) {
				return ct;
			}
			
			if(!visited[cn]) {
				visited[cn] = true;
				
				for(int i = 1; i < n+1; i++) {
					int nt = map[cn][i];
					if(nt != 0) {
						if(distanceGo[i] > ct + nt) {
							distanceGo[i] = ct + nt;
							pq.add(new int[] {i, distanceGo[i]});
						}
					}
				}
			}
		}
		
		return 0;
	}
	
	static public void dijkstra(int startNode) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			return o1[1] - o2[1]; 
		});
		pq.add(new int[] {startNode, 0});
		distance[startNode] = 0;
		
		while(!pq.isEmpty()) {
			int cn = pq.peek()[0];
			int ct = pq.peek()[1];
			pq.poll();
			
			if(!visited[cn]) {
				visited[cn] = true;
				
				for(int i = 1; i < n+1; i++) {
					int nt = map[cn][i];
					if(nt != 0) {
						if(distance[i] > ct + nt) {
							distance[i] = ct + nt;
							pq.add(new int[] {i, distance[i]});
						}
					}
				}
			}
		}
	}
}