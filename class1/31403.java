// 링크: https://www.acmicpc.net/problem/31403

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String aString = br.readLine();
        String bString = br.readLine();
        
        int a = Integer.parseInt(aString);
        int b = Integer.parseInt(bString);
        int c = Integer.parseInt(br.readLine());
        
        System.out.println(a+b-c);
        System.out.print(Integer.parseInt(aString + bString) - c);
        
        br.close();
        return;
    }
}

/*
 주의 사항:
*/
