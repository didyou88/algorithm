// level3 - 섬 연결하기 (union find 알고리즘 적용)
import java.util.*;

class Solution {
    private int[] parrent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parrent = new int[n];
        
        // 자기 자신으로 부모 세팅
        for (int i = 0; i<n; i++) {
            parrent[i] = i;
        }
        
        // cost 오름차순 정렬
        Arrays.sort(costs, (c1, c2) -> c1[2] - c2[2]);
        
        // 다리 연결하면서 최소 비용 계산
        for(int i = 0; i<costs.length; i++) {
            // 부모가 같은지 확인
            if(findParrent(costs[i][0]) != findParrent(costs[i][1])) {
                // 다르면 부모 연결
                connectParrent(costs[i][0], costs[i][1]);
                // 비용 추가
                answer += costs[i][2];
            }
            
        }
        
        return answer;
    }
    
    private int findParrent(int x) {
        if(parrent[x] == x){
            return x;
        } else {
            return findParrent(parrent[x]);
        }
    }
    
    private void connectParrent(int x, int y) {
        int a = findParrent(x);
        int b = findParrent(y);
        
        parrent[a] = b;
    }
}
