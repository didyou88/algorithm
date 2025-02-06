// 링크: https://www.acmicpc.net/problem/10807

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        String[] arr = br.readLine().trim().split(" ");
        int[] arri = new int[n];
        for (int i = 0; i < n; i++) {
            arri[i] = Integer.parseInt(arr[i]);
        }
        
        int target = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            if (target == arri[i]) {
                result++;
            }
        }
        
        System.out.print(result);
    }
}

/*
 주의 사항:
*/
