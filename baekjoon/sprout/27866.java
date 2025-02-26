// 링크: https://www.acmicpc.net/problem/27866

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = br.readLine();
        int target = Integer.parseInt(br.readLine());
        
        System.out.print(userInput.charAt(target-1));
    }
}

/*
 주의 사항:
*/
