
# Online Python - IDE, Editor, Compiler, Interpreter
from random import randint

def pick_winning_numbers(start, end, count):
    winning_numbers = ["none"] * count
    for i in range(0, count):
        winning_numbers[i] = randint(start, end)
    return winning_numbers
    
def pick_superball(start, end):
    superball = randint(start, end)
    return superball
    
def convert_list_to_integers(entry):
    for i in range(0, len(entry)):
        entry[i] = int(entry[i])
    return entry
    
def count_matches(numbers, entry):
    count = 0
    for i in range(0, len(numbers)):
        if (numbers[i] == entry[i]):
            count += 1
    return count

def main():
    numbers = pick_winning_numbers(0, 9, 4)
    superball = pick_superball(0, 9)
    
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
    print('\nNumber of entries:', entry_count)
    print('Number of entries that used superball:', superball_count)
    print('Number of entries that matched 3 numbers:', count_3)
    print('Number of entries that matched 4 numbers:', count_4)
    
if __name__ == "__main__":
    main()