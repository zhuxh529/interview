package google;
import java.util.*;

public class testJava {
	public static void main(String[] args) {
//		HashMap map=new HashMap();
//		HashSet set=new HashSet();
//		ArrayList list=new ArrayList();
//		
//		Hashtable table=new Hashtable();
//		testHashMap();
//		
//		int foo = Integer.parseInt("1234");
//		String a=""+1234;
		char[] a={'a', 'b', 'c', 'd', 'e'};
		char[] b= {'a', 'c', 'd'};
		System.out.println(findMissing(a,b));
		
		test1();
		test2();
		
		
	}
	

	
	public static void test1(){

	}
	
	
	
	public static void test2(){
		
	}
	
	
	public static List<Integer> findMissing(char[] src, char[] cpy) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		int idx=0;
		for(int i=0; i<src.length;i++){
			
			if(idx>cpy.length-1 || src[i]!=cpy[idx]){
				list.add(i);
			}
			else{ 
				idx++;
			}
		}

		return list;
		}

	
	public static void testHashMap(){
		HashMap<Integer, ArrayList> map=new HashMap<Integer, ArrayList>();
		ArrayList list=new ArrayList();list.add(1);list.add(2);
		map.put(1,list);
		ArrayList list1=new ArrayList();list1.add(3);list1.add(4);
		map.put(3,list1);
		
		
		System.out.println(map.toString());
		
		ArrayList tmp=map.get(1);
		tmp.add(3);
		System.out.println(map.toString());
		
	}
	

}
