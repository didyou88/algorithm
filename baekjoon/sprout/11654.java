// 링크: https://www.acmicpc.net/problem/11654

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = br.readLine();
        
        // 문자열 전처리, 배열에 담기
        userInput = userInput.trim();
        
        // 아스키코드 변환
        System.out.print((int)userInput.charAt(0));
    }
}

/*
 주의 사항:
*/
