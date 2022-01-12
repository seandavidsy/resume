'''
Project 5 - Library - Fall 2021 
Author: Your name and VT pid here

Describe the contents of this file here.

I have neither given or received unauthorized assistance on this assignment.
Signed:  Type your name here
'''

class Book:
    
    def __init__(self, title, author):
        self.title = title
        self.author = author

    def __str__(self):
        book_string = self.title + " by " + self.author
        return book_string