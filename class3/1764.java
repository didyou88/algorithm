// link: https://www.acmicpc.net/problem/1764

import java.util.*;
import java.io.*;

public class Main {
  static HashMap<String, String> notSeeMap = new HashMap<>();
  static List<String> notSeeHearList = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    for (int i = 0; i < n; i++) {
      String name = br.readLine();
      notSeeMap.put(name, "notSee");
    }

    for (int i = 0; i < m; i++) {
      String name = br.readLine();
      if (notSeeMap.containsKey(name)) {
        notSeeHearList.add(name);
      }
    }

    Collections.sort(notSeeHearList);

    bw.write(String.valueOf(notSeeHearList.size()) + "\n");
    for (String s : notSeeHearList) {
      bw.write(s + "\n");
    }
    br.close();
    bw.close();
    return;
  }
}
