// 링크: https://www.acmicpc.net/problem/11720

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String numString = br.readLine();
        int ans = 0;
        
        for (int i = 0; i < count; i++) {
            ans += Integer.parseInt(Character.toString(numString.charAt(i))); 
        }
        
        System.out.print(ans);
        
        br.close();
        return;
    }
}

/*
 주의 사항: long도 넘어가는 숫자 있음
*/
