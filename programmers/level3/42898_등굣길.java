class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m+1][n+1];
        
        // 집 초기화
        map[1][1] = 1;
        
        // 웅덩이 깔기
        for(int i = 0; i < puddles.length; i++) {
            int x = puddles[i][0];
            int y = puddles[i][1];
            map[x][y] = -1;
        }
        
        // dp
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(map[i][j] == -1) {
                    map[i][j] = 0;
                } else {
                    if(!(i == 1 && j == 1)) map[i][j] = (map[i-1][j] + map[i][j-1]) % 1000000007;
                }            
            }
        }
        
        return map[m][n];
    }
}
