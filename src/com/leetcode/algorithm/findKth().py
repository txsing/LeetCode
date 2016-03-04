#!/Library/Frameworks/Python.framework/Versions/3.5/bin/python3

#o(log(min(m,n)))
#this algorithm is inspired by Q4_Find Median of Two Sorted Array
#we divide both A into 2 parts ==> A[1,i] and A[i+1, n]
#the same goes for B ==>B[1,j] and B[j+1,m]
#i+j ==k and A[i]<=B[j+1] and B[j]<=A[j+1]
def findKth(A,B,k):
  m, n = len(A), len(B)
  if m > n:
    A, B, m, n = B, A, n, m
  if k > m+n:
    raise ValueError
  
  L, R = 0, m
  while L<=R:
    i = (L+R)>>1;
    j = k-i;
    if(j>0 and i<m and B[j-1]>A[i]):
    	L=i+1
    	continue
    if(i>0 and j<n and A[i-1]>B[j]):
    	R=i-1
    	continue
    #now i is perfect
    if(i==0):
    	return B[k-1]
    elif(j==0):
    	return A[k-1]
    else:
    	return max(A[i-1],B[j-1])

#o(log(m,n))
def findKth2():
    return 0

A, B= [7,8,9], [1,2,3,4]
print(findKth(A,B,5))
