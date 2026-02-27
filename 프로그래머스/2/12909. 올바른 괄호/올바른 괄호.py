def solution(s):
    stk = []
    
    for p in s:
        if p == "(":
            stk.append(p)
        else:
            if len(stk) > 0:
                stk.pop()
            else:
                return False
    
    if len(stk) > 0:
        return False
    else:
        return True
    
    
    
    
    
    
    
    
    
    
    
#     stk = []
#     for i in s:
#         if(i == "("):
#             stk.append(i)
#         else: 
#             if(len(stk)<1):
#                 return False
#             stk.pop()
    
#     if(len(stk) > 0):
#         return False
#     return True