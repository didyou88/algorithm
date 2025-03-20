// 코딩테스트 연습 > 탐욕법 > 큰 수 만들기

import java.util.*;

// class Solution {
//     public String solution(String number, int k) {
//         StringBuilder answer = new StringBuilder();
//         int c = number.length() - k; // 골라야할 숫자 개수
//         int startIdx = -1; // 탐색 시작 위치

//         // 숫자 문자열 -> 배열
//         String[] numberStrArr = number.split("");
//         int[] numberArr = new int[numberStrArr.length];
//         for(int i = 0; i < numberStrArr.length; i++) {
//             numberArr[i] = Integer.parseInt(numberStrArr[i]);
//         }
            
//         // 숫자 선택 반복문
//         int initStartIdx = -1;
//         int currentNum = -1;
//         for(int i = 0; i < c; i++) {
//             if(startIdx == initStartIdx) startIdx++;
//             initStartIdx = startIdx;
//             currentNum = numberArr[startIdx];
//             for(int target = startIdx; target <= number.length() - c + i ; target++) {
//                 if(numberArr[target] > currentNum) {
//                     currentNum = numberArr[target];
//                     startIdx = target + 1;
//                 }
//             }
//             answer.append(currentNum);
//         }
        
//         return answer.toString();
//     }
// }

class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
