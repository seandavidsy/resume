'''
Project 5 - Library - Fall 2021 
Author: Your name and VT pid here

Describe the contents of this file here.

I have neither given or received unauthorized assistance on this assignment.
Signed:  Type your name here
'''
from library import Library

lib = Library()

with open("library_data.txt") as file:
    for line in file:
        line = line.strip().split(", ")
        lib.add_book(line[0], line[1])
file.close()

print("The current contents of the library are:\n")
print(lib.__str__())
print("Enter new books to add to the library.\n")

title = ""

file = open("library_data.txt", "w")
while (title != "q"):
    title = input("Title ('q' to quit): ")
    if title != "q":
        author = input("Author: ")
        lib.add_book(title, author)
        file.write(title + ", " + author)
file.close()

print("\nNow the contents of the library are:\n")
print(lib.__str__())
print("Library data saved to file.")