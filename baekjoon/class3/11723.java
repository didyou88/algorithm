// link: https://www.acmicpc.net/problem/11723

import java.util.*;
import java.io.*;

public class Main {
  static StringBuilder sb = new StringBuilder();
  static int bitMask = 0;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int cnt = Integer.parseInt(st.nextToken());

    for (int i = 0; i < cnt; i++) {
      st = new StringTokenizer(br.readLine());
      String cmd = st.nextToken();
      if (cmd.equals("all") || cmd.equals("empty")) {
        commands(cmd);
      } else {
        int num = Integer.parseInt(st.nextToken());
        commands(cmd, num);
      }
    }

    bw.write(sb.toString());
    br.close();
    bw.close();
    return;
  }

  public static void commands(String cmd) {
    switch (cmd) {
      case "all":
        bitMask = ~0;
        break;
      case "empty":
        bitMask = 0;
        break;
    }
  }

  public static void commands(String cmd, int num) {
    switch (cmd) {
      case "add":
        bitMask = bitMask | (1 << (num-1));
        break;
      case "remove":
        bitMask = bitMask & ~(1 << (num-1));
        break;
      case "check":
        if ((bitMask & (1 << (num-1))) == (1 << (num-1))) {
          sb.append(1 + "\n");
        } else {
          sb.append(0 + "\n");
        }
        break;
      case "toggle":
        if ((bitMask & (1 << (num-1))) == (1 << (num-1))) {
          bitMask = bitMask & ~(1 << num-1);
        } else {
          bitMask = bitMask | (1 << num-1);
        }
        break;
    }
  }
}

/**
 * 주의
 * - 비트마스킹
 * - StringBuilder 사용
 */
