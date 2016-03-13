class Q9_PalindromeNumber(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        
        '''
        if we just reverse the integer, then we will need solve overflow problem
        which is unnecessary cos our target is just verify the palindrome
        e,g,. 135531 we just need to reverse 531 and verify whether reverse(531) == 135 or not 
        since we dont know the digits of input integer, so here we verify whether
        reverse(35531) == 13553, which can at least avoid overflow during reverse. 
        '''
        q = x
        tail = 0
        intrm = 0
        
        #if x is negative or a multiple of 10 then false 
        if(x < 0 or (x%10 == 0 and x <> 0)):
            return False
        
        # should be q >= power(10, floor(length(x)/2)) if we know length(x)
        while(q >= 10):
            tail = q%10
            q = q/10
            intrm = intrm * 10 + tail
        
        if(intrm == x/10):
            return True
        return False