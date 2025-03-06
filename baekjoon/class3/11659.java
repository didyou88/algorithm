// link: https://www.acmicpc.net/problem/11659

import java.util.*;
import java.io.*;

public class Main {
  static int[] dp = new int[12];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr = new int[n + 1];
    arr[0] = 0;

    // 배열에 누적 합 저장
    st = new StringTokenizer(br.readLine());
    for (int k = 1; k < n+1; k++) {
      arr[k] = Integer.parseInt(st.nextToken()) + arr[k-1];
    }

    // m회 구간 합
    int i = -1;
    int j = -1;
    for (int k = 0; k < m; k++) {
      st = new StringTokenizer(br.readLine());
      i = Integer.parseInt(st.nextToken());
      j = Integer.parseInt(st.nextToken());

      // 합 구하기
      sb.append(arr[j] - arr[i-1] + "\n");
    }

    System.out.print(sb.toString());
    br.close();
    return;
  }
}

/**
 * 주의 사항
 * - 시간 초과 안 날라면 누적합으로 
 */
