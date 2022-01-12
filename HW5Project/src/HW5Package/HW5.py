"""
@date: 9/25/2020
@author: Sean Sy
@PID: 906311775
@assignment: HW5
@note: Do NOT alter the function headers that are well documented
"""


def max_difference(aList):
    
    maxdif = aList[1] - aList[0]
    
    for i in range (0, len(aList)):
        for x in range (0, len(aList)):
            if (aList[x] - aList[i] > maxdif):
                maxdif = aList[x] - aList[i]
                
    return maxdif

    """ Efficiently finds the largest difference between any two elements in a list
    @param values: a list of numbers
    @return number for the largest difference between elements
    """


def sort_bivalued(values):
    
    countone = 1
    
    for i in range (0, len(values)):
        if (values[i] == 1):
            countone += 1
            values[i] = 0
        
    for i in range (countone, len(values)):
        values[i] = 1
    
    return values

    """Efficiently sort a list of binary values
    @param values: a list of binary digits (0 or 1)
    @return: a list of binary numbers in ascending sort order
    """
    
    
for i in range (1, 100):
    if (i % 3 == 0):
        print("foo")
    if (i % 5 == 0):
        print("bar")
    if (i % 3 != 0 and i % 5 != 0):
        print(i)

values = [1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1]
print(sort_bivalued(values))