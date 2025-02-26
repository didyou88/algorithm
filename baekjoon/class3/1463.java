// link: https://www.acmicpc.net/problem/1463

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] dp = new int[n+1];
    dp[0] = 0;
    dp[1] = 0;

    for (int i = 2; i < n+1; i++) {
      // 1 더하기
      dp[i] = dp[i-1] + 1;

      // 2의 배수 확인
      if (i % 2 == 0) {
        dp[i] = Math.min(dp[i], dp[i/2] + 1);
      }

      // 3의 배수 확인
      if (i % 3 == 0) {
        dp[i] = Math.min(dp[i], dp[i/3] +  1);
      }
    }

    System.out.print(dp[n]);
    br.close();
    return;
  }
}

/**
 * 통과는 했지만 효율이 안 좋음 (역 방향으로 찾아가는 점화식 고려)
 * 메모리	       시간	      코드 길이
 * 149316 KB   264 ms	    1098 B
 */
