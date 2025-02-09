// 링크: https://www.acmicpc.net/problem/15964

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        
        System.out.print(calc(a, b));
        
        br.close();
        return;
    }
    
    private static long calc(long a, long b) {
        return (a + b) * (a - b);
    }
}

/*
 주의 사항: long 주의
*/
