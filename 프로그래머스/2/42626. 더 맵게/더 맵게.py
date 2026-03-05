import heapq

def solution(scoville, K):
    ans = 0
    heapq.heapify(scoville)
    
    while len(scoville) > 1:
        s1 = heapq.heappop(scoville)
        s2 = heapq.heappop(scoville)
        
        if s1 >= K:
            break
        
        heapq.heappush(scoville, s1 + s2 * 2)
        ans += 1
    
    if len(scoville) == 1:
        s = heapq.heappop(scoville)
        if s < K:
            return -1
    
    return ans
    



# def solution(scoville, K):
#     ans = 0
#     heapq.heapify(scoville)
    
#     while(scoville[0] < K):
#         if len(scoville) < 2 :
#             return -1
        
#         s1 = heapq.heappop(scoville)
#         s2 = heapq.heappop(scoville)
#         newScoville = s1 + (s2 * 2)
#         heapq.heappush(scoville, newScoville)
#         ans += 1
    
#     return ans