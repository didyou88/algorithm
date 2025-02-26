// link: https://www.acmicpc.net/problem/2579

import java.util.*;
import java.io.*;

public class Main {
  static List<Integer> list = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int stairNum = Integer.parseInt(br.readLine());
    int[] stairs = new int[stairNum + 1];
    int[] dp = new int[stairNum + 1];
    stairs[0] = 0;
    dp[0] = 0;

    // 계단 점수 저장
    for (int i = 1; i < stairNum + 1; i++) {
      stairs[i] = Integer.parseInt(br.readLine());
    }

    // dp
    dp[1] = stairs[1]; // 계단 첫 번째 칸
    if (stairNum >= 2) dp[2] = stairs[1] + stairs[2];
    for(int i = 3; i < stairNum + 1; i++) {
      dp[i] = Math.max((dp[i-3] + stairs[i-1]), dp[i-2]) + stairs[i];
    }

    System.out.print(dp[stairNum]);
    br.close();
    return;
  }
}
