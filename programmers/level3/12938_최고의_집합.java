import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] best = new int[n];
        
        if(n > s) return new int[] {-1};
        
        int c = (int) s / n;
        int r = s % n;
        
        Arrays.fill(best, 0, n-r, c);
        Arrays.fill(best, n-r, n, c+1);
        
        return best;
    }
}
