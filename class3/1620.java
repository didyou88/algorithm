// link: https://www.acmicpc.net/problem/1620

import java.util.*;
import java.io.*;

public class Main {
  static HashMap<Integer, String> mapIntStr = new HashMap<>();
  static HashMap<String, Integer> mapStrInt = new HashMap<>();

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    // 포켓몬 도감 저장
    for(int i = 0; i < n; i++) {
      String pocketmon = br.readLine();
      mapIntStr.put(i+1, pocketmon);
      mapStrInt.put(pocketmon, i+1);
    }

    // 도감 테스트
    for(int j = 0; j < m; j++){
      String test = br.readLine();
      if (isNumber(test)) {
        sb.append(mapIntStr.get(Integer.parseInt(test)) + "\n");
      } else {
        sb.append(String.valueOf(mapStrInt.get(test)) + "\n");
      }
    }

    // 테스트 출력
    bw.write(sb.toString());
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
}

/**
 * 주의
 * - Hash 를 사용하자
 * - for 돌리면 시간 초과 뜸. HashMap 을 두 개 선언!
 */
