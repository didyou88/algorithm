from collections import deque

a, k = map(int, input().split(' '))

q = deque([a])
v = {a:0}

while q:
    tmp = q.popleft()
    # 종료 조건 
    if tmp == k:
        break
    for x in [tmp+1, tmp*2]:
        if x in v or x > k:
            continue
        v[x] = v[tmp] + 1
        q.append(x)

print(v[k]) 
