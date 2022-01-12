"""
@date: 9/25/2020
@author: Sean Sy
@PID: 906311775
@assignment: HW5
@note: Do NOT alter the function headers that are well documented
"""


def max_difference(values):
    
    maxdif = values[0] - values[1]
    for i in range(0, len(values)):
        for x in range(0, len(values)):
            if (values[i] - values[x] > max):
                maxdif = values[i] - values[x]
    return maxdif
    """ Efficiently finds the largest difference between any two elements in a list
    @param values: a list of numbers
    @return number for the largest difference between elements
    """


def sort_bivalued(values):
    """Efficiently sort a list of binary values
    @param values: a list of binary digits (0 or 1)
    @return: a list of binary numbers in ascending sort order
    """

print ("Hello World")