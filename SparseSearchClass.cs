class HelloWorld {
    /*
    Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.
Examples:
Input : arr[] = {"for", "geeks", "", "", "", "", "ide", 
                      "practice", "", "", "", "quiz"}
          x = "geeks"
Output : 1

Input : arr[] = {"for", "geeks", "", "", "", "", "ide", 
                      "practice", "", "", "", "quiz"}, 
          x = "ds"
Output : -1

//TC => O(n)
//SC => O(1)
    */
    
    static int BinarySearch(string[] allWords, string x){
        int low = 0;
        int high = allWords.Length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(allWords[mid] == ""){
                int left = mid - 1;
                int right = mid + 1;
                while(true){
                    if(left > low && right > high){
                        return -1;
                    }
                    if(left >= low && allWords[left] != ""){
                        mid = left;
                        break;
                    }
                    if(right <= high && allWords[right] != ""){
                        mid = right;
                        break;
                    }
                    left++;
                    right--;
                }
                if(allWords[mid].Equals(x)){
                    return mid;
                }
                else if(x.CompareTo(allWords[mid]) < 0){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
    static void Main() {
        string[] allWords = ["for", "geeks", "", "", "", "", "", "","", "quiz"];
        string x = "geeks";
        
        Console.WriteLine(BinarySearch(allWords, x));
    }
}