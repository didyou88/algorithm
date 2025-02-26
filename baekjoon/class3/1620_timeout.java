// link: https://www.acmicpc.net/problem/1620

import java.util.*;
import java.io.*;

public class Main {
  static List<String> dictionary = new ArrayList<>();

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // 포켓몬 도감 저장
    for(int i = 0; i < n; i++) {
      dictionary.add(br.readLine());
    }

    // 도감 테스트
    for(int j = 0; j < m; j++){
      String test = br.readLine();
      if (isNumber(test)) {
        bw.append(dictionary.get(Integer.parseInt(test)-1)).append("\n");
      } else {
        bw.append(String.valueOf(getIndex(test))).append("\n");
      }
    }

    // 테스트 출력
    bw.write(bw.toString());
    br.close();
    bw.close();
    return;
  }

  private static boolean isNumber(String test) {
    try {
      Integer.parseInt(test);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private static int getIndex(String test) {
    int i = 0;
    while(true) {
      if(dictionary.get(i).equals(test)) {
        return i + 1;
      }
      i++;
    }
  }

}

/**
 * 주의
 * - 시간초과
 */
