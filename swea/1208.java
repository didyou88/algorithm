// link: SWEA 1208. [S/W 문제해결 기본] 1일차 - Flatten

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    ArrayList<Integer> list = new ArrayList<>();
    int dump;

    for(int testCase = 0; testCase < 10; testCase++) {
      st = new StringTokenizer(br.readLine());
      dump = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      while(st.hasMoreTokens()) {
        list.add(Integer.parseInt(st.nextToken()));
      }

      // 평탄화
      for(int d = 0; d < dump; d++) {
        int maxNum = Collections.max(list);
        int minNum = Collections.min(list);

        if((maxNum - minNum) <= 1) {
          break;
        } else {
          list.remove(Integer.valueOf(maxNum));
          list.remove(Integer.valueOf(minNum));

          list.add(maxNum-1);
          list.add(minNum+1);
        }
      }

      int diff = Collections.max(list) - Collections.min(list);
      sb.append("#" +  (testCase + 1) + " " + diff + "\n");

      list.clear();
    }

    System.out.print(sb.toString().trim());

    br.close();
  }

 }

/**
 * 주의 사항
 */

/**
 * 코드 자동완성 끄기: Settings > Editor > Code Completion
 * 코드 추천 끄기: Settings > Editor > Inline Completion
 */
