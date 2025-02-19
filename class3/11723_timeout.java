// link: https://www.acmicpc.net/problem/11723

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    ArrayList<Integer> stack = new ArrayList<>();
    Integer[] initArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cnt = Integer.parseInt(br.readLine());
    StringTokenizer st;

    for (int i = 0; i < cnt; i++) {
      st = new StringTokenizer(br.readLine());
      String method = st.nextToken();
      int num = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : -1;

      switch (method) {
        case "add":
          if (!stack.contains(num)) {
            stack.add(num);
          }
          break;
        case "remove":
          if (stack.contains(num)) {
            stack.remove(Integer.valueOf(num));
          }
          break;
        case "check":
          if (stack.contains(num)) {
            System.out.println(1);
          } else {
            System.out.println(0);
          }
          break;
        case "toggle":
          if (stack.contains(num)) {
            stack.remove(Integer.valueOf(num));
          } else {
            stack.add(num);
          }
          break;
        case "all":
          stack.clear();
          stack.addAll(Arrays.asList(initArray));
          break;
        default:
          stack.clear();
          break;
      }
    }

    br.close();
    return;
  }
}

/**
 * 시간 초과 발생
 * - add : O(1)
 * - remove : O(n)
 * - get : O(1)
 * - contains : O(n)
 * - iterator.remove : O(n)
 */
