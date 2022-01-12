'''
This program computes the amount of different ways to
write a number, n, as a sum

For example:
Five can be written as a sum in exactly six different ways:
4 + 1
3 + 2
3 + 1 + 1
2 + 2 + 1
2 + 1 + 1 + 1
1 + 1 + 1 + 1 + 1


Problem 76 provided by projecteuler.net/problem=76

Author: Sean Sy (1.4.2022)
'''

print("What number you would you like the amount of different summations for?")
num = int(input())
ways = [0] * (num + 1)
ways[0] = 1
for i in range(1, num):
    for j in range(i, num + 1):
        ways[j] += ways[j - i]

print(ways[num])