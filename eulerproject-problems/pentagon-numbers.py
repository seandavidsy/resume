def pent(n):
    return n * (3 * n - 1) / 2

pent_list = []
for i in range(1, 3000):
    pent_list.append(pent(i))
for i in pent_list:
    for j in pent_list:
        if i + j in pent_list and abs(i - j) in pent_list:
            print(i, j)