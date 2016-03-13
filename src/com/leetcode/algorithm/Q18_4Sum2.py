class Q18_4Sum(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        result = []
        nums.sort()
        if(len(nums)<4):
            return result
        for i in range(0,len(nums)-3):
            #avoid duplication
            if(i > 0 and nums[i-1] == nums[i]):
                continue;
            intrm = self.__threeSum(nums[i+1:], target-nums[i])
            if(len(intrm) != 0):
                for lst in intrm:
                    lst.insert(0,nums[i]);
                    result.append(lst)
        return result
        
                
    def __threeSum(self,nums, target):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result =[]
        if(len(nums)<=2):
            return result
        for i in range(0,len(nums)-2):
            if(i>0 and nums[i-1] == nums[i]):
                continue
            L, H = i+1, len(nums)-1 
            while(L < H):
                sum = nums[i]+nums[L]+nums[H]
                if(sum == target):
                    result.append([nums[i], nums[L], nums[H]])
                    while(L<H and nums[L]==nums[L+1]):
                        L+=1
                    while(L<H and nums[H]==nums[H-1]):
                        H-=1
                    L += 1
                    H -= 1
                elif(sum > target):
                    H -= 1
                else:
                    L += 1
        return result