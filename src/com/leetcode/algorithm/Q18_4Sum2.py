class Solution(object):
    def fourSum1(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        '''
        here we use the 3Sum which already implemented in last exercise, to solve 4Sum problem.
        Moreover, inspired by the way we solve 4Sum, I further implement FindNSum using recursion,
        deducting NSum to 2Sum
        runtime: 300ms
        '''
        result = []
        nums.sort()
        
        if(len(nums)<4):
            return result
        # Key step to reduce runtime
        if(nums[0]*4 > target or nums[len(nums)-1]*4 < target):
            return result
        
        for i in range(0,len(nums)-3):
            #avoid duplication
            if(i > 0 and nums[i-1] == nums[i]):
                continue;
            #to reduce memory usage, we can just pass index to __threeSum instead of a new list -> nums[i+1:]
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
        if(nums[0]*3 > target or nums[len(nums)-1]*3 < target):
            return result
        for i in range(0,len(nums)-2):
            if(i>0 and nums[i-1] == nums[i]):
                continue
            L, H = i+1, len(nums)-1 
            while(L < H):
                sum = nums[i]+nums[L]+nums[H]
                if(sum == target):
                    result.append([nums[i], nums[L], nums[H]])
                    #two while here is used to skip duplication
                    while(L<H and nums[L]==nums[L+1]):
                        L+=1
                    while(L<H and nums[H]==nums[H-1]):
                        H-=1
                    L += 1
                    H -= 1
                elif(sum > target):
                    #while phase here is used to reduce runtime
                    while(L<H and nums[H]==nums[H-1]):
                        H-=1
                    H -= 1
                else:
                    #reduce runtime
                    while(L<H and nums[L]==nums[L+1]):
                        L+=1
                    L += 1
        return result
    
    '''
    recursive version, runtime 120ms
    '''
    def fourSum2(self, nums, target):
        def findNsum(nums, target, N, result, results):
            if len(nums) < N or N < 2 or target < nums[0]*N or target > nums[-1]*N:  # early termination
                return
            if N == 2: # two pointers solve sorted 2-sum problem
                l,r = 0,len(nums)-1
                while l < r:
                    s = nums[l] + nums[r]
                    if s == target:
                        results.append(result + [nums[l], nums[r]])
                        l += 1
                        while l < r and nums[l] == nums[l-1]:
                            l += 1
                    elif s < target:
                        l += 1
                    else:
                        r -= 1
            else: # recursively reduce N
                for i in range(len(nums)-N+1):
                    if i == 0 or (i > 0 and nums[i-1] != nums[i]):
                        findNsum(nums[i+1:], target-nums[i], N-1, result+[nums[i]], results)
    
        results = []
        findNsum(sorted(nums), target, 4, [], results)
        return results