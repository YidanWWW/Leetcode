def removeDigit(number: str, digit: str) -> str:
    result = int(number)
    for i in range(len(number)):
        if number[i] == digit:
            current_number = int(number[:i] + number[i+1:])
            result = max(result, current_number)
    return str(result)

res = removeDigit("-585595", "5")
print(res)

