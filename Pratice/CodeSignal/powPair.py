def solution(arr):
    sumOfThePowers = sum([10 ** len(str(el)) for el in arr])
    return sum(arr) * len(arr) + sum([el * sumOfThePowers for el in arr])
