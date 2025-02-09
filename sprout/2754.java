// 링크: https://www.acmicpc.net/problem/2754

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = br.readLine();
        double ans = -1;
        
        char c1 = userInput.charAt(0);
        if (c1 == 'A') {
            ans = calcPlusMinus(4, userInput.charAt(1));
        }
        else if (c1 == 'B') {
            ans = calcPlusMinus(3, userInput.charAt(1));
        }
        else if (c1 == 'C') {
            ans = calcPlusMinus(2, userInput.charAt(1));
        } 
        else if (c1 == 'D') {
            ans = calcPlusMinus(1, userInput.charAt(1));
        } else {
           ans = 0.0; 
        }
        
        System.out.print(ans);
    }
    
    private static double calcPlusMinus(double score, char sign) {
        switch (sign) {
            case '+':
                score += 0.3;
                break;
            case '-':
                score -= 0.3;
                break;
        }
        
        return score;
    }
}

/*
 주의 사항: 자바는 float 쓰려면, n.nf 붙여 줘야 함.
*/
