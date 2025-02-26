// 링크: https://www.acmicpc.net/problem/11382

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long result = 0;
        
        int count = st.countTokens();
        
        for (int i = 0; i < count; i++) {
            result += Long.parseLong(st.nextToken());
        }

        System.out.print(result);
    }
}

/*
 주의 사항: 최대 값이 10억 임으로 받는 값을 long으로 받아야 한다.
*/
