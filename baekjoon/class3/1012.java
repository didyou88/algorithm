// link: https://www.acmicpc.net/problem/1012

import java.util.*;
import java.io.*;

public class Main {
  static int m, n, k; // 가로 세로 배추개수
  static int numWorm = 0; // 필요한 배추벌레 개수
  static int[][] farm; // 배추 밭
  static boolean[][] visited;
  static int cX, cY; // 배추 위치

  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());

    for (int i = 0; i < t; i++) {
      // 배추 밭 정보
      st = new StringTokenizer(br.readLine());
      m = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());
      farm = new int[m][n];
      visited = new boolean[m][n];

      // 배추 위치 정보 저장
      for (int j = 0; j < k; j++) {
        st = new StringTokenizer(br.readLine());
        cX = Integer.parseInt(st.nextToken());
        cY = Integer.parseInt(st.nextToken());
        farm[cX][cY] = 1;
      }

      // 배추밭 탐색
      for(int x = 0; x < m; x++) {
        for(int y = 0; y < n; y++) {
          if(farm[x][y] == 1 && !visited[x][y]) {
            bfs(x, y);
            numWorm++;
          }
        }
      }

      sb.append(numWorm + "\n");
      numWorm = 0;
    }

    System.out.print(sb.toString());
    br.close();
    return;
  }

  private static void bfs(int x, int y) {
    Queue<int[]> q = new LinkedList<int[]>();
    int checkX = -1;
    int checkY = -1;

    // 시작 노드 방문처리
    q.add(new int[] {x, y});

    while(!q.isEmpty()) {
      int currentX = q.peek()[0];
      int currentY = q.peek()[1];
      visited[currentX][currentY] = true;
      q.poll();

      for (int d = 0; d < 4; d++) {
        checkX = currentX + dx[d];
        checkY = currentY + dy[d];
        if(checkX > -1 && checkX < m && checkY > -1 && checkY < n) {
          if(!visited[checkX][checkY] && farm[checkX][checkY] == 1) {
            visited[checkX][checkY] = true;
            q.add(new int[] {checkX, checkY});
          }
        }
      }
    }
  }
}
