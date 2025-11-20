import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int num = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int t : tangerine) {
            if(map.containsKey(t)) {
                map.replace(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }
        
        List<Integer> keys = new ArrayList(map.keySet());
        Collections.sort(keys, (k1, k2) -> {
            return map.get(k2) - map.get(k1); 
        });
        
        for(int key : keys) {
            if(num >= k) {
                break;
            }
            
            num += map.get(key);
            answer += 1;
        }
            
        return answer;
    }
}