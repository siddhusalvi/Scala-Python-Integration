import sys
import time
if __name__=="__main__":
        fo=open("D:/IdeaProjects/ScalaPython/src/main/resources/a.txt","w")
        line = sys.stdin.readline()
        while(line != "x\n"):
                fo.write(line)
                line = sys.stdin.readline()
        fo.close()