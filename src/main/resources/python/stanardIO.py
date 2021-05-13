import sys
import time
line = sys.stdout.readline()
fo=open("D:/IdeaProjects/ScalaPython/src/main/resources/a.txt","w")
fo.write('python starts at: %.0f\n'%(time.time()*1000))
fo.write(line+"\n")
fo.write('python ends at: %.0f\n'%(time.time()*1000))
fo.close()