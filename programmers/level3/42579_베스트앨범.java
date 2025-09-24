import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        HashMap<String, Integer> num = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            if(num.containsKey(genre)) {
                num.replace(genre, num.get(genre) + play);
                music.get(genre).put(i, play);
            } else {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, play);
                music.put(genre, map);
                num.put(genre, play);
            }
        }
        
        // 장르 내림차순 정렬
        List<String> keyList = new ArrayList(num.keySet());
        Collections.sort(keyList, (k1, k2) -> {
            return num.get(k2) - num.get(k1);
        });
        
        // 음악 내림차순 정렬
        for(String key : keyList) {
            HashMap<Integer, Integer> map = music.get(key);
            List<Integer> musicKeyList = new ArrayList(map.keySet());
            
            Collections.sort(musicKeyList, (k1, k2) -> {
                return map.get(k2) - map.get(k1);
            });
            
            ans.add(musicKeyList.get(0));
            if(musicKeyList.size() > 1) ans.add(musicKeyList.get(1));
        }
        
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
