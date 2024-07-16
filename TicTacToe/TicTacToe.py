same = [1,2,3,4,5,6,7,8,9]
def user1(): 
    print("Users one's turn to input now.")
    posi = eval(input("Select input position 1~9:"))
    while (int(posi)<1 or int(posi)>9):
        posi = eval(input("Select input position 1~9:"))
    while (posi not in same):
        posi = eval(input(str(posi)+"填入過了:"))
    for i in range(0,len(same)-1):
        if (posi == same[i]):
            same.remove(posi)
    return posi

def user2():
    print("Users two's turn to input now.")
    posi = eval(input("Select input position 1~9:"))
    while (int(posi)<1 or int(posi)>9):
        posi = eval(input("Select input position 1~9:"))
    while (posi not in same):
        posi = eval(input(str(posi)+"填入過了:"))
    for i in range(0,len(same)-1):
        if (posi == same[i]):
            same.remove(posi)
    return posi

graph = [[' ' for _ in range(3)] for _ in range(3)]
def position(posi,user):
    if (user % 2 == 0):
        user = 'o'
    elif (user % 2 == 1):
        user = 'x'
    "print(user)"
    if (posi == 1):
        graph[0][0] = user
    elif (posi == 2):
        graph[1][0] = user
    elif (posi == 3):
        graph[2][0] = user
    elif (posi == 4):
        graph[0][1] = user
    elif (posi == 5):
        graph[1][1] = user
    elif (posi == 6):
        graph[2][1] = user
    elif (posi == 7):
        graph[0][2] = user
    elif (posi == 8):
        graph[1][2] = user
    elif (posi == 9):
        graph[2][2] = user

def winn (graph):
    for i in range (0,3):
        if (graph[0][i] == graph[1][i] == graph[2][i] != ' '):
            if (graph[0][0] == "o"):
                return "user1"
            elif (graph[0][0] == "x"):
                return "user2"
    for i in range (0,3):
        if (graph[i][0] == graph[i][1] == graph[i][2] != ' '):
            if (graph[0][0] == "o"):
                return "user1"
            elif (graph[0][0] == "x"):
                return "user2"
    if (graph[0][0] == graph[1][1] == graph[2][2] != 0 or graph[2][1] == graph[1][1] == graph[0][2] != ' '):
        if (graph[0][0] == "o"):
            return "user1"
        elif (graph[0][0] == "x"):
            return "user2"
    return None
    

user = 0
win = 0
count = [user1()]
position (count[0],user)
for i in range(0,3):
    for j in range(0,3):
        print(graph[j][i],end = "")
    print("")
user += 1

while (win==0) :
    if (user % 2 == 0):
        count.append(user1())
        user += 1
    elif (user % 2 == 1):
        count.append(user2())
        "print(user2())"
        user += 1

    for i in range(0,len(count)):
        position(count[i],i)
    for i in range(0,3):
            for j in range(0,3):
                print(graph[j][i],end = "")
            print("")
    winner = winn(graph) 
    if (winner != None):
        print("遊戲結束",winner,"贏了")
        break



