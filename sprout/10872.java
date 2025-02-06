// 링크: https://www.acmicpc.net/problem/10871

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long result = 1;
        
        if (n != 0) {
            for (int i = 1; i < n+1; i++) {
                result *= i;
            }
        }
        
        System.out.print(result);
    }
}

/*
 주의 사항:
*/
