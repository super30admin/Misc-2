#Time - O(n)
#Space - O(1)
def productOfSubsetSums(arr):
    result = 1;
    for n in arr:
        result = result*(n+1)
        
    return result-1

arr = [1, 2, 3]

 
print (productOfSubsetSums(arr))