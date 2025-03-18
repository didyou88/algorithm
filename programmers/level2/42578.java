// 코딩테스트 연습 > 해시 > 의상
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int ans = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        // 종료별 옷 개수 저장
        for(int i = 0; i < clothes.length; i++) {
            if(map.containsKey(clothes[i][1])) {
                map.replace(clothes[i][1], map.get(clothes[i][1]) + 1);
            } else {
                map.put(clothes[i][1], 1);
            }
        }
        
        // 옷 조합 계산하기
        for(String key: map.keySet()) {
            ans *= (map.get(key) + 1);
        }
        
        return ans - 1;   
    }
}
