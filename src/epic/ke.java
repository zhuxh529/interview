package epic;
import java.util.*;
public class ke {
	public HashMap<String, Double> map=new HashMap<String, Double>();
	public String name="";
	public String grade="";
	public int hr=0;
	public double pt=0.0;
	public ke(String n, String g,int h){
		buildMap();
		name=n;
		grade=g;
		hr=h;
		pt=hr*map.get(g);
	}
	
	public void print(){
		System.out.println(name+" "+grade+" "+hr+"  "+pt);
	}
	
	public void buildMap(){
		map.put("A",4.0);
		map.put("A-",3.67);
		map.put("B+",3.33);
		map.put("B",3.00);
		map.put("B-",2.67);
		map.put("C+",2.33);
		map.put("C",2.00);
		map.put("C-",1.67);
		
	}
}
