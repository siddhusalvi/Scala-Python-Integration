#{"nums":[10,20,30,40]}
import sys
import json
import statistics
from types import SimpleNamespace


#class to load json into object
class LoadJson(object):
    def __init__(self, str):
        self.__dict__ = json.loads(str)

#Function to calculate Standard Deviation
def calculate_std(obj):
    print(statistics.stdev(obj.nums))

inputData = sys.stdin.read()
# inputData = sys.argv[1]
#inputData = input()
print(inputData)

# jsonObj = json.loads(inputData)
#
# obj = LoadJson(inputData)
# calculate_std(obj)

