// 링크: https://www.acmicpc.net/problem/5597

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] students = {
            false, false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, false, 
            false, false, false, false, false, false, false, false, false, false, 
        };
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 28; i++) {
            int num = Integer.parseInt(br.readLine());
            students[num-1] = true;
        }
        
        for (int i = 0; i < 30; i++) {
            if (!students[i]) {
                System.out.println(i+1);
            }
        }
    }
}

/*
 주의 사항:
*/
