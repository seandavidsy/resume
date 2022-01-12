import urllib.request
import re

def instructor_lectures(department, instructor):
    '''
    Begins by opening Lou's List for the given department and then goes line by
    line checking if the given instructor teaches the course of that line as a
    lecture. If yes, then the line is stripped and split by the | character and
    the course title is added to class_list if not already added. class_list is
    returned at the end of function.
    '''
    class_list = []
    url = "http://cs1110.cs.virginia.edu/files/louslist/" + department
    file = urllib.request.urlopen(url)
    
    for line in file:
        line = line.decode('utf-8')
        
        if 'Lecture' in line and instructor in line:
            fields = line.strip().split('|')
            class_title = fields[3]
            if not class_title in class_list:
                class_list.append(class_title)
                
    return class_list


def compatible_classes(first_class, second_class, needs_open_space = False):
    '''
    Starts by checking if the two given classes are the same, if they are then
    False is returned. Creates the first file using department of first_class
    and then a second file using department of second_class. Then goes through
    the first file to find the course info of first_class and determine if the
    course has space if needs_open_space parameter is True. Then does the same
    process for second file. Finally, checks to see if first_class starts or
    ends during second_class, and if so, then checks if they have class on the
    same day and returns False if they do. If not, returns True.
    '''
    if first_class == second_class:
        return False
    
    first_start = 0
    first_end = 0
    second_start = 1
    second_end = 1
    
    first_department = re.search('[A-Z]*', first_class)
    url = "http://cs1110.cs.virginia.edu/files/louslist/" + first_department.group(0)
    first_file = urllib.request.urlopen(url)
    second_department = re.search('[A-Z]*', second_class)
    url = "http://cs1110.cs.virginia.edu/files/louslist/" + second_department.group(0)
    second_file = urllib.request.urlopen(url)
    
    
    for line in first_file:
        line = line.decode('utf-8')
        fields = line.strip().split('|')
        course = fields[0] + ' ' + fields[1] + '-' + fields[2]

        if first_class == course:
            first_days = [fields[7], fields[8], fields[9], fields[10], fields[11]]
            first_start = int(fields[12])
            first_end = int(fields[13])
            if needs_open_space:
                if int(fields[15]) >= int(fields[16]):
                    return False
    
    for line in second_file:
        line = line.decode('utf-8')
        fields = line.strip().split('|')
        course = fields[0] + ' ' + fields[1] + '-' + fields[2]
        
        if second_class == course:
            second_days = [fields[7], fields[8], fields[9], fields[10], fields[11]]
            second_start = int(fields[12])
            second_end = int(fields[13])
            if needs_open_space:
                if int(fields[15]) >= int(fields[16]):
                    return False

    if first_start in range(second_start, second_end + 1) or first_end in range(second_start, second_end + 1):
        for i in range(0, len(first_days)):
            if first_days[i] and second_days[i]:
                return False

    return True
   
    
print(instructor_lectures('STS', 'Kathryn Neeley'))
print(instructor_lectures('STS', 'Raymond Pettit')) 
print('-' * 50)
print(compatible_classes('CS 1110-001', 'CS 2150-001'))
print(compatible_classes('CS 1110-001', 'CS 2110-001', True))
print(compatible_classes('CS 1110-001', 'CS 1110-001'))

current = ''
print('Would you like to compare class compatability, check lectures for an instructor, or quit the program?')
while current != 'q*':
    current = input('Enter "1" to compare, "2" to check lectures, or "q*" to quit: ')
    if current == '1':
        dept = input("Enter the professor's department: ")
        prof = input("Enter the professor's name: ")
        print(instructor_lectures(dept, prof))
    elif current == '2':
        first = input("Enter the first class: ")
        second = input("Enter the second class: ")
        if compatible_classes(first, second):
            print("The classes are compatible!")
        else:
            print("The classes are incompatible.")
    else:
        print('Error, invalid input, please try again.')
        