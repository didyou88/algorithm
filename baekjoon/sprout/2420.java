// 링크: https://www.acmicpc.net/problem/2420

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] arrays = br.readLine().split(" ");
        long[] arraysInt = new long[2];
        
        for (int i = 0; i < 2; i++) {
            arraysInt[i] = Long.parseLong(arrays[i]);
        }
        
        System.out.print(Math.abs(arraysInt[0] - arraysInt[1]));
    }
}

/*
 주의 사항: 입력 값이 -20억 ~ 20억 임으로 받는 값을 long으로 받아야 한다.
*/
