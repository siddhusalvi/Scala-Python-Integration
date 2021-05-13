import sys
inputData = sys.stdin.readline()
number = int(inputData)
while(inputData != "0\n"):
    sys.stdout.write(str(number)+"\n")
    sys.stdout.flush()
    inputData = sys.stdin.readline()
    number = number + int(inputData)
log=open("D:/IdeaProjects/ScalaPython/src/main/resources/a.txt","w")
log.write("done "+str(number))
log.close()