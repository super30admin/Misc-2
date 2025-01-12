#Approach
#Find the mid of the array and if irt is "" the mid the left mid and right mid and upfate the low and high


#Complexities
#Time O(logn)
#Space: O(1)


# Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.
#
# Examples:
#
# Input : arr[] = {"for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"} x = "geeks" Output : 1
#
# Input : arr[] = {"for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"}, x = "ds"
#
# Output : -1


class Solution:


    def findString(self,strings,query):
        pos = self.binarySearch(strings,query,0,len(strings)-1)
        return pos



    def binarySearch(self,strings,query,low,high):

        while low<=high:
            mid = (low+high)//2
            if strings[mid] =="":
                leftmid  = -1
                for i in range(mid,low-1,-1):
                    if strings[i]!="":
                        leftmid = i
                        break
                rightmid = -1
                for i in range(mid+1,high+1):
                    if strings[i]!="":
                        rightmid = i
                        break
                if leftmid <0 and rightmid<0:
                    return -1

                if leftmid>0 and strings[leftmid]==query:
                    return leftmid
                if rightmid > 0 and strings[rightmid] == query:
                    return rightmid
                if leftmid>0 and strings[leftmid]<query and ((rightmid>0 and strings[rightmid]>query) or rightmid<0):
                    return -1
                if leftmid>0 and strings[leftmid]<query and rightmid>0 and strings[rightmid]<query:
                    low =rightmid+1
                if leftmid>0 and strings[leftmid]>query:
                    high = leftmid-1


            elif strings[mid]==query:
                return query
            elif strings[mid]<query:
                low=mid+1
            else:
                high=mid-1



        return -1


s = Solution()
#print(s.findString(["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"],"geeks"))
print(s.findString(["a", "", "", "", "", "", "", "", "", "", "b"],"b"))