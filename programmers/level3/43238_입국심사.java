import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long left = 0;
        long right = (long) n * times[times.length - 1]; // long 으로 형 변환 안 해주면 overflow 발생
        long mid, checkedNum;
        while(left <= right) {
            checkedNum = 0;
            mid = (long) ((left + right) / 2);
            
            for(int i = 0; i < times.length; i++) {
                checkedNum += (long) (mid / times[i]);
            }
            
            if(checkedNum < n) {
                left = mid+1;
            } else {
                answer = mid;
                right = mid-1;
            }
        }
        
        return answer;
    }
}
