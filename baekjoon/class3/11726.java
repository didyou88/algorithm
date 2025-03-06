// link: https://www.acmicpc.net/problem/11726

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] dp = new int[1001];
    dp[1] = 1;
    dp[2] = 2;

    for(int i = 3; i < n+1; i++) {
      dp[i] = (dp[i-1] + dp[i-2]) % 10007;
    }

    System.out.print(dp[n]);
    br.close();
    return;
  }
}

/**
 * 주의 사항
 * - 점화식
 * - 오버플로우 주의
 */
