// 링크: https://www.acmicpc.net/problem/2738

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] matrix1 = new int[n][m];
        int[][] matrix2 = new int[n][m];
        
        // setting matrix1
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m ; j++) {
                matrix1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // setting matrix2
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m ; j++) {
                matrix2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // print sum result
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                System.out.print((matrix1[i][j] + matrix2[i][j]) + " ");
            }
            System.out.print("\n");
        }
    }
}

/*
 주의 사항:
*/
