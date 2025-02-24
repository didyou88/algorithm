// link: https://www.acmicpc.net/problem/17219

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    HashMap<String, String> map = new HashMap<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      map.put(st.nextToken(), st.nextToken());
    }

    for (int i = 0; i < m; i++) {
      String address = br.readLine();
      bw.write(map.get(address) + "\n");
    }

    br.close();
    bw.flush();
    bw.close();
    return;
  }
}
