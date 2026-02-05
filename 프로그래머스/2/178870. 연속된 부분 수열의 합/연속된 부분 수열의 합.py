def solution(sequence, k):
    answer = []
    min_len = len(sequence) + 1
    s_idx = 0
    e_idx = 0
    s = sequence[0]
    
    while True:        
        # k와 같은지 확인
        if s == k:
            if e_idx - s_idx + 1 < min_len:
                answer.clear()
                answer.append(s_idx)
                answer.append(e_idx)
                min_len = e_idx - s_idx + 1
            else:
                if s_idx <= e_idx:
                    s -= sequence[s_idx]
                    s_idx += 1
                else:
                    break
        
        elif s < k:
            if e_idx + 1 < len(sequence):
                e_idx += 1
                s += sequence[e_idx]
            else:
                break
        
        else:
            if s_idx <= e_idx:
                s -= sequence[s_idx]
                s_idx += 1
            else:
                break
            
    return answer