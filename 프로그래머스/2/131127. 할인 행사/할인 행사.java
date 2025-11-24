import java.util.*;

class Solution {
    HashMap<String, Integer> map;
    HashMap<String, Integer> wantMap;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        map = new HashMap<>();
        wantMap = new HashMap<>();
        
        //초기화
        for(int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for(int i = 0; i < 10; i++) {
            String key = discount[i];
            if(map.containsKey(key)) {
                map.replace(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        
        // 체크
        if(check()) answer++;
        for(int i = 0; i < discount.length - 10; i++) {
            String key1 = discount[i];
            String key2 = discount[i+10];
            
            map.replace(key1, map.get(key1)-1);
            if(map.containsKey(key2)) {
                map.replace(key2, map.get(key2)+1);
            } else {
                map.put(key2, 1);
            }
                
            if(check()) answer++;
        }
        
        return answer;
    }
    
    public boolean check() {
        List<String> keys = new ArrayList(wantMap.keySet());
        
        for(String key : keys) {
            if(!map.containsKey(key)) {
                return false;
            } else {
                if(map.get(key) < wantMap.get(key)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}