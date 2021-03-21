import random
import sys
import logging
import logging.config
from datetime import date
A = 0
M = 0
O = 0
print('Welcome to fruitbasket')
print ("RULES OF THE GAME")
print(' To win you must have a total of sixty (60) fruits in your basket.\n '
      'A message will be displayed letting you know you have won.\n '
      'All three fruits must have a minimum of fifteen(15) and maximum of twenty-two '
      '(22) fruits  If any fruit count goes above twenty-two (22).\n '
      'Then a message will be displayed that you have lost and the game will end.\n '
      ' If the total fruit count goes above sixty (60). Then a message will be displayed '
      'that you have lost and the game will end. \n If you reach a total of sixty (60) '
      'fruits in the basket and any of the individual fruits are below fifteen (15).\n '
      'Then a message will be displayed that you have lost and the game will end. \n')


f =input('Enter first name\n')

l =input('Enter last name\n')

age = input('Enter age\n')
"""This starts the game"""
def game(f, l , a):
    logit("Game started\n")
    """shows the home screen of the game and keep tracks of points"""
    def DisplayGameScreen (A, M, O):
        print('Welcome to fruitbasket', f, l)
        print('Apple',    'Mangoes',   'Oranges')
        print("%2d          %2d          %2d " % (A, M, O))
        print("total fruits: %2d" % (A + M + O ))
    DisplayGameScreen(0, 0, 0)
    entry= input('Please pick a fruit A or M or O and E is to exit\n')
    """tells you if you win or fail at the game"""
    def gametotal(A, M ,O):
        if A > 22 or M > 22 or O > 22:
            logit("One of the fruits is greater than 22. You LOST the game\n")
            gamefail()
        if A + M + O == 60:
            logit("YOU HAVE WON THE GAME\n")
            gamewon()
        if A + M + O > 60:
            logit("Total fruits is greater than 60. You LOST the game\n")
            gamefail()
    """ statement will tell went you won the game, restarts and if you want to end the game"""
    def gamewon():
        logit("game has ended\n")
        restart = input(f + " " + l + " Age: " + a + "\n You Won the game, press K to play again!\n""press E to exit\n")
        if restart == 'K':
            global A, M, O
            A = 0
            M = 0
            O = 0
            game(f, l, a)
        if restart =='E':
            sys.exit()
    """ statement will tell went you fail the game, restarts and if you want to end the game"""
    def gamefail():
        logit("game has ended\n")
        restart = input(f + " " + l + " Age: " + a + "\n Mission failed better luck next time, " "press K to try again!\n""press E to exit\n")
        if restart == 'K':
            global A, M, O
            A = 0
            M = 0
            O = 0
            game(f, l, a)
        if restart =='E':
            sys.exit()
    """"" picks the fruit you want and give a random number between 1 and 6"""
    def get_entry (entry):
        global A, M, O
        while entry != "E":
            num = random.randint(1, 6)
            v = input('do you want to roll the dice(Y/N)\n')
            if v == "Y":
                if entry == "A":
                    logit("Apples increased by num %d\n" %(num))
                    A += num
                    DisplayGameScreen(A, M, O )
                elif entry == "M":
                    logit("Mangoes increased by num %d\n" %(num))
                    M += num
                    DisplayGameScreen(A, M, O)
                elif entry == "O":
                    logit("Oranges increased by num %d\n" %(num))
                    O += num
                    DisplayGameScreen(A, M, O)
            if gametotal(A, M, O):
                gamewon()
            if gametotal(A, M, O):
                gamefail()
            entry = input('Please pick a fruit A or M or O and E is to exit\n')
        logit("game has ended\n")
        sys.exit()
    get_entry(entry)
def logit(message):
    f = open("gamelog.txt", "a+")
    f.write(message)
    f.close()
if int(age) >= 18:
    game(f, l, age)
else:
    print("YOU ARE TOO YOUNG!!!!")






