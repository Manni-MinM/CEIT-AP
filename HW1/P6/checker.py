import sys
import random

# Gets ID of testcase and return the testcase
def func(ID) :
	inputFile = open("input.txt" , "w")
	# Write checker program here
	random.seed(ID)
	binary = ""
	for i in range (0 , 8) :
		val = random.randint(0 , 1)
		if ( val == 0 ) :
			binary += '0'
		else :
			binary += '1'
	string = ""
	length = random.randint(3 , 10)
	for i in range(0 , length) :
		val = random.randint(0 , 25)
		string += chr(97 + val)
	inputFile.write(binary + "\n")
	inputFile.write(string + "\n")
	# End of checker code
	inputFile.close()

# Get ID of testcase
args = sys.argv
ID = int(args[1])

# write test to file
func(ID)

