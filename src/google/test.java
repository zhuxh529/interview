package google;
import java.util.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={-1,3,-4,5,1,-6,2,1};
		System.out.println(Arrays.toString(arr));
		
		System.out.println(solution2(arr));
	}
	
	public static int solution(int A, int B) {
	    // write your code in C90
		int counter=0;
		int sqrt;
		for(int i=A; i<=B;i++){
			sqrt=(int)Math.sqrt(i);
			if(sqrt*sqrt==i) counter++;
			
		}
		return counter;
	}
	
	
	public static int solution2(int[] A) {
		Arrays.sort(A); //O(n*log(n)), dont wanna write my own mergesort since I can only write code in one functions
		int low=0, high=0;
		int gap=0;;
		int Y;
		for(int i=0;i<A.length-1;i++){
			if(A[i+1]-A[i]>gap){
				gap=A[i+1]-A[i];
				low=A[i];
				high=A[i+1];
			}
		}
		
		Y=(low+high)/2;//no use here, just for demonstrate Y
		
		return gap/2;
		
        
	}

}
