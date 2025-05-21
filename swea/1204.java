// swea - 1204. [S/W 문제해결 기본] 1일차 - 최빈수 구하기

import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		ArrayList<Integer> scores = new ArrayList<>();
		int maxNum = -1;
		int maxCnt = 0;
		int cIdx = 0;
		
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				scores.add(Integer.parseInt(st.nextToken()));
			}
			
			Collections.sort(scores, Collections.reverseOrder());
			
//			System.out.println((i+1) + "=====================");
			for(int j = 1; j < scores.size(); j++) {
				if(scores.get(j) != scores.get(cIdx) || j == scores.size()-1) {
//					System.out.println(scores.get(cIdx) + ": " + (j-cIdx));
					if(j-cIdx > maxCnt) {
						maxNum = scores.get(cIdx);
						maxCnt = j - cIdx;
					}
					cIdx = j;
				}
			}
			
			sb.append("#" + num + " " + maxNum + "\n");
			
			maxNum = -1;
			maxCnt = 0;
			cIdx = 0;
			scores.clear();
		}
		
		System.out.print(sb.toString().trim());
		br.close();
	}

}

