import heapq

def solution(n, s, a, b, fares):
    # 초기화
    INF = 1e8
    map = [[] for _ in range(n+1)]
    
    for i, j, fare in fares:
        map[i].append((j, fare))
        map[j].append((i, fare))
    
    # dijkstra
    def dijkstra(start):
        distance = [INF] * (n+1)
        distance[start] = 0
        q = [(0, start)]
        
        while(q):
            cur_dist, cur_node = heapq.heappop(q)
            
            if distance[cur_node] < cur_dist:
                continue
            
            for next_node, next_dist in map[cur_node]:
                tmp_dist = cur_dist + next_dist
                if distance[next_node] > tmp_dist:
                    distance[next_node] = tmp_dist
                    heapq.heappush(q, (tmp_dist, next_node))
        
        return distance
                
    # 모든 정점에 대한 최단 거리 구하기
    D = [0] + [dijkstra(i) for i in range(1, n+1)]
    
    # min 조합 찾기
    min_fare = INF
    for i in range(1, n+1):
        min_fare = min(min_fare, D[s][i] + D[i][a] + D[i][b])
    
    return min_fare