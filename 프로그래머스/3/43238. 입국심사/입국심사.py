def solution(n, times):
    times.sort()
    ans = 0
    left = 0
    right = n * times[len(times)-1]
    mid = 0
    
    while left <= right:
        mid = (left + right) // 2
        checked_num = 0
        
        for time in times:
            checked_num += (mid // time)
            
        print(mid, checked_num)
        
        if checked_num < n:
            left = mid + 1
        else:
            right = mid - 1
            ans = mid
    
    return ans