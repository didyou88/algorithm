// Baekjoon 1074. Z

import java.util.*;
import java.io.*;

class Main {
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int size = (int) Math.pow(2, N);
		
		search(size, r, c);
		
		System.out.print(cnt);
		br.close();
	}
	
	static void search(int size, int row, int col) {
		if(size <= 1) {
			return;
		}
		
		// 2사분면 
		if(row < size/2 && col < size/2) {
			search(size/2, row, col);
		}
		// 1사분면 
		else if(row < size/2 && col >= size/2) {
			cnt += (size * size) / 4;
			search(size/2, row, col - size/2);
		}
		// 3사분면 
		else if(row >= size/2 && col < size/2) {
			cnt += (size * size) / 2;
			search(size/2, row - size/2, col);
		}
		// 4사분면 
		else  {
			cnt += ((size * size) / 4 ) * 3;
			search(size/2, row - size/2, col - size/2);
		}
	}
			
}
