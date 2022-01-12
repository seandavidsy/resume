from random import randint
'''
Returns the list of randomly determined winning numbers. Accepts 3 arguements in the order of min and max values of the range and than a count of values
From this results in an inclusive integer sample from the min to max without any duplicates.
'''
def pick_winning_numbers(start, end, count):
    winning_numbers = ["none"] * count
    for i in range(0, count):
        winning_numbers[i] = randint(start, end)
    return winning_numbers
'''    
Picks and retursn the superball value (one integer). The superball value is choosen at random from its specified range by its arguements
(min and max, inclusive)

'''
def pick_superball(start, end):
    superball = randint(start, end)
    return superball

'''
This function reads a list of strings and returns a list of integers.  Each string in the argument is a valid integer.
Converts the value of customer entries into numbers. 

'''
def convert_list_to_integers(entry):
    for i in range(0, len(entry)):
        entry[i] = int(entry[i])
    return entry

'''
Accepts two list of integers as aruguments. In the first arguement it has the list of today's winning number and the second arugement is the
the list represting the customer's entries. This function will determine how many entry values are found in the winning numbers.  However, this
function does not take the superball value into account.
'''
def count_matches(numbers, entry):
    count = 0
    for i in range(0, len(numbers)):
        if (entry[i] in numbers):
            count += 1
    return count

'''
The main method incorporates the four functions defined above to count the matches between the randomly generated winning numbers and superball and
the entries text files. It uses a with and for loop to read the text files line by line. 
'''
def main():
    print('Pythonic Pick 4 Lottery Results')
    print()
    numbers = pick_winning_numbers(1, 9, 4)
    superball = pick_superball(1, 9)
    print("Today's winning numbers:", numbers)
    print("Today's superball:", superball)
    entry_count = 0
    superball_count = 0
    count_3 = 0
    count_4 = 0
    with open('entries.txt') as file:
        for line in file:
            entry_count += 1
            entry = convert_list_to_integers([line[0], line[2], line[4], line[6]])
            count = count_matches(numbers, entry)
            if ('sb' in line):
                superball_count += 1
                if (superball in entry and superball in numbers):
                    count += 1
            if (count == 3):
                count_3 += 1
            if (count == 4):
                count_4 += 1
    print()
    print('Number of entries:', entry_count)
    print('Number of entries that used superball:', superball_count)
    print('Number of entries that matched 3 numbers:', count_3)
    print('Number of entries that matched 4 numbers:', count_4)
    
if __name__ == "__main__":
    main()