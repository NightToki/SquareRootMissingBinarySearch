package binarySearch2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class SqrtMissingBinary {
	public static int missBinary(int[]a,int low, int high) {
		
		if (low > high) 
            return high + 1; 
  
        if (low != a[low]) 
            return low; 
  
        int mid = (low + high) / 2; 
  
        if (a[mid] == mid) 
            return missBinary(a, mid+1, high); 
  
        return missBinary(a, low, mid); 
		
		
	}
	public static void bubbleSort(int[]a) {
		int n = a.length;
		int temp = 0;
		  for(int i=0; i < n; i++){  
              for(int j=1; j < (n-i); j++){  
                       if(a[j-1] > a[j]){  
                              temp = a[j-1];  
                              a[j-1] = a[j];  
                              a[j] = temp;  
                      }       
              }  
      }  
		
	}
	public static int[] call(int n) {
		
		Scanner userInt = new Scanner(System.in); 
		Random rand = new Random(); 
	
		int[] a = new int[n];
		for(int i = 0; i <n;i++) {
			a[i] = rand.nextInt(a.length);
		}
		bubbleSort(a);
		return a;
		
	}
	public static int sqrt(int n) {
		if(n==0||n==1) {
			return n;
		}
		int i = 1;
		int result = 1;
		while (result <=n) {
			i++;
			result = i*i;
		}
		if(n == i*i) {
			return i-1;
			
		}
		else {
			return i;
		}
		
}
	public static int sqrtBinary(int n) {
		if(n==0||n==1) {
			return n;
		}
		int result = 0;
		int start = 1;
		int end = n/2;
		while(start <=end) {
			int middle = (start+end)/2;
			int sqrt = middle*middle;
			if(sqrt==n) {
				return middle;
			}
			else if(sqrt <n) {
				start = middle+1;
				result = middle;
			}
			else {
				end = middle-1;
			}
			
			
		}
		if(n == result*result) {

			return result;
		}
		else {
	
			return result+1;
		}
		
				

		
	}
	
	
	public static void main(String[] args) {
	System.out.println("partA");
	Scanner userInt = new Scanner(System.in);
	boolean loop = true;
	int n = 0;
	while(loop == true){
		System.out.println("Enter a valid positive integer: ");
		 n = userInt.nextInt();
		if(n<0) {
			System.out.println("Not valid positive integer");
			loop=true;
		}
		else {
			loop =false;
		}
	}
	
	System.out.println("The sqrt of n is: "+sqrtBinary(n));
	System.out.println("partB");
	int[] a;
	a = call(n);
	int x = missBinary(a,0, a.length-1);
	System.out.println(Arrays.toString(a));
	System.out.println("missing lowest number is:"+ x);
	

}

}