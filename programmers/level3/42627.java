// level3 - 디스크 컨트롤러

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int finishJob = 0;
        int end = 0;
        int jobIdx = 0;
        
        // 작업 요청 시간 오름차순으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        // 우선 순위 큐 정의
        PriorityQueue<int[]> stay = new PriorityQueue<>((t1, t2) -> {
            // 우선 순위
            // 1. 작업 소요 시간 짧은 - 오름차순 t[1]
            // 2. 작업 요청 시간 빠른 - 오름차순 t[0]
            if(t1[1] == t2[1]) {
                return t1[0] - t2[0];
            } else {
                return t1[1] - t2[1];
            }
        });
        
        // task 요청
        while(finishJob < jobs.length) {
            // time >= requestTime 인 작업 대기열에 모두 추가
            while(jobIdx < jobs.length && jobs[jobIdx][0] <= end) {
                stay.add(jobs[jobIdx++]);
            }
            
            if(stay.isEmpty()) {
                end = jobs[jobIdx][0];
            } else {
                int[] tmp = stay.poll();
                answer = answer + end + tmp[1] - tmp[0];
                end = end + tmp[1];
                finishJob++;
            }
        }
        
        return (int) answer / jobs.length;
    }
}
