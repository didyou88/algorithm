// 링크: https://www.acmicpc.net/problem/9086

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < count; i++) {
            String userInput = br.readLine();
            String c1 = Character.toString(userInput.charAt(0));
            String c2 = Character.toString(userInput.charAt(userInput.length()-1));
            System.out.println(c1 + c2);
        }
        
        br.close();
        return;
    }
}

/*
 주의 사항:
*/
