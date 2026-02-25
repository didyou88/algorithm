# Baekjoon 1647. 도시 분할 계획

import heapq
import sys
input = sys.stdin.readline

# 초기화
parents = []
costs = []
total_cost = 0
last_cost = 0
connect_node_num = 1

# 입력값
n, m = map(int, input().split())
parents = [i for i in range(n+1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    heapq.heappush(costs, (c, a, b))

# find parent func
def find(n) -> int:
    if parents[n] == n:
        return n
    else:
        return find(parents[n])

# connect parent func
def connect(n1, n2):
    n1_parent = find(n1)
    n2_parent = find(n2)
    if n1_parent < n2_parent:
        parents[n2_parent] = n1_parent
    else:
        parents[n1_parent] = n2_parent

# 최소 비용 탐색
while costs:
    if connect_node_num == n:
        break

    c, a, b = heapq.heappop(costs)

    if find(a) != find(b):
        connect(a, b)
        total_cost += c
        last_cost = c
        connect_node_num += 1

print(total_cost - last_cost)
