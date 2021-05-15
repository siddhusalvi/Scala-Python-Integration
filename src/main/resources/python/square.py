import sys
inputData = sys.stdin.readline()
if(inputData.strip().isnumeric()):
    number = int(inputData) * 2
    print(inputData+" "+number)
else:
    print(inputData)