def solution(record):
    enter_msg = "님이 들어왔습니다."
    leave_msg = "님이 나갔습니다."
    ans = []
    nick_names = {}
    logs = []
    
    for r in record:
        r_split = r.split()
        if r_split[0] == "Leave":
            action, user_id = r_split
        else:
            action, user_id, nick_name = r_split
            nick_names[user_id] = nick_name
        
        if action != "Change":
            logs.append([action, user_id])
    
    for action, user_id in logs:
        if action == "Enter":
            ans.append(nick_names[user_id] + enter_msg)
        else:
            ans.append(nick_names[user_id] + leave_msg)
            
    return ans