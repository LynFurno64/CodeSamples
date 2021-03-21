import random           # generate random integer values
import logging          #imports logging library

#Class for the Players Name & Age
class Player:
    def __init__(self,name,age):
        self.name = name
        self.age = age
Player.name = input('Please enter your name: ')
Player.age = int(input('Please enter your age: '))

#Class for the Fruits
class Fruit:
    def __init__(self,name,score = 0):
        self.name = name
        self.score = score
        self.letter = name[:1]
A = Fruit('Apples')
M = Fruit('Mangoes')
O = Fruit('Oranges')

Total = A.score + M.score + O.score
#The Start screen for the game
def DisplayGameScreen():
    print('\nWelcome to your FruitBasket, {}'.format(Player.name).center(50))
    print('{}     {}     {}'.format(A.name, M.name, O.name).center(50))
    print('{}          {}            {}'.format(A.score, M.score, O.score).center(50))
    print('Total Fruits: {}'.format(Total).center(50))
    print('Please pick a fruit (A, M or O)....E to exit'.center(50))


#The Function which allows the Game to work
def getEntry():
    if Player.age < 17:         #A Condition to play the game
      print("\nCome back in {} years!!!\n".format(18-Player.age).center(50))
      return
    else:
        DisplayGameScreen()
        #Logit("Game has started")
        Choice = input('\nWhich fruit would you like? \nPlease use CAPS: ')
        YesORNo = input('\nAre you sure? (Y/N): ')
        if YesORNo == "Y":
            global Total
            value = random.choice([1, 2, 3, 4, 5, 6])       # generate random integers which will be added to the Fruits
            while Choice != 'E':
                if Choice == A.letter:
                    #Logit("Apples has increase by {}".format(value))
                    A.score += value
                    Total = A.score + M.score + O.score
                    return getEntry()
                elif Choice == M.letter:
                    #Logit("Mangoes has increase by {}".format(value))
                    M.score += value
                    Total = A.score + M.score + O.score
                    return getEntry()
                elif Choice == O.letter:
                    #Logit("Oranges has increase by {}".format(value))
                    O.score += value
                    Total = A.score + M.score + O.score
                    return getEntry()
            print('\nBye Bye')
        else:
            print('\nOk, reroll time!')
            return getEntry()


def rules():
    getEntry()
    if Total == 60:
        print('\nCONGRATS You win')
        return

    elif Total > 60:
        print('\nYou lost the gmae :(')
        return

    for i2 in [A.score, M.score, O.score]:
        if i2 > 22:
            print('\nYou lost the gmae :(')
        return







#def Logit(x):
    #logging.basicConfig(filename = "GameLog.txt", filemode = 'w', format = '%(asctime)s---%(message)s', datefmt = "%a %b %d %H:%M:%S %Y")
    #logging.warning(x)

getEntry()
rules()