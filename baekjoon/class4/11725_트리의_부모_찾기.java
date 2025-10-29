// Baekjoon 11725. 트리의 부모찾기 

import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static int[] nodes;
	static List<Integer>[] g;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		nodes = new int[n+1];
		g = new ArrayList[n+1];
		for(int i = 1; i < n+1; i++) {
			g[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			g[n1].add(n2);
			g[n2].add(n1);
		}
		
		bfs(1);
		
		for(int i = 2; i < n+1; i++) {
			sb.append(nodes[i] + "\n");
		}
		
		bw.write(sb.toString().trim());
		bw.flush();
		bw.close();
	}
	
	static void bfs(int startNode) {
		boolean[] visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		
		q.add(startNode);
		visited[startNode] = true;
		
		while(!q.isEmpty()) {
			int cn = q.poll();
			
			for(int i = 0; i < g[cn].size(); i++) {
				int nextNode = g[cn].get(i);
				
				if(!visited[nextNode]) {
					nodes[nextNode] = cn;
					q.add(nextNode);
					visited[nextNode] = true;
				}
			}
		}
	}
}
