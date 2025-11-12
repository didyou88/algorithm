import java.util.*;

class Solution {
    public int solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int a: array) {
            if(map.containsKey(a)) {
                map.replace(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        
        List<Integer> keys = new ArrayList(map.keySet());
        Collections.sort(keys, (k1, k2) -> {
            return map.get(k2) - map.get(k1); 
        });
        
        if(keys.size() > 1) {
            if(map.get(keys.get(0)) == map.get(keys.get(1))) {
                return -1;
            }
        }
        
        return keys.get(0);
    }
}