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
Determines the strength of a given hand, returning a numerical value to
represent that strength (higher = stronger)
'''
def hand_strength(suits, vals):
    # Boolean variables to determine hand strength
    flush = True
    straight = True
    trips = False
    pair = False
    twopair = False

    # Checks hand for a flush and/or straight
    for i in suits:
        if i != suits[0]:
            flush = False
    for i in range(1, len(vals)):
        if vals[i] != (vals[i - 1] + 1):
            straight = False
    if straight and flush: # Straight flush is the highest ranked
        return 9
    
    matches = dict()
    for i in vals:
        if i not in matches:
            matches[i] = 1
        else:
            matches[i] += 1
            
    for i in matches:
        if matches[i] == 4:
            return 8 # Four of a kind is the 2nd highest ranked
        elif matches[i] == 3:
            trips = True
        elif matches[i] == 2 and pair:
            twopair = True
        elif matches[i] == 2:
            pair = True
    
    # The remaining hand strengths listed from highest to lowest
    if trips and pair:
        return 7
    if flush:
        return 6
    if straight:
        return 5
    if trips:
        return 4
    if twopair:
        return 3
    if pair:
        return 2
    return 1 # Returns 1 if the hand is a high card only hand
    

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


wins1 = 0
wins2 = 0

with open('poker-hands.txt') as file:
    for line in file:
        # Reads the text file and converts content into easier to work with material 
        line = line.split()
        player1 = line[:5]
        player2 = line[5:]
        values1 = []
        values2 = []
        suits1 = []
        suits2 = []
        for i in player1:
            suits1.append(i[1])
        for i in player2:
            suits2.append(i[1])
        for i in player1:
            values1.append(conversion(i))
        for i in player2:
            values2.append(conversion(i))
        values1.sort()
        values2.sort()
        
        # Processed to determine strength of given hand        
        strength1 = hand_strength(suits1, values1)
        strength2 = hand_strength(suits2, values2)
        
        wins2 += 1
        if strength1 == strength2:
            matches1 = dict()
            matches2 = dict()
            for i in values1:
                if i not in matches1:
                    matches1[i] = 1
                else:
                    matches1[i] += 1
            for i in values2:
                if i not in matches2:
                    matches2[i] = 1
                else:
                    matches2[i] += 1
            matches1 = sorted(matches1.items(), key = lambda x: x[1])
            matches2 = sorted(matches2.items(), key = lambda x: x[1])
            
            if strength1 == 2:
                if matches1[3][0] > matches2[3][0]:
                    wins1 += 1
                    wins2 -= 1
            elif max(values1) > max(values2):
                wins1 += 1
                wins2 -= 1
        elif strength1 > strength2:
            wins1 += 1
            wins2 -= 1
print('Player 1 won ' + str(wins1) + ' times while player 2 won ' + str(wins2) + ' times')            