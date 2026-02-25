def solution(n, costs):
    # 초기화
    ans = 0
    parents = [i for i in range(n)]
    
    costs.sort(key=lambda x:x[2])
    
    # 부모 탐색 함수
    def findParent(n):
        if parents[n] == n:
            return n
        else:
            return findParent(parents[n])
    
    # 부모 연결 함수
    def connectParent(n1, n2):
        n1_parent = findParent(n1)
        n2_parent = findParent(n2)
    
        parents[n1_parent] = n2_parent
    
    # 탐색
    for n1, n2, cost in costs:
        if findParent(n1) != findParent(n2):
            connectParent(n1, n2)
            ans += cost
        
    return ans
    