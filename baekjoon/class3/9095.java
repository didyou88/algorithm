// link: https://www.acmicpc.net/problem/9095

import java.util.*;
import java.io.*;

public class Main {
  static int[] dp = new int[12];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    // dp 배열 채우기
    for(int i = 4; i < 12; i++) {
      dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    }

    for(int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      System.out.println(dp[n]);
    }
  }
}

/**
 * 주의 사항
 * - 규칙 찾아서 점화식 세워야 함
 */
