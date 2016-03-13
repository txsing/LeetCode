class Q15_3Sum(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        
        '''
        The only challenging part is avoid duplicate combinations, e,g,. lst[-1, -1, 0, 1, 2]
        noted that when we start from {lst[0], lst[1:5]}, we already get all result combinations for the case where
        combination contains -1, so we need pass {lst[1], lst[2:5]}
        '''
        result =[]
        nums.sort()
        if(len(nums)<=2):
            return result
        for i in range(0,len(nums)-2):
            #if nums[i]>0, it is impossible to find target combination, sum > 0 for sure
            if(nums[i]>0):
                break
            #
            if(i>0 and nums[i-1] == nums[i]):
                continue
            L, H = i+1, len(nums)-1 
            while(L < H):
                sum = nums[i]+nums[L]+nums[H]
                if(sum == 0):
                    #consider [-1, -1, -1, -1, -1, 0, 1, 2], we jump from {lst[0],lst[1:8]} to {lst[0], lst[6:8]} directly
                    #to avoid duplicate combinations
                    result.append([nums[i], nums[L], nums[H]])
                    while(L<H and nums[L]==nums[L+1]):
                        L+=1
                    while(L<H and nums[H]==nums[H-1]):
                        H-=1
                    L += 1
                    H -= 1
                elif(sum > 0):
                    H -= 1
                else:
                    L += 1
        return result