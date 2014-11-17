package google;
import java.util.*;
public class struct1 {
	public HashMap<Integer, Integer> map;
	public ArrayList<Integer> list;
			
	public struct1(){
		map= new HashMap<Integer, Integer>();
		list=new ArrayList<Integer>();
	}

	public void insert(int v){
		list.add(v);
		map.put(v, list.size()-1);
		
	}
	
	public void remove(int v){
		if(map.get(v)!=null){
			list.remove(map.get(v));
			map.remove(v);
		}
		
	}
	
	public boolean contains(int v){
		return map.get(v)==null?false:true;
		
	}
	
	public int getRandom(){
		return list.get(new Random().nextInt(list.size()));
		
	}
}
