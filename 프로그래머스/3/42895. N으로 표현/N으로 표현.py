def solution(N, number):
    s = [set() for _ in range(9)]
    
    # 초기화
    for i, x in enumerate(s, start = 0):
        if i > 0:
            num = int(str(N) * i)
            if num == number:
                return i
            x.add(num)
    
    # 만들 수 있는 숫자
    for target in range(1, 9):
        for i in range(1, target):
            s1 = s[i]
            s2 = s[target-i]
            
            for val1 in s1:
                for val2 in s2:
                    s[target].add(val1 + val2)
                    s[target].add(val1 - val2)
                    s[target].add(val1 * val2)
                    if val2 != 0:
                        s[target].add(val1 // val2)
                    
        if number in s[target]:
            return target
    
    return -1
            
        
