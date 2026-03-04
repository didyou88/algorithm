from bisect import bisect_left

def solution(info, query):
    # 초기화
    ans = []
    d = {}
    
    # 초기화 - dict key 조건을 이미 알고있음으로 미리 키를 만들어 둔다
    langs = ['', 'cpp', 'java', 'python']
    poses = ['', 'backend', 'frontend']
    levels = ['', 'junior', 'senior']
    foods = ['', 'chicken', 'pizza']
    
    for lan in langs:
        for pos in poses:
            for level in levels:
                for food in foods:
                    key_str = lan + pos + level + food
                    d[key_str] = list()
    
    # dict 채우기
    for i in range(len(info)):
        lang, pos, level, food, score = info[i].split()
        score = int(score)
        
        for la in [lang, '']:
            for p in [pos, '']:
                for le in [level, '']:
                    for f in [food, '']:
                        key_str = la + p + le + f
                        d[key_str].append(score)
    
    # dict sort
    for key, val in d.items():
        if len(val) > 1:
            d[key].sort()
    
    # 쿼리 탐색
    for q in query:
        # 쿼리 정리
        ql = q.split()
        score = int(ql.pop())
        key_str = ""
        for qq in ql:
            if qq != 'and' and qq != '-':
                key_str += qq
        
        # 점수 조건 만족하는 인원수 카운팅
        idx = bisect_left(d[key_str], score)
        ans.append(len(d[key_str]) - idx)
        
    return ans