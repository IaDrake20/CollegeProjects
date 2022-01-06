

public class RecursiveMethods {

    public static void countUp(int n){

        if(n > 1){
            countUp(n-1);
        }

        System.out.println(n);
    }

    public static int factorial(int n){

       if(n == 0){
           return 1;
       }
       else {
           return (n * factorial(n-1));
       }
    }

    public static boolean isPalindrome(String s){

        int numChars = s.length();

        if(numChars == 0 || numChars == 1) {
            return true; 
        }

        else if(s.toLowerCase().charAt(0) == s.toLowerCase().charAt(numChars-1)){
            return isPalindrome(s.substring(1, numChars-1));
        }

    return false;    
    }

    //compare first and last 
    public static int largest(int[] nArr, int i, int m){
          
            if(i == nArr.length){
                return m;
            }

            if (nArr[i] > m){
                m = nArr[i];
            }
            return largest(nArr, i + 1,m);
    }

    public static int frequency(int[] nArr, int n, int a, int freq){
        int leng = nArr.length -1;

        if(a == leng && nArr[a] == n){
            ++freq;
            return freq;
        }

        if(a < leng && nArr[a] != n){
            return frequency(nArr, n, a+1, freq);
        }

        if( nArr[a] == n && a <= leng){
            //add 1 to return frequency
            freq +=1;
            
            //recurse to next with a+1
            return frequency(nArr, n, a+1, freq);
        }
        return freq;
    }

    public static void main(String[]args){
        countUp(21);

        System.out.println("The factorial of 9 is "+factorial(9));

        System.out.println("Is Radar a palindrome? "+isPalindrome("RaDdAr"));
        System.out.println("Is RaDdar a palindrome? "+isPalindrome("RaDdar"));
        System.out.println("Is Raddr a palindrome? "+isPalindrome("Raddr"));
        System.out.println("Is radgar a palindrome? "+isPalindrome("radgar"));

        int[] p = {1, 9, 2, 7, 2, 11, 8, 10, 2, 5};
        int[] f = {11, 5, 6, 2, 9, 7, 5};
        int[] g = {5, 6, 2, 9, 7, 5, 11};
        System.out.println("The largest of the array is "+largest(p, 0, 0));
        System.out.println("The largest of the array is "+largest(f, 0, 0));
        System.out.println("The largest of the array is "+largest(g, 0, 0));

        
        System.out.println("The frequency of 2 is "+frequency(p, 2, 0, 0));
        System.out.println("The frequency of 8 is "+frequency(p, 8, 0, 0));
        System.out.println("The frequency of 4 is "+frequency(p, 4, 0, 0));
    }
}
