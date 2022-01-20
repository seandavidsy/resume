'''
This program computes the amount of times each player in heads up
five card poker wins against each other
In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:
High Card: Highest value card.
One Pair: Two cards of the same value.
Two Pairs: Two different pairs.
Three of a Kind: Three cards of the same value.
Straight: All cards are consecutive values.
Flush: All cards of the same suit.
Full House: Three of a kind and a pair.
Four of a Kind: Four cards of the same value.
Straight Flush: All cards are consecutive values of same suit.
Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
The cards are valued in the order:
2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
Problem 54 provided by projecteuler.net/problem=54
Author: Sean Sy (1.4.2022)
'''
'''
Helper function to provide face cards a numerical value
'''
def conversion(val):
    if (val[0] == 'T'):
        return 10
    elif (val[0] == 'J'):
        return 11
    elif (val[0] == 'Q'):
        return 12
    elif (val[0] == 'K'):
        return 13
    elif (val[0] == 'A'):
        return 14
    return int(val[0])

'''
Class to track the strength of a player's hand and their kickers
'''
class Player:
    def __init__(self, hand):
        self.strength = 0
        self.firstkicker = 0
        self.secondkicker = 0
        values = []
        suits = []
        for i in hand:
            values.append(conversion(i))
            suits.append(i[1])
        values.sort()
        # Boolean variables to determine hand strength
        quads = False
        flush = True
        straight = True
        trips = False
        pair = False
        twopair = False
    
        # Checks hand for a flush and/or straight
        for i in suits:
            if i != suits[0]:
                flush = False
        for i in range(1, len(values)):
            if values[i] != (values[i - 1] + 1):
                straight = False
        
        matches = {i:values.count(i) for i in values}
        for i in matches:
            if matches[i] == 2 and pair:
                twopair = True
                if i > self.firstkicker:
                    self.secondkicker = self.firstkicker
                    self.firstkicker = i
                else:
                    self.secondkicker = i
            elif matches[i] == 2:
                pair = True
                self.firstkicker = i
                self.secondkicker = i
            if matches[i] == 3:
                trips = True
                self.firstkicker = i
            if matches[i] == 4:
                quads = True
                self.firstkicker = i
        
        # The remaining hand strengths listed from highest to lowest
        if pair:
            self.strength = 2
        if twopair:
            self.strength = 3
        if trips:
            self.strength = 4
        if straight:
            self.strength = 5
            self.firstkicker = values[4]
        if flush:
            self.strength = 6
            self.firstkicker = values[4]
        if trips and pair:
            self.strength = 7
        if quads:
            self.strength = 8
        if straight and flush:
            self.strength = 9
            self.firstkicker = values[4]
        if self.firstkicker == 0:
            self.firstkicker = values[4]
            self.secondkicker = values[3]

wins1 = 0
wins2 = 0
with open('poker-hands.txt') as file:
    for line in file:
        line = line.split() # Converts content into easier to work with material 
        player1 = Player(line[:5])
        player2 = Player(line[5:])
        if player1.strength > player2.strength:
            wins1 += 1
        elif player1.strength < player2.strength:
            wins2 += 1
        elif player1.strength == player2.strength:
            if player1.firstkicker == player2.firstkicker:
                if player1.secondkicker > player2.secondkicker:
                    wins1 += 1
                elif player1.secondkicker < player2.secondkicker:
                    wins2 += 1
            elif player1.firstkicker > player2.firstkicker:
                wins1 += 1
            elif player1.firstkicker < player2.firstkicker:
                wins2 += 1
                
print('Player 1 won ' + str(wins1) + ' times while player 2 won ' + str(wins2) + ' times')   