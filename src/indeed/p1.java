package indeed;
import java.util.*;

public class p1 {
	public static int Q, N;
    public static void main(String args[] ) throws Exception {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str;
		if (in.hasNextLine()){
			str=in.nextLine();
		}
		else{
			return;
		}
		
		Q=Integer.parseInt(str);
		ArrayList<Integer> arr=preProcess(in);
		N=arr.size();
		ArrayList<Integer> result=new ArrayList<Integer>();
		Object[] array=arr.toArray();
		Arrays.sort(array);
		for(int i=1;i<Q;i++){
			double tmp=N*i/(double)Q;
			int idx=(int)Math.ceil(tmp);
			Integer quantile=(Integer)array[idx-1];
			result.add(quantile);
		}
		
		for(Integer ele: result)
		System.out.println(ele);
		
	}
	
	public static ArrayList<Integer> preProcess(Scanner in){
		ArrayList<Integer> arr=new ArrayList<Integer>();
		String line="";
		int num=0;
		if(in.hasNextLine()) {
			line=in.nextLine();
		}
		else{
			System.out.println("input format wrong");
		}
		num=Integer.parseInt(line);
		for(int i=0;i<num;i++){
			if(in.hasNextLine()) {
				line=in.nextLine();
				String[] s=line.split(" ");
				for(int j=0; j<Integer.parseInt(s[1]);j++){
					arr.add(Integer.parseInt(s[0]));
				}
			}
			else{
				System.out.println("input format wrong");
			}
		}
		return arr;
	}
		
		
	

}
