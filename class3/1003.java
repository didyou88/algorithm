// link: https://www.acmicpc.net/problem/1003

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    int[][] dp = new int[41][2];
    dp[0][0] = 1;
    dp[0][1] = 0;
    dp[1][0] = 0;
    dp[1][1] = 1;

    // 40까지 1, 0 출력횟수 메모리제이션
    for (int i = 2; i < 41; i++) {
      dp[i][0] = dp[i-1][0] + dp[i-2][0];
      dp[i][1] = dp[i-1][1] + dp[i-2][1];
    }

    // 입력케이스 답 출력
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      System.out.println(dp[n][0] + " " + dp[n][1]);
    }

    br.close();
    return;
  }
}
