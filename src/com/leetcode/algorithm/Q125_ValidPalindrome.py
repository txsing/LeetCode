#!/Library/Frameworks/Python.framework/Versions/3.5/bin/python3
class Solution(object):
    def isPalindrome(self, s):
        L, R = 0,len(s)-1
        if R==0:
            return True
        while(L<=R):
            i, j = ord(s[L]), ord(s[R])
            if(i<65 or (i>90 and i<97) or i>122):
                L+=1;continue
            if(j<65 or (j>90 and j<97) or j>122):
                R-=1;continue
            if(i != j and abs(i-j) != 32):
                return False;
            L+=1;R-=1;
        return True
a = Solution()
print (a.isPalindrome("race e car"))

