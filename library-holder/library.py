'''
Project 5 - Library - Fall 2021 
Author: Your name and VT pid here

Describe the contents of this file here.

I have neither given or received unauthorized assistance on this assignment.
Signed:  Type your name here
'''
from book import Book

class Library:
    
    def __init__(self):
        self.collection = []
        
    def add_book(self, title, author):
        length = len(self.collection)
        
        if length == 0 or self.collection[length - 1].title < title:
            self.collection.append(Book(title, author))
        else:
            pos = 0
            for i in range(0, length):
                if title > self.collection[i].title:
                    pos = self.collection.index(self.collection[i]) + 1
            self.collection.insert(pos, Book(title, author))

    def size(self):
        return len(self.collection)

    def is_empty(self):
        return len(self.collection) == 0

    def get_book_list(self):
        return self.collection

    def __str__(self):
        lib_string = ""
        
        for i in range(0, len(self.collection)):
            lib_string = lib_string + self.collection[i].__str__() + "\n"
        
        return(lib_string)
