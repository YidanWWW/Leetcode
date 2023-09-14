def rodCutting(rod_lengths):
    result = []  # 用于存储每轮操作后的 rods 数组
    
    while len(rod_lengths) > 0:
        # 记录当前轮的 rods 数量
        result.append(len(rod_lengths))
        
        # 找到最短的长度
        shortest_length = min(rod_lengths)
        
        # 移除最短长度的 rods 和相应的 offcuts
        rod_lengths = [rod - shortest_length for rod in rod_lengths if rod > shortest_length]
        #print(rod_lengths)
        
    return result

# 示例用法
rod_lengths = [1,1,3,4]
result_array = rodCutting(rod_lengths)
print(result_array)  # 输出每轮操作后的 rods 数组