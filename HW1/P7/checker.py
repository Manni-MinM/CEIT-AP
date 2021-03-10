import sys
import random

# Gets ID of testcase and return the testcase
def func(ID) :
	inputFile = open("input.txt" , "w")
	# Write checker program here
	length = 2
	charNum = 3
	random.seed(ID)
	string1 = ""
	string2 = ""
	for i in range(0 , length) :
		val = random.randint(0 , charNum - 1)
		string1 += chr(97 + val)
		val = random.randint(0 , charNum - 1)
		string2 += chr(97 + val)
	inputFile.write(string1 + "\n")
	inputFile.write(string2 + "\n")
	# End of checker code
	inputFile.close()

# Get ID of testcase
args = sys.argv
ID = int(args[1])

# write test to file
func(ID)

