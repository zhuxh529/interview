package twoSigma;

import java.util.*;

public class p1 {

    public static void main(String args[] ) throws Exception {
		Scanner in = new Scanner(System.in);
		String str;
		if (in.hasNextLine()){
			str=in.nextLine();
		}
		else{
			return;
		}
//		str=in.nextLine();
//		str="car truck 8 4 bus 6 -1";
		String[] arr=str.split(" ");
		if(arr.length==0){
			System.out.print("");
			return;
		}
		ArrayList<String> strList=new ArrayList<String>();
		ArrayList<Integer> numList=new ArrayList<Integer>();
		
		//flag array indicating at index i element is number or not
		ArrayList<Boolean> flagList=new ArrayList<Boolean>();

		for(String ele: arr){
			boolean num=isNumeric(ele);
			flagList.add(num);
			if(num){
				numList.add(Integer.parseInt(ele));
			
			}
			else{
				strList.add(ele);
			}
		}
		
		
		Object[] wordArr=strList.toArray();
		Arrays.sort(wordArr);
		Object[] numArr=numList.toArray();
		Arrays.sort(numArr);
		
		Object[] resultArr=new Object[flagList.size()];
		int x=0, y=0;//indexes for wordArr and numArr
		
		for(int i=0; i<flagList.size();i++){
			if(flagList.get(i)){
				resultArr[i]=numArr[x++];
			}
			else{
				resultArr[i]=wordArr[y++];
			}
		}
		
		output(resultArr);		
		
		
	}
	

	
	public static boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}
	
	public static void output(Object[] arr){
		String out="";
		for(Object ele: arr){
			out+=ele.toString()+" ";
		}
		out=out.trim();
		System.out.print(out);
		
	}
	
}