def numberOfSteps(num: str) -> int:
    if num.count('0') == len(num):
        return 0

    # find the first 1
    p = -1
    for i in range(len(num)):
        if num[i] == '1':
            p = i
            break
    return len(num) - p - 1 + num.count('1')

res = numberOfSteps("0011001")
print(res)
