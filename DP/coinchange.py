def coinChange(coins, amount):
    dp = [None] * (amount + 1)
    dp[0] = []

    for i in range(1, amount + 1):
        for coin in coins:
            if i - coin >= 0 and dp[i - coin] is not None:
                if dp[i] is None or len(dp[i - coin]) + 1 < len(dp[i]):
                    dp[i] = dp[i - coin] + [coin]

    return dp[amount] if dp[amount] is not None else -1

# Example usage
coins = [1, 2, 5]
amount = 11
result = coinChange(coins, amount)
print(result)  # Output: [5, 5, 1]
