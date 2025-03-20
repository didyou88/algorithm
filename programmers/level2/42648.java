// 코딩테스트 연습 > 힙 > 이중우선순위큐
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> q = new PriorityQueue<>(); // 오름차순
        PriorityQueue<Integer> q_reverse = new PriorityQueue(Collections.reverseOrder()); // 내림차순
        String[] operation;
        
        for(int i = 0; i < operations.length; i++) {
            operation = operations[i].split(" ");
            if(operation[0].equals("I")) {
                q.add(Integer.parseInt(operation[1]));
                q_reverse.add(Integer.parseInt(operation[1]));
            } else {
                if(operation[1].equals("1") && !q.isEmpty()) {
                    int maxInt = q_reverse.poll();
                    q.remove(maxInt);
                } 
                if(operation[1].equals("-1") && !q.isEmpty()){
                    int minInt = q.poll();
                    q_reverse.remove(minInt);
                }
            }
        }
        
        if(q.isEmpty()) {
            return new int[] {0, 0};
        } else {
            return new int[] {q_reverse.peek(), q.peek()};
        }
    }
}
