// link: https://www.acmicpc.net/problem/4153

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    while(true){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if (a == 0 && b == 0 && c == 0) {
        break;
      }

      int longSide = -1;
      int shortSide = -1;

      if ( a >= b && a >= c) {
        longSide = a * a;
        shortSide = b * b + c * c;
      } else if ( b >= a && b >= c) {
        longSide = b * b;
        shortSide = a * a + c * c;
      } else {
        longSide = c * c;
        shortSide = a * a + b * b;
      }

      if (longSide == shortSide) {
        System.out.println("right");
      } else {
        System.out.println("wrong");
      }
    }

    br.close();
    return;
  }
}

/**
 * 주의: 
 */
