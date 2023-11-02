def sortColors(nums):
    left, right = 0, len(nums) - 1
    
    while left <= right:
        if nums[left]==1:
            # swap
            nums[left],nums[right] = nums[right], nums[left]
            right -= 1
        else:
            left += 1


# 测试
nums = [1, 0, 1, 0, 1, 0]
sortColors(nums)
print(nums)  # 输出: [0, 0, 0, 1, 1, 1]
