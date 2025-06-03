// Baekjoon 9663. n-queen

import java.util.*;
import java.io.*;

class Main {
	static int[] map; // index: row, value: col
	static int n;
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n];
		
		nQueen(0);
		System.out.print(cnt);
		br.close();
	}
	
	static void nQueen(int row) {
		// 재귀 중단 조건
		// : row = n 까지 모두 채우면 중단 
		if(row == n) {
			cnt++;
			return;
		}
		
		// row에 col 배정 
		for(int i = 0; i < n; i++) {
			map[row] = i;
			
			if(check(row)) {
				nQueen(row+1);
			}
		}
	}
	
	// 해당 에서 i번째 에 둘 수 있는지 확
	public static boolean check(int col) {
		
		for(int i = 0 ; i < col ; i++) {
			//행에 일치하는게 있는지 판별
			if(map[i]==map[col]) {
				return false;
			}
			//대각선에 일치하는게 있는지 판별
			else if(Math.abs(col-i) == Math.abs(map[col]-map[i])) {
				return false;
			}
		}
		
		return true;
	}
	
}
