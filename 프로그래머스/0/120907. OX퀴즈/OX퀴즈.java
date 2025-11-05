import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        StringTokenizer st;
        
        for(int i = 0; i < quiz.length; i++) {
            String[] split = quiz[i].split(" ");
            
            int x = Integer.parseInt(split[0]);
            String calc = split[1];
            int y = Integer.parseInt(split[2]);
            int z = Integer.parseInt(split[4]);
            
            if(calc.equals("+")) {
                answer[i] = x+y == z ? "O" : "X"; 
            } else {
                answer[i] = x-y == z ? "O" : "X"; 
            }
        }
        
        return answer;
    }
}