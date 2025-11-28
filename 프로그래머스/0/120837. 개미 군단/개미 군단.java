class Solution {
    public int solution(int hp) {
        int answer = 0;
        
        answer += (int) hp / 5;
        hp = (int) hp % 5;
        
        answer += (int) hp / 3;
        answer += (int) hp % 3;
        
        return answer;
    }
}