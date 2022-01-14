public class Main{
    public static void main(String[] args){
        int [] arr = new int[] {1, 2, 3};
        
        int val = 1;
        
        for(int i = 0; i < arr.length; i++){
          val *= (1 + arr[i]);
          }
          
          return val - 1;
          
}
}

//TC: O(n) formulae-> ((1+a)(1+b)(1+c) - 1)
//SC: O(1)
