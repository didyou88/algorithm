def solution(num, total):
    # 초기화
    tmp = 0
    s = total
    e = total-num
    
    for i in range(e+1, s+1):
        tmp += i
    
    # 확인
    while tmp != total:
        if tmp > total:
            tmp -= s
            tmp += e
            s -= 1
            e -= 1
        else:
            tmp += s
            tmp -= e
            s += 1
            e += 1
    
    return [i for i in range(e+1, s+1)]
        
    
    
    
    
    