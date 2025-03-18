// 코딩테스트 연습 > 스택/큐 > 프로세스

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int ans = 1;
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // 큐에 프로세스 넣기
        for(int i = 0; i < priorities.length; i++) {
            q.add(new int[] {i, priorities[i]});
            pq.add(priorities[i]);
        }
        
        while(!q.isEmpty()) {
            int[] process = q.poll();
            int priority = pq.peek();
            
            // 1순위 프로세스인지 확인
            if(process[1] == priority) {
                // 확인 대상인가?
                if(process[0] == location) {
                    break; 
                } else {
                    pq.poll();
                    ans++;
                }
            } else {
                q.add(process); // 다시 넣기
            }
        }
        
        return ans;  
    }
}
