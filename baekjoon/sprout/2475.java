// 링크: https://www.acmicpc.net/problem/2475

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        long ans = 0;
        
        for (int i = 0; i < arr.length; i++) {
            long currentNum = Long.parseLong(arr[i]);
            ans += currentNum*currentNum;
        }
        
        ans %= 10;
        
        System.out.print(ans);
        
        
        br.close();
        return;
    }
}

/*
 주의 사항:
*/
