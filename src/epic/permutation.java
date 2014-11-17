package epic;

public class permutation {
	public static void main(String[] args) {
		String orig="012345";
		//perm("", orig, 4);
		String num="1";
		for (int i=1;i<=10;i++) {
			System.out.println(num);
			num = lookandsay(num);             
		}
	}
	
	public static void perm(String res, String digit, int n){
		if(n==0) System.out.println(res);
		String tmp="";
		for (int i = 0; i < digit.length(); ++i) {
			tmp=digit;
			tmp=tmp.replace(String.valueOf(digit.charAt(i)),"");
			perm(res+digit.charAt(i), tmp, n-1);
			
		}
	}
	
	public static String lookandsay(String number){
		StringBuilder result= new StringBuilder();
	 
		char repeat= number.charAt(0);
		number= number.substring(1) + " ";
		int times= 1;
	 
		for(char actual: number.toCharArray()){
			if(actual != repeat){
				result.append(times + "" + repeat);
				times= 1;
				repeat= actual;
			}else{
				times+= 1;
			}
		}
		return result.toString();
	}

}
