// link: SWEA 1206. [S/W 문제해결 기본] 1일차 - View

import java.util.*;
import java.io.*;

public class Main {
  static int n;
  static int[][] board;
  static int[][] snake;
  static int[] head = {1, 1}; // 현재 머리 위치
  static int[] tail = {1, 1}; // 현재 꼬리 위치
  static boolean theEndFlag = false;
  static int time = 0;
  static int[][] dirW = {
      {0, 0},
      {0, 1}, // Right
      {0, -1}, // Left
      {1, 0}, // Down
      {-1, 0} // Up
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine()); // 보드 크기
    int k = Integer.parseInt(br.readLine()); // 사과 개수
    board = new int[n+2][n+2]; // 보드
    snake = new int[n+2][n+2]; // 뱀이 차지한 범위 정보

    // snake 위치 초기화
    snake[1][1] = 1;

    // 사과 배치
    int prow, pcol;
    for(int i = 0; i < k; i++) {
      st = new StringTokenizer(br.readLine());
      prow = Integer.parseInt(st.nextToken());
      pcol = Integer.parseInt(st.nextToken());
      board[prow][pcol] = 1;
    }

    // 이동
    int l = Integer.parseInt(br.readLine());
    int dir = 1; // 현재 이동 방향
    int nt; // 다음 시간
    String c; // 다음 방향 전환
    int i = 0;
    while(!theEndFlag){
      // 방향 이동 존재
      if(i < l) {
        st = new StringTokenizer(br.readLine());
        nt = Integer.parseInt(st.nextToken());
        c = st.nextToken();

        // 뱀 이동
        int nd = nextDir(dir, c);
        moveSnake(nt, dir, nd);
        // 시간 업데이트
        if(!theEndFlag) {
          time = nt;
        }
        // 머리 방향 변경
        dir = nd;
        // 다음 이동 정보 입력받기
        i++;
      } else {
        // 벽에 부딪힐 때 까지 이동
        moveSnake(time+1, dir, dir);
        // 시간 업데이트
        if(!theEndFlag) {
          time++;
        }
      }
    }

    System.out.print(time);

    br.close();
  }

  static void moveSnake(int nt, int dir, int dirS) {
    for(int ct = 0; ct < nt - time; ct++) {
      // 머리 늘리기
      head[0] += dirW[dir][0];
      head[1] += dirW[dir][1];

      // 현재 머리가 벽인가?
      if(head[0] > n || head[1] > n || head[0] < 1 || head[1] < 1) {
        theEndFlag = true;
        time = time + ct + 1;
      }

      // 현재 머리와 몸이 부딪혔는가?
      if(snake[head[0]][head[1]] > 0) {
        theEndFlag = true;
        time = time + ct + 1;
      }

      // 현재 머리가 사과인가?
      if(board[head[0]][head[1]] == 1) {
        // snake 위치 업데이트
        snake[head[0]][head[1]] = ct == (nt - time - 1) ? dirS : dir;
        // 사과 지우기
        board[head[0]][head[1]] = 0;
      } else {
        // snake 위치 업데이트
        snake[head[0]][head[1]] = ct == (nt - time - 1) ? dirS : dir;

        int tailpx = tail[0];
        int tailpy = tail[1];

        // 꼬리 이동
        tail[0] += dirW[snake[tail[0]][tail[1]]][0];
        tail[1] += dirW[snake[tail[0]][tail[1]]][1];

        //
        snake[tailpx][tailpy] = 0;
      }

//      for(int s = 1; s < n+1; s++) {
//        for(int ss = 1; ss < n+1; ss++) {
//          System.out.print(snake[s][ss] + " ");
//        }
//        System.out.println();
//      }

    }
  }

  static int nextDir(int dir, String c) {
    if(c.equals("L")) {
      if(dir == 1) {
        return 4;
      } else if(dir == 2) {
        return 3;
      } else if(dir == 3) {
        return 1;
      } else {
        return 2;
      }
    } else {
      if(dir == 1) {
        return 3;
      } else if(dir == 2) {
        return 4;
      } else if(dir == 3) {
        return 2;
      } else {
        return 1;
      }
    }
  }

}

/**
 * 주의 사항
 */

/**
 * 코드 자동완성 끄기: Settings > Editor > Code Completion
 * 코드 추천 끄기: Settings > Editor > Inline Completion
 */
