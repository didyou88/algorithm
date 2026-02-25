# Baekjoon 2252. 줄 세우기

from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

graph = [[] for _ in range(n+1)]
indegree = [0] * (n+1)
q = deque([])
result = []

for _ in range(m):
    prev, post = map(int, input().split())
    graph[prev].append(post)
    indegree[post] += 1

# indegree가 0인 원소 모두 큐에 넣기
for i in range(1, n+1):
    if indegree[i] == 0:
        q.append(i)

# 탐색
while len(q) > 0:
    # 결과에 삽입
    prev = q.popleft()
    result.append(prev)

    # post node 탐색
    for post in graph[prev]:
        indegree[post] -= 1
        if indegree[post] == 0:
            q.append(post)

# 결과
print(' '.join(map(str, result)))