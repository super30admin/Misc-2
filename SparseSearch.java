

// Java program to implement binary search 
// in a sparse array. 

class solution 
{ 

// Binary Search in an array with blanks 
static int binarySearch(String arr[], int low, int high, String x) { 
if( low > high) return -1;

int mid = low + (high-low)/2;   

if(arr[mid].compareTo("")==0){
int left = mid-1;
int right = mid+1;

//Find closest non-empty string in left and right
while(true){
     if(left<low && right > high) return -1;
    else if(left >= low && arr[left].compareTo("")!=0){
        mid = left;
        break;
    }else if(right <= high && arr[right].compareTo("")!=0){
        mid =right;
        break;
    }
    left--;
    right++;
}
}

if(arr[mid].compareTo(x) == 0) return mid;

else if(arr[mid].compareTo(x) > 0) 
    return binarySearch(arr,low,mid-1,x);
else if (arr[mid].compareTo(x) < 0) 
    return binarySearch(arr,mid+1,high,x);
}

static int sparseSearch(String arr[], String x, int n) { 
return binarySearch(arr, 0, n - 1, x); 
} 
/* Normal Binary Search */


static int sparseSearch(String arr[], String x, int n) { 
return binarySearch(arr, 0, n - 1, x); 
} 

public static void main(String args[]) { 

String arr[] = {"vinu", "manu", "", "", "", "", "anu", 
					"tinu", "", "", "", "sinu"}; 
String x = "tinu"; 
int n = x.length(); 
int index = sparseSearch(arr, x, n); 
if (index != -1) 
	System.out.println(x+ " found at index "+index); 
else
	System.out.println(x+" not found"); 

} 

