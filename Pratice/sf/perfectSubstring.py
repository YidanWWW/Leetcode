def perfectSubstring(s, k):
    count = 0

    for start in range(len(s)):
        digit_count = [0] * 10  # 用于存储子串中每个数字的出现次数
        unique_digits = 0  # 记录子串中不同数字的数量

        for end in range(start, len(s)):
            # 更新数字出现次数
            digit = int(s[end])
            digit_count[digit] += 1

            # 如果是第一次出现该数字，增加unique_digits
            if digit_count[digit] == 1:
                unique_digits += 1

            # 如果所有数字出现次数都等于k，增加计数器
            if all(count == k for count in digit_count):
                count += 1

            # 如果已经有k个不同的数字，不需要继续往右扩展子串
            if unique_digits == k:
                break

    return count

# 示例用法
s = "1102021222"
k = 2
result = perfectSubstring(s, k)
print("Number of perfect substrings:", result)