// 링크: https://www.acmicpc.net/problem/2744

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = br.readLine();
        String ans = "";
        
        for (int i = 0; i < userInput.length(); i++) {
            if (Character.isUpperCase(userInput.charAt(i))) {
                ans = ans + Character.toString(Character.toLowerCase(userInput.charAt(i)));
            } else {
                ans = ans + Character.toString(Character.toUpperCase(userInput.charAt(i)));
            }
        }
        
        System.out.print(ans);
    }
}

/*
 주의 사항:
*/
