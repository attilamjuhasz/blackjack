import random

play = False

money = 0
bet = 0

print("Welcome to Attila's Blackjack")
play = input("Do you want to play (y or n): ")
if play == "y":
    play = True
    money = int(input("How much do you want to put in?: "))
else:
    play = False

def getCards():
    one = random.randint(2, 14)
    two = random.randint(2, 14)
    return one, two

def getOneCard():
    one = random.randint(2, 14)
    return one

def highCard(card):
    if card == 11:
        return "Jack"
    elif card == 12:
        return "Queen"
    elif card == 13:
        return "King"
    elif card == 14:
        return "Ace"
    else:
        return card


while play:
    bet = int(input("How much do you want to bet?: "))
    while bet <= 0 or money-bet < 0:
        bet = int(input("How much do you want to bet?: "))
    blackJack = False
    print("Shuffling deck...")

    valOne, valTwo = getCards()
    cardOne = highCard(valOne)
    cardTwo = highCard(valTwo)

    if valOne > 10 and valOne != 14:
        valOne = 10
    elif valOne == 14:
        valOne = 11
    
    if valTwo > 10 and valTwo != 14:
        valTwo = 10
    elif valTwo == 14 and valOne == 11:
        valTwo = 1
    elif valTwo == 14:
        valTwo = 11
    
    total = valOne + valTwo

    dValOne, dValTwo = getCards()
    dCardOne = highCard(dValOne)
    dCardTwo = highCard(dValTwo)

    if dValOne > 10 and dValOne != 14:
        dValOne = 10
    elif dValOne == 14:
        valOne = 11
    if dValTwo > 10 and dValTwo != 14:
        dValTwo = 10
    elif dValTwo == 14 and dValOne == 11:
        valTwo = 1
    elif dValTwo == 14:
        valTwo = 11
    dTotal = dValOne + dValTwo

    print()
    print(f"Dealer has a {dCardOne}")
    print("You have a " + str(cardOne) + " and a " + str(cardTwo))
    if total == 21:
        "Blackjack!"
        blackJack = True

    decision = True
    bust = False
    while decision and not blackJack:
        type = input("Hit, Stand, or Double Down (h, s, d): ")

        if type == "s":
            decision = False
        
        elif type == "h":
            newVal = getOneCard()
            newCard = highCard(newVal)

            if newVal > 10 and newVal != 14:
                newVal = 10
            elif newVal == 14:
                newVal = 11
            print("You have " + str(total) + " and a " + str(newCard))
            total += newVal
            if total > 21:
                print("Bust!")
                money -= bet
                bust = True
                decision = False
            elif total == 21:
                blackJack = True
                print("Blackjack!")
                decision = False
        elif type == "d":
            bet *= 2
            newVal = getOneCard()
            newCard = highCard(newVal)

            if newVal > 10 and newVal !=14:
                newVal = 10
            elif newVal == 14 and total < 11:
                newVal = 11
            elif newVal == 14:
                newVal = 1
            print("You have " + str(total) + " and a " + str(newCard))
            total += newVal
            if total > 21:
                print("Bust!")
                money -= bet
                bust = True
                decision = False
            elif total == 21:
                blackJack = True
                print("Blackjack!")
                decision = False
            else:
                decision = False

    print(f"Dealer has a {dCardOne} and {dCardTwo}")

    temp = dTotal
    if bust == False:
        while temp < 17:
            dNewVal = getOneCard()
            dNewCard = highCard(dNewVal)

            if dNewVal > 10 and dNewVal != 14:
                dNewVal = 10
            elif dNewVal == 14:
                dNewVal = 11
            print("Dealer has a " + str(dTotal) + " and a " + str(dNewCard))
            dTotal += dNewVal
            if dTotal > 21:
                print("Dealer Bust!")
            elif total == 21:
                blackJack = True
                print("Dealer got Blackjack!")
            temp = dTotal
    
    if total > dTotal:
        money +=bet
    elif total < dTotal:
        money -=bet
            

    print(f"Your money: {money}")