#!/Library/Frameworks/Python.framework/Versions/3.5/bin/python3

#To find the element which occupies more than half of the array,
#there is no need to calculate the frequency of every elements, 
#otherwise we do not make full use of the precondition: frequency(target)>0.5 * len(array)
#Offset Method, O(n)
class Solution(object):
	def majorityElement(self, A):
		major,count = A[0], 1;
		for i in range(1,len(A)):
			if(count == 0):
				major = A[i]; count=1
			elif(A[i] == major):
				count+=1
			else:
				count-=1;
		return major
			
