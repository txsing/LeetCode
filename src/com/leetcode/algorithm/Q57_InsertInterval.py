#!/Library/Frameworks/Python.framework/Versions/3.5/bin/python3
class Solution(object):
    def insert(self, intervals, newInterval):
        array = ()
        result = []
        for itv in intervals:
            array = array + (itv.start,itv.end)
        if(len(intervals)==0):
            return [newInterval]
        L = self.locate(array, newInterval.start)
        R = self.locate(array, newInterval.end)
        leftitv = (L+1)/2
        rightitv = (R+2)/2
        if(L%2 == 0):
            newInterval.start = intervals[L/2].start
        if(R%2 == 0):
            newInterval.end = intervals[R/2].end
        for i in range(leftitv):
            result.append(intervals[i])
        j = leftitv
        result.append(newInterval)
        for i in range(j,len(intervals)):
            if(i<=rightitv-1):
                continue
            result.append(intervals[i])
        return result


    def locate(self,array, val):
        L, R = 0, len(array)-1
        if(val<array[0]):
            return -1	
        if(val>array[R]):
            return R
        while(L<R-1):
            M = (L+R)/2
            mid = array[M]
            if(val==mid):
                if(M%2!=0):
                    return M-1
                else:
                    return M
            if(val>mid):
                L=M
            else:
                R=M
        return L
        
