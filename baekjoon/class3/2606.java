// link: https://www.acmicpc.net/problem/2606

import java.util.*;
import java.io.*;

public class Main {
  static int[][] graph;
  static boolean[] check;

  static int nodeNum, edgeNum;
  static int cnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    nodeNum = Integer.parseInt(br.readLine());
    edgeNum = Integer.parseInt(br.readLine());

    graph = new int[nodeNum + 1][nodeNum + 1];
    check = new boolean[nodeNum + 1];

    // edge 정보 저장
    for (int i = 0; i < edgeNum; i++) {
      st = new StringTokenizer(br.readLine());
      int node1 = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());
      graph[node1][node2] = graph[node2][node1] = 1;
    }

    // bfs 탐색
    bfs(1);

    System.out.print(cnt);

    br.close();
    return;
  }

  private static void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();

    // 첫번째 감염 컴퓨터 셋팅
    check[start] = true;
    q.add(start);

    while(!q.isEmpty()) {
      int currentNode = q.poll();
      for (int i = 1; i < nodeNum + 1; i++) {
        if(graph[currentNode][i] == 1 && !check[i]) {
          check[i] = true;
          q.offer(i);
          cnt++;
        }
      }
    }
  }

  private static void dfs(int node) {
    // 첫번째 감염 컴퓨터 셋팅
    check[node] = true;

    for(int i = 0; i < nodeNum + 1; i++) {
      if(graph[node][i] == 1 && !check[i]) {
        check[i] = true;
        cnt++;
        dfs(i);
      }
    }
  }
}
