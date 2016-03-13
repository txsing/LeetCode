class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        result = []
        if(len(nums)<4):
            return result
        for i in range(0,len(nums)-3):
            if(nums[i]>target):
                break;
            #avoid duplication
            if(i > 0 and nums[i-1] == nums[i]):
                continue;
            intrm = threeSum(nums[i:], target-nums[i])
            if(len(intrm) != 0):
                for lst in intrm:
                    print(lst)
                    result.append(nums[i]+lst);
        return result
        
                
    def threeSum(nums, target):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result =[]
        nums.sort()
        if(len(nums)<=2):
            return result
        for i in range(0,len(nums)-2):
            if(nums[i]>target):
                break
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