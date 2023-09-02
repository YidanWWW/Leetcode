def solve(k, cost, c1, c2):
    # Separate servers into 3 lists
    v1, v2, v3 = [], [], []

    for i in range(len(c1)):
        if c1[i] == 1 and c2[i] == 1:
            v3.append(cost[i])
        elif c1[i] == 1:
            v1.append(cost[i])
        elif c2[i] == 1:
            v2.append(cost[i])

    v1.sort()
    v2.sort()
    v3.sort()

    ans = 0
    i, j = 0, 0
    while k > 0:
        if i < len(v3) and j < len(v1) and v3[i] <= v1[j] + v2[j]:
            # Choose a common server
            ans += v3[i]
            i += 1
        elif j < len(v1):
            ans += v1[j] + v2[j]
            j += 1
        else:
            return -1
        k -= 1

    return ans

def main():
    min_compatible = 2
    cost = [2, 4, 6, 5]
    compatible1 = [1, 1, 1, 0]
    compatible2 = [0, 0, 1, 1]

    print(solve(min_compatible, cost, compatible1, compatible2))

if __name__ == "__main__":
    main()
