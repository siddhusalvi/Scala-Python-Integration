import sys
inputData = sys.stdin.readline()
if(inputData.strip().isnumeric()):
    number = int(inputData) ** 2
    print(number)
else:
    print(inputData)