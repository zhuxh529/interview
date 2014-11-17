package epic;
import java.util.*;
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ke> sem1=sem11("A","A-","B");
		sem s1=new sem(sem1);
		System.out.println(s1.hr+"  "+s1.pt+"  "+s1.gpa);
		ArrayList<ke> sem2=sem22("A-","A-","B");
		ArrayList<ke> acc=new ArrayList<ke>();

		sem s2=new sem(sem2);
		System.out.println(s2.hr+"  "+s2.pt+"  "+s2.gpa);
		
		acc.addAll(sem2);acc.addAll(sem1);
		sem s12=new sem(acc);
		System.out.println(s12.hr+"  "+s12.pt+"  "+s12.gpa);

		
		

		
	}
	
	public static void semeter(ArrayList<ke> list){
		
	}
	
	public static ArrayList<ke> sem11(String k1, String k2, String k3){
		ArrayList<ke> list=new ArrayList<ke>();
		ke ke1=new ke("comp429",k1,4);
		ke1.print();
		ke ke2=new ke("comp510",k2,4);
		ke2.print();

		ke ke3=new ke("comp560",k3,4);
		ke3.print();

		list.add(ke1);list.add(ke2);list.add(ke3);
		return list;

	}
	
	public static ArrayList<ke> sem22(String k1, String k2, String k3){
		ArrayList<ke> list=new ArrayList<ke>();
		ke ke1=new ke("comp482",k1,3);
		ke ke2=new ke("comp498",k2,3);
		ke ke3=new ke("comp502",k3,3);
		ke1.print();
		ke2.print();
		ke3.print();

		list.add(ke1);list.add(ke2);list.add(ke3);
		return list;

	}
	

}
