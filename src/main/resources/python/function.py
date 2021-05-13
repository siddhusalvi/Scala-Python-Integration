def function(givenInput):
    data = givenInput.replace('_',' ').split()
    if(len(data) == 2):
        num1 = int(data[0])
        num2 = int(data[1])
        result = num1 + num2
        print(result)
import time
import sys
# input = sys.stdin.read()
input = sys.argv[1]
time.sleep(10)
function(input)
