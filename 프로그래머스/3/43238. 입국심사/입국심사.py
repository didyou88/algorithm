def solution(n, times):
    # 초기화 - 리스트는 정렬되어야 한다
    ans = 0
    times.sort()
    s = 0
    e = times[len(times)-1] * n
    mid = 0
    
    while s <= e:
        mid = (s+e) // 2
        checked_num = 0
        
        # mid 시간 동안 몇 명이나 확인할 수 있는지 확인
        for time in times:
            checked_num += (mid // time)
        
        print(mid, checked_num, n)
        
        if checked_num < n:
            s = mid + 1
        else:
            e = mid - 1
            ans = mid

    return ans

    
    
    
    
#     times.sort()
#     ans = 0
#     left = 0
#     right = n * times[len(times)-1]
#     mid = 0
    
#     while left <= right:
#         mid = (left + right) // 2
#         checked_num = 0
        
#         for time in times:
#             checked_num += (mid // time)
            
#         print(mid, checked_num)
        
#         if checked_num < n:
#             left = mid + 1
#         else:
#             right = mid - 1
#             ans = mid
    
#     return ans