package twoSigma;
import java.io.*;
import java.util.*;


public class p2 {

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
		
		HashSet<Integer> dataSets=new HashSet<Integer>();
		ArrayList<HashSet<Integer>> list=new ArrayList<HashSet<Integer>>();
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		preProcess(in, dataSets, list, map,Integer.parseInt(str));
		
		ArrayList<String> result=new ArrayList<String>();
		process(dataSets, list, result, map);
		for(String res: result){
			System.out.println(res);
		}
		System.out.println("done");
//		System.out.println(dataSets.toString());
//		
//		for(HashSet s: list){
//			System.out.println(s.toString());
//		}

		
		
		
	}
	
	public static void preProcess(Scanner in,HashSet<Integer> dataSets, ArrayList<HashSet<Integer>> list,HashMap<Integer, Integer> map, int num){
		String line="";
		String[] arr;
		int center=1;
		while(num!=0){
			if(in.hasNextLine()){
				line=in.nextLine();
				arr=line.split(" ");
				HashSet<Integer> set=new HashSet<Integer>();
				for(int i=1; i<arr.length;i++){
					int cur=Integer.parseInt(arr[i]);
					if(map.get(cur)==null){
						map.put(cur, center);
					}
					if(!dataSets.contains(cur)){
						dataSets.add(cur);
					}
					set.add(cur);
				}
				list.add(set);
			}
			else{
				System.out.print("done");
				break;
			}
			num--;
			center++;
		}
	}
	
	public static void process(HashSet<Integer> dataSets, ArrayList<HashSet<Integer>> list, ArrayList<String> result, HashMap<Integer, Integer> map){
		String line="";
		for(int i=0; i<list.size();i++){
			HashSet<Integer> set=list.get(i);
			for(Integer ele: dataSets){
				if(!set.contains(ele)){
					line=ele+" "+map.get(ele)+ " "+(i+1);
					
					result.add(line.trim());
				}
			}
		}
		
		
	}
	

}
