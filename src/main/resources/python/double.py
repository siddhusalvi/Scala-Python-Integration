import sys
import time
def fetchValueFromKafka(kafkaRecord):
    word = kafkaRecord.split("value =")[-1].split(")")[0].strip()
    return word
line = sys.stdin.readline()
time.sleep(2)
inputData =fetchValueFromKafka(line)
# fo=open("D:/IdeaProjects/ScalaPython/src/main/resources/a.txt","a")
# fo.write("===============\n")
# fo.write(line)
# fo.write("===============\n")
# fo.close()
if(inputData.strip().isnumeric()):
    number = int(inputData) * 2
    print(inputData+" "+str(number))
else:
    print(inputData+"null")