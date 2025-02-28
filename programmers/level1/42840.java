// level1 - 모의고사

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[][] right = {{1, 0}, {2, 0}, {3, 0}};
        int[] ans1 = {1, 2, 3, 4, 5};
        int[] ans2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] ans3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == ans1[i % 5]) right[0][1]++;
            if(answers[i] == ans2[i % 8]) right[1][1]++;
            if(answers[i] == ans3[i % 10]) right[2][1]++;
        }
        
        Arrays.sort(right, (a1, a2) -> a2[1] - a1[1]);
        
        if (right[0][1] == right[1][1] && right[0][1] == right[2][1]) {
            answer = new int[3];
            answer[0] = right[0][0];
            answer[1] = right[1][0];
            answer[2] = right[2][0];
        } else if (right[0][1] == right[1][1]) {
            answer = new int[2];
            answer[0] = right[0][0];
            answer[1] = right[1][0];
        } else {
            answer = new int[1];
            answer[0] = right[0][0];
        }
        
        return answer;
    }
}
