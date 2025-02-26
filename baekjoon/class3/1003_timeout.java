// link: https://www.acmicpc.net/problem/1003

import java.util.*;
import java.io.*;

public class Main {
  static int cntZero = 0;
  static int cntOne = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());

    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      fibonacci(n);
      bw.write(String.valueOf(cntZero) + " " + String.valueOf(cntOne) + "\n");
      cntZero = 0;
      cntOne = 0;
    }

    bw.flush();
    bw.close();
    br.close();
    return;
  }

  private static int fibonacci(int n) throws IOException {
    if (n == 0) {
      cntZero++;
      return 0;
    } else if (n == 1) {
      cntOne++;
      return 1;
    } else {
      return fibonacci(n-1) + fibonacci(n-2);
    }
  }
}

/**
 * 주의
 * - timeout
 */
