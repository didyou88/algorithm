import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int ans = 0;
        
        Arrays.sort(routes, (o1, o2) -> {            
            return o1[1] - o2[1];
        });

        int camera = -30001;
        int entry = -30001;
        int exit = -30001;
        for(int i = 0; i < routes.length; i++) {
            entry = routes[i][0];
            exit = routes[i][1];
            
            if(!(camera >= entry && camera <= exit)) {
                ans++;
                camera = exit;
            }
        }
        
        return ans;
    }  
}
