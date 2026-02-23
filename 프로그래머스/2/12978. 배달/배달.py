import heapq

def solution(N, road, K):
    # 초기화
    ans = 0
    INF = 1e8
    map = [[] for _ in range(N+1)] # 연결 리스트
    
    for n1, n2, d in road:
        map[n1].append((d, n2))
        map[n2].append((d, n1))
    
    # dijkstra 
    def dijkstra(start):
        q = []
        distance = [INF for _ in range(N+1)]
        heapq.heappush(q, (0, start))
        distance[start] = 0
        
        while q:
            dist, node = heapq.heappop(q)
            
            for next_dist, next_node in map[node]:
                sum_dist = dist + next_dist
                if sum_dist >= distance[next_node]:
                    continue
                heapq.heappush(q, (sum_dist, next_node))
                distance[next_node] = sum_dist
            
        return distance

    # deliver
    min_dist = dijkstra(1)
    
    # deliver is possible?
    for d in min_dist:
        if d <= K:
            ans += 1

    return ans