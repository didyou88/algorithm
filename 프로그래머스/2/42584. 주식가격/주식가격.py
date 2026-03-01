def solution(prices):
    stk = []
    ans = [0] * len(prices)

    # 돌기
    for i in range(len(prices)):
        # pop 하는 경우
        while len(stk) > 0 and prices[stk[(len(stk)-1)]] > prices[i]:
            idx = stk.pop()
            ans[idx] = i - idx
        stk.append(i)
    
    # 다 뱉기
    while stk:
        idx = stk.pop()
        ans[idx] = len(prices) - 1 - idx
    
    return ans
    