package evernote;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class p1 {

	public static void main(String[] args) {
		ArrayList<String> arr;
		String str="hello, hello, hello goog, as sda dsa, goog hello shoot shoot, shoot shoot shoot, shoot, sheet, dam dam, whos wos";
		arr=topKWords(str,6);
		System.out.println(arr.toString());
		
	}
	
	public static ArrayList<String> topKWords(String txt, int k){
		String lowcase=txt.toLowerCase();
		String[] words = lowcase.split("(?=[,.])|\\s+");
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		
		//O(n) time complexity
		for(String word : words){
			if(map.get(word)==null){
				map.put(word, 1);
			}
			else{
				map.put(word, map.get(word)+1);
			}
		}
		
		
		//O(1) time complexity
		filter(map);


//		System.out.println(map.toString());
		
		
		
		//O(n) time complexity
		int max=Integer.MIN_VALUE;
		for(int x: map.values()){
			if(x>max) max=x;
		}
		
		
		
		HashMap<Integer, ArrayList> reverseMap=new HashMap<Integer, ArrayList>();
		ArrayList<String> tmp;
		
		//O(n) time complexity
		for(String key: map.keySet()){
			if(reverseMap.get(map.get(key))!=null){
				tmp=reverseMap.get(map.get(key));
			}
			else{
				tmp=new ArrayList<String>();
			}
			tmp.add(key);
			reverseMap.put(map.get(key), tmp);
		}


		
		ArrayList<String> result=new ArrayList<String>();
		int key=max, count=0;
		//O(k) time complexity where k<=n
		while(key>=0){
			if(reverseMap.get(key)!=null){
				ArrayList<String> list=reverseMap.get(key);
				for(String ele :list){
					result.add(ele);
					count++;
					if(count==k) return result;
				}
				
			}
			key--;
		}
		
		//O(n)+O(n)+O(n)+O(1)+O(k) = O(n)
		return result;	
	}
	
	public static HashMap filter(HashMap map){
		map.remove(",");
		map.remove(".");
		map.remove("'");
		map.remove('"');
		map.remove(";");
		map.remove(":");
		map.remove("?");
		map.remove("!");
		
		return map;
		
	}
	

}
